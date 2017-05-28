package com.biz.std.vo;

import com.biz.std.model.SubjectScore;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/5/22.
 */
public class SubjectVo implements Serializable {

    private static final long serialVersionUID = 7689880343270120227L;
    private int id;
    /**
     * 科目名字
     */
    private String name;
    /**
     * 科目数
     */
    private int number;
    /**
     * 平均分
     */
    private double average;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
