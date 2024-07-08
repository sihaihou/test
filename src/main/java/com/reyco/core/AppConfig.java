package com.reyco.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.reyco.core")
public class AppConfig {
	
	public AppConfig() {
		System.out.println("---------加载配置------");
	}
	
}

