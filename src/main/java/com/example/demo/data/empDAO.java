package com.example.demo.data;

import com.example.demo.entity.employee;
import com.example.demo.util.enums.ResultMessageEnum;

public interface empDAO {

    employee getEmployee(int empID) throws Exception;


    ResultMessageEnum addFrontMark(int empID,int mark) throws Exception;


    ResultMessageEnum addBackMark(int empID,int mark) throws Exception;

}
