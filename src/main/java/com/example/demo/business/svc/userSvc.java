package com.example.demo.business.svc;

import com.example.demo.util.enums.ResultMessageEnum;

public interface userSvc {

    ResultMessageEnum addPerson(String name) throws Exception;

    ResultMessageEnum judgeIsDone(String name) throws Exception;
}
