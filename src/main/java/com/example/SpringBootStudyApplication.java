package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//项目要写到跟他同级的目录下com.example;
@SpringBootApplication
public class SpringBootStudyApplication {
	//程序的主入口
	public static void main(String[] args) {
		SpringApplication.run(SpringBootStudyApplication.class, args);
	}

}
