package com.example.demo.business.svc;

import com.example.demo.entity.employee;
import com.example.demo.util.enums.ResultMessageEnum;
import org.springframework.stereotype.Service;


@Service
public interface empSvc {
    ResultMessageEnum addFrontMark(int empID,int mark) throws Exception;

    ResultMessageEnum addBackMark(int empID,int mark) throws Exception;

    employee getEmp(int empID) throws Exception;
}
