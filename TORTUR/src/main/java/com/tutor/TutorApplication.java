package com.tutor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("com.tutor.mapper")
@SpringBootApplication
@EnableTransactionManagement
public class TutorApplication {
    public static void main(String[] args) {
        SpringApplication.run(TutorApplication.class,args);
    }
}
