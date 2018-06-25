package com.manage.student;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//该注解指定项目为springboot，由此类当作程序入口（自动装配web依赖的环境）
@SpringBootApplication
@MapperScan("com.manage.student.mapper")//配置扫描包
public class StudentmanageApplication {
	private static Log logger = LogFactory.getLog(StudentmanageApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(StudentmanageApplication.class, args);
		logger.info("============= SpringBoot Start Success =============");
	}
}
