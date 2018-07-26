package com.example.demo.app.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/dept")
public class deptController {

    @RequestMapping(value = "/{dept_id}")
    public void getDept(@PathVariable(value = "dept_id") int deptID){

    }
}
