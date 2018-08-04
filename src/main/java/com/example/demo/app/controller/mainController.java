package com.example.demo.app.controller;

import com.example.demo.business.svc.userSvc;
import com.example.demo.business.userSvcImpl;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class mainController {

    @RequestMapping(value = "/addPerson/{name}",method=POST)
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


    @RequestMapping(value = "/judge/{name}",method=GET)
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
