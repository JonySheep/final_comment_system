package com.example.demo.business.svc;

import com.example.demo.entity.dept;
import com.example.demo.util.enums.ResultMessageEnum;

public interface deptSvc {
    dept getDept(int deptID) throws Exception;

    ResultMessageEnum addAdMark(int deptID,int mark) throws Exception;

    ResultMessageEnum addNotMark(int deptID,int mark) throws Exception;

}
