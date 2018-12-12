package com.ergou.jebrother;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
@ComponentScan("com.ergou.jebrother.*")
public class JebrotherApplication {

	public static void main(String[] args) {
		SpringApplication.run(JebrotherApplication.class, args);
	}
}
