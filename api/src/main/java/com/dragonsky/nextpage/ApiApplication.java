package com.dragonsky.nextpage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import static org.springframework.data.web.config.EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO;

@SpringBootApplication
@EnableSpringDataWebSupport(pageSerializationMode = VIA_DTO)
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ApiApplication  {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication .class, args);
	}

}
