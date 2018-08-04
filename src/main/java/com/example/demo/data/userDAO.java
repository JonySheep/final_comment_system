package com.example.demo.data;

import com.example.demo.util.enums.ResultMessageEnum;

public interface userDAO {
    ResultMessageEnum addPerson(String name) throws Exception;

    ResultMessageEnum judgeIsDone(String name) throws Exception;
}
