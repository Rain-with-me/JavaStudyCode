package com.lu.edu.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

/**
 * @Description: 加载配置文件
 * @Author: 雨同我
 * @DateTime: 2023/2/1 21:02
*/

@Configuration
public class RedssonConfig {
	@Bean
	public RedissonClient redisson() throws IOException {
		RedissonClient redisson = Redisson.create(Config.fromYAML(new ClassPathResource("singleServerConfig.yml").getInputStream()));
		return redisson;
	}
}
