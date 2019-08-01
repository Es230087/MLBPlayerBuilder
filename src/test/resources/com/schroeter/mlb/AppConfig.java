package com.schroeter.mlb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.schroeter.mlb.player.remoteMlbService.RemoteMlbService;

@Configuration
@ComponentScan(basePackages = "com.schroeter.mlb")
public class AppConfig {
	
	@Bean
    RemoteMlbService remoteMlbService() {
		return new RemoteMlbService();
    }
	
}
