package com.example.demo.app.controller;

import com.example.demo.app.WebAppConfig;
import com.example.demo.business.empSvcImpl;
import com.example.demo.business.svc.empSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/emp")
public class empController {


    /**
     * 增加一个前台人员对此人的评价分数
     * @param mark 评价人打分
     * @param empId 被评价人
     * @return
     */
    @RequestMapping(value = "/{emp_id}/addFrontMark/{mark}",method = POST)
    public Object addFrontMark(@PathVariable(value = "mark") int mark,
                          @PathVariable(value = "emp_id") int empId){
        Map<String,Object> map=new HashMap<>();
        empSvc service=new empSvcImpl();

        try{
            map.put("data",service.addFrontMark(empId,mark));
            map.put("success",true);
        }
        catch (Exception e){
            map.put("data",e.getStackTrace());
            map.put("success",false);
        }
        return map;
    }


    /**
     * 增加一个后人员对此人的评价分数
     * @param mark 评价人打分
     * @param empId 被评价人
     * @return
     */
    @RequestMapping(value = "/{emp_id}/addBackMark/{mark}",method = POST)
    public Object addBackMark(@PathVariable(value = "mark") int mark,
                          @PathVariable(value = "emp_id") int empId){
        Map<String,Object> map=new HashMap<>();
        empSvc service=new empSvcImpl();

        try{
            map.put("data",service.addBackMark(empId,mark));
            map.put("success",true);
        }
        catch (Exception e){
            map.put("data",e.getStackTrace());
            map.put("success",false);
        }
        return map;
    }


    /**
     * 得到下一个被评价人
     * @param empId 被评价人
     * @return
     */
    @RequestMapping(value = "/{emp_id}",method = GET)
    public Object getEmp(@PathVariable(value = "emp_id") int empId){
        Map<String,Object> map=new HashMap<>();
        empSvc service=new empSvcImpl();

        try{
            map.put("data",service.getEmp(empId));
            map.put("success",true);
        }
        catch (Exception e){
            map.put("data",e.getStackTrace());
            map.put("success",false);
        }
        return map;
    }
}
