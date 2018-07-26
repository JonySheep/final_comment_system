package com.example.demo.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class dept {
    private int ID;
    private String name;
    private String managerName;
    private double adMark;
    private List<Double> notAdMark=new ArrayList<>();
    private double mark;
    private int comment_num;
}
