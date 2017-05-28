package com.biz.std.vo;

import com.biz.std.model.Student;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/5/21.
 */
public class GradeVo implements Serializable {
    private static final long serialVersionUID = 8163938863855960442L;
    private int id;
    private String name;
    private double average;
    private int number;

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
