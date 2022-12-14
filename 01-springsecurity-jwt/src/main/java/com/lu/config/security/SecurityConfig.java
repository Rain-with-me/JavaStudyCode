package com.lu.config.security;

import com.lu.component.JwtAuthenticationTokenFilter;
import com.lu.component.RestAuthenticationEntryPoint;
import com.lu.component.RestfulAccessDeniedHandler;
import com.lu.dao.entity.UmsAdmin;
import com.lu.dao.entity.UmsPermission;
import com.lu.dao.vo.AdminUserDetails;
import com.lu.service.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;

/**
 * @Author: éšćæ
 * @Description:
 * @DateTime: 2022/9/4 10:05
 **/

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UmsAdminService umsAdminService;
    @Autowired
    private RestfulAccessDeniedHandler restfulAccessDeniedHandler;
    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;


    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    /** 
     * @Description: // ç±äșäœżçšçæŻJWTïŒæä»ŹèżéäžéèŠcsrf
     *               // ćșäștokenïŒæä»„äžéèŠsession,éŁäžȘæŻäžćć»șsession,ćŻä»„ćèæșç è§Łæ
     *               // ææéçœź
     * @Author: éšćæ
     * @DateTime: 2022/9/4 10:31
    */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests().antMatchers(HttpMethod.GET, // ćèźžćŻčäșçœç«éæè”æșçæ ææèźżéź
                "/",
                "/*.html",
                "/favicon.ico",
                "/**/*.html",
                "/**/*.css",
                "/**/*.js",
                "/swagger-resources/**",
                "/v2/api-docs/**").permitAll()
                .antMatchers("/admin/login", "/admin/register")// ćŻčç»ćœæłšćèŠćèźžćżćèźżéź
                .permitAll()
                .antMatchers(HttpMethod.OPTIONS)//è·šćèŻ·æ±äŒćèżèĄäžæŹĄoptionsèŻ·æ±
                .permitAll()
                .antMatchers("/**")//æ”èŻæ¶ćšéšèżèĄèźżéź
                .permitAll()
                .anyRequest()// é€äžéąć€çææèŻ·æ±ćšéšéèŠéŽæèź€èŻ
                .authenticated();

        // çŠçšçŒć­
        httpSecurity.headers().cacheControl();
        // æ·»ć JWT filter
        httpSecurity.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        //æ·»ć èȘćźäčæȘææćæȘç»ćœç»æèżć
        httpSecurity.exceptionHandling()
                .accessDeniedHandler(restfulAccessDeniedHandler)
                .authenticationEntryPoint(restAuthenticationEntryPoint);

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter(){
        return new JwtAuthenticationTokenFilter();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        //è·ćç»ćœçšæ·äżĄæŻ
        return username -> {
            UmsAdmin admin = umsAdminService.getAdminByUsername(username);
            if (admin != null) {
                List<UmsPermission> permissionList = umsAdminService.getPermissionList(admin.getId());
                return new AdminUserDetails(admin,permissionList);
            }
            throw new UsernameNotFoundException("çšæ·ćæćŻç éèŻŻ");
        };
    }


}
