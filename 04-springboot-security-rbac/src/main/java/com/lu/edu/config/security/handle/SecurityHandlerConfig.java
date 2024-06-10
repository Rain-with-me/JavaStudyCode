package com.lu.edu.config.security.handle;

import com.lu.edu.config.security.common.Status;


import com.lu.edu.utils.ResponseUtil;
import com.lu.edu.utils.exception.DiyException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.access.AccessDeniedHandler;

/**
 * <p>
 * Security 结果处理配置
 * </p>
 */
@Configuration
public class SecurityHandlerConfig {

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return (request, response, accessDeniedException)->{
            System.out.println("-------------------------没有权限");
            ResponseUtil.renderJson(response, Status.ACCESS_DENIED, null);
        };
    }

}
