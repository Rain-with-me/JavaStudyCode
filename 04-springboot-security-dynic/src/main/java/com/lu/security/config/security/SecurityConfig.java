package com.lu.security.config.security;

import com.lu.security.config.security.dynamicCompont.DynamicAccessDecisionManager;
import com.lu.security.config.security.dynamicCompont.DynamicSecurityFilter;
import com.lu.security.config.security.dynamicCompont.DynamicSecurityMetadataSource;
import com.lu.security.config.security.dynamicCompont.DynamicSecurityService;
import com.lu.security.config.security.securityCompont.JwtAuthenticationTokenFilter;
import com.lu.security.config.security.securityCompont.RestAuthenticationEntryPoint;
import com.lu.security.config.security.securityCompont.RestfulAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
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
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;

/**
 * @Author: ?????????
 * @Description:
 * @DateTime: 2022/9/17 20:19
 **/

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired(required = false)
    private DynamicSecurityService dynamicSecurityService;



    /**
     * @Description: // ??????????????????JWT????????????????????????csrf
     *               // ??????token??????????????????session,??????????????????session,????????????????????????
     *               // ????????????
     * @Author: ?????????
     * @DateTime: 2022/9/4 10:31
     */

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = httpSecurity
                .authorizeRequests();
        // ??????????????????????????????????????????
        for (String url : ignoreUrlsConfig().getUrls()) {
            registry.antMatchers(url).permitAll();
        }
        // ???????????????OPTIONS??????
        registry.antMatchers(HttpMethod.OPTIONS)
                .permitAll();
        // ???????????????????????????????????????
        registry.and()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                // ????????????????????????????????????session
                .and()
                .csrf()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                // ??????????????????????????????
                .and()
                .exceptionHandling()
                .accessDeniedHandler(restfulAccessDeniedHandler())
                .authenticationEntryPoint(restAuthenticationEntryPoint())
                // ????????????????????????JWT?????????
                .and()
                .addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        //?????????????????????????????????????????????????????????
        if (dynamicSecurityService != null) {
            registry.and().addFilterBefore(dynamicSecurityFilter(), FilterSecurityInterceptor.class);
        }
    }
    
    /** 
     * @Description: ???????????????????????????,???????????????????????????????????????
     * UserDetails,????????????????????????,??????resource
     * @Author: ?????????
     * @DateTime: 2022/9/17 20:24
    */
    
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return username -> {
//            UmsAdmin umsAdmin = umsAdminService.getAdminUsername(username);
//            if (umsAdmin!=null) {
//                List<UmsPermission> list = umsAdminService.getPermissionList(umsAdmin.getId());
//                return new AdminUserDetails(umsAdmin,list);
//            }
//            throw new UsernameNotFoundException("???????????????????????????");
//        };
//    }

    @Bean
    public RestfulAccessDeniedHandler restfulAccessDeniedHandler() {
        return new RestfulAccessDeniedHandler();
    }

    @Bean
    public RestAuthenticationEntryPoint restAuthenticationEntryPoint() {
        return new RestAuthenticationEntryPoint();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /** 
     * @Description: ??????????????????????????????????????????
     * @Author: ?????????
     * @DateTime: 2022/9/17 21:28
    */
    
    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter(){
        return new JwtAuthenticationTokenFilter();
    }

    /**
     * @Description: ???????????????????????????
     * @Author: ?????????
     * @DateTime: 2022/9/20 8:58
    */
    @Bean
    public IgnoreUrlsConfig ignoreUrlsConfig() {
        return new IgnoreUrlsConfig();
    }

    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder());
    }



    @ConditionalOnBean(name = "dynamicSecurityService")
    @Bean
    public DynamicAccessDecisionManager dynamicAccessDecisionManager() {
        return new DynamicAccessDecisionManager();
    }


    @ConditionalOnBean(name = "dynamicSecurityService")
    @Bean
    public DynamicSecurityFilter dynamicSecurityFilter() {
        return new DynamicSecurityFilter();
    }

    @ConditionalOnBean(name = "dynamicSecurityService")
    @Bean
    public DynamicSecurityMetadataSource dynamicSecurityMetadataSource() {
        return new DynamicSecurityMetadataSource();
    }

}
