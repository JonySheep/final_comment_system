package com.example.demo.app.controller;

import com.example.demo.business.svc.userSvc;
import com.example.demo.business.userSvcImpl;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class mainController {

    @RequestMapping(value = "/addPerson/{name}")
    public Object addPerson(@PathVariable(value = "name") String name){
        Map<String,Object> map=new HashMap<>();
        userSvc service=new userSvcImpl();

        try{
            map.put("data",service.addPerson(name));
            map.put("success",true);
        }
        catch (Exception e){
            map.put("data",e.getStackTrace());
            map.put("success",false);
        }
        return map;
    }


    @RequestMapping(value = "/judge/{name}")
    public Object judge(@PathVariable(value = "name") String name){
        Map<String,Object> map=new HashMap<>();
        userSvc service=new userSvcImpl();

        try{
            map.put("data",service.judgeIsDone(name));
            map.put("success",true);
        }
        catch (Exception e){
            map.put("data",e.getStackTrace());
            map.put("success",false);
        }
        return map;
    }
}
