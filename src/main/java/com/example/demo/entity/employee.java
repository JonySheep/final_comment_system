package com.example.demo.entity;

import com.example.demo.util.enums.ResultMessageEnum;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class employee {
    private int ID;
    private String name;
    private String dept;
    private List<Integer> frontMarkList=new ArrayList<>();
    private List<Integer> backMarkList=new ArrayList<>();
    private double frontMark;
    private double backMark;

    public ResultMessageEnum addFrontMark(int mark){
        frontMarkList.add(mark);
        return ResultMessageEnum.SUCCESS;
    }

    public ResultMessageEnum addBackMark(int mark){
        backMarkList.add(mark);
        return ResultMessageEnum.SUCCESS;
    }
}
