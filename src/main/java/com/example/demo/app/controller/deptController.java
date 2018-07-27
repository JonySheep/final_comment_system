package com.example.demo.app.controller;

import com.example.demo.business.deptSvcImpl;
import com.example.demo.business.svc.deptSvc;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/dept")
public class deptController {

    /**
     * 根据部门ID得到部门对象
     * @param deptID
     */
    @RequestMapping(value = "/{dept_id}")
    public Object getDept(@PathVariable(value = "dept_id") int deptID){
        Map<String,Object> map =new HashMap<>();
        deptSvc svc=new deptSvcImpl();

        try{
            map.put("data",svc.getDept(deptID));
            map.put("success",true);
        }
        catch (Exception e){
            map.put("data",e.getStackTrace());
            map.put("success",false);
        }
        return map;
    }


    /**
     * 增加一个中心领导分数
     * @param deptID
     */
    @RequestMapping(value = "/{dept_id}/addAdMark")
    public Object addAdMark(@PathVariable(value = "dept_id") int deptID,
                            @RequestAttribute(value = "mark") int mark){
        Map<String,Object> map =new HashMap<>();
        deptSvc svc=new deptSvcImpl();

        try{
            map.put("data",svc.addAdMark(deptID,mark));
            map.put("success",true);
        }
        catch (Exception e){
            map.put("data",e.getStackTrace());
            map.put("success",false);
        }
        return map;
    }


    /**
     * 增加一个分管领导分数
     * @param deptID
     */
    @RequestMapping(value = "/{dept_id}/addNotAdMark")
    public Object addNotAdMark(@PathVariable(value = "dept_id") int deptID,
                            @RequestAttribute(value = "mark") int mark){
        Map<String,Object> map =new HashMap<>();
        deptSvc svc=new deptSvcImpl();

        try{
            map.put("data",svc.addNotMark(deptID,mark));
            map.put("success",true);
        }
        catch (Exception e){
            map.put("data",e.getStackTrace());
            map.put("success",false);
        }
        return map;
    }
}
