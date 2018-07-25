package com.example.demo.business;

import com.example.demo.business.svc.HelloSvc;
import org.springframework.stereotype.Service;

@Service
public class HelloSvcImpl implements HelloSvc {
    @Override
    public String sayHello() {
        return "Hello, World!";
    }
}
