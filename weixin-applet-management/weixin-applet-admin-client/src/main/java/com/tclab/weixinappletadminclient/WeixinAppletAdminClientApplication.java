package com.tclab.weixinappletadminclient;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAutoConfiguration
@MapperScan("com.tclab.weixinappletservice.dao")
@ComponentScan(basePackages= "com.tclab")
@EnableScheduling
@EnableTransactionManagement
public class WeixinAppletAdminClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeixinAppletAdminClientApplication.class, args);
	}

}
