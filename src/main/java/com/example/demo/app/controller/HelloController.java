package com.example.demo.app.controller;

import com.example.demo.business.svc.HelloSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private final HelloSvc helloSvc;

    public HelloController(HelloSvc helloSvc) {
        this.helloSvc = helloSvc;
    }

    @RequestMapping(value = "/say", method = GET)
    public Object getTasks() {
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("data", helloSvc.sayHello());

        return map;
    }
}