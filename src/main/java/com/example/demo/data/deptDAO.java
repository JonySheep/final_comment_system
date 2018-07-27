package com.example.demo.data;

import com.example.demo.entity.dept;
import com.example.demo.util.enums.ResultMessageEnum;

public interface deptDAO {

    dept getDept(int deptID) throws Exception;

    ResultMessageEnum addAdMark(int mark,int deptID) throws Exception;

    ResultMessageEnum addNotAdMark(int mark,int deptID) throws Exception;
}
