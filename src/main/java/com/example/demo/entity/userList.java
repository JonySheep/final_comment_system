package com.example.demo.entity;

import com.example.demo.util.enums.ResultMessageEnum;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class userList {
    private List<String> userList = new ArrayList<>();


    public ResultMessageEnum addUser(String name){
        userList.add(name);
        return ResultMessageEnum.SUCCESS;
    }


    public ResultMessageEnum judgeIsDone(String name){
         for(String s:userList){
             if(name.equals(s)){
                 return ResultMessageEnum.FAIL; //已经做过
             }
         }

         return ResultMessageEnum.SUCCESS;
    }
}
