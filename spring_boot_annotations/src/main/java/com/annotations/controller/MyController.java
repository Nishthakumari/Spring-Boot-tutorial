package com.annotations.controller;


import com.annotations.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    @Qualifier("student1")
    private Student student;

    @RequestMapping(value = "/home" , method = RequestMethod.GET)
    public Student home(@RequestBody Student st){
        System.out.println("This is home");
        System.out.println(st.getName());
        return student;
    }


}
