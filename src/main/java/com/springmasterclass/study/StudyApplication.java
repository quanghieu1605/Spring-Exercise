package com.springmasterclass.study;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudyApplication {

	public static void main(String[] args) {
		var applicationTimeZone = TimeZone.getTimeZone("Asia/Ho_Chi_Minh");
		System.setProperty("user.timezone", applicationTimeZone.getID());
		TimeZone.setDefault(applicationTimeZone);
		SpringApplication.run(StudyApplication.class, args);
	}

}
