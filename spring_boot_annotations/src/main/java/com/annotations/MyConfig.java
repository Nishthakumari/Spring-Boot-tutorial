package com.annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.util.Date;


@Configuration
@ComponentScan(basePackages = {"mypack"})
public class MyConfig {

    @Bean("student1")
    @Lazy
    public Student getStudent(){
        System.out.println("creating first  student ");
        return new Student("student1");
    }

    @Bean("student2")
    public Student createStudent(){
        System.out.println(" creating second student");
        return  new Student("student2");
    }

    @Bean
    public Date getDate(){
        System.out.println("creating date");
        return new Date();
    }

}
