package com.crush.weixin.config.wx;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "wx.miniapp")
public class WxProperties {

    private String appId;

    private String appSecret;

    private String msgDataFormat;
}
