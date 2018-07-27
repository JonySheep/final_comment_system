package com.example.demo.entity;

import com.example.demo.util.enums.ResultMessageEnum;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class dept {
    private int ID;
    private String name;
    private String managerName;
    private int adMark;
    private List<Integer> notAdMark=new ArrayList<>();
    private double mark;
    private int comment_num;

    public ResultMessageEnum addAdMark(int mark){
        adMark=mark;
        return ResultMessageEnum.SUCCESS;
    }

    public ResultMessageEnum addNotAdMark(int mark){
        notAdMark.add(mark);
        return ResultMessageEnum.SUCCESS;
    }

    public void addCommentNum(){
        comment_num++;
    }
}
