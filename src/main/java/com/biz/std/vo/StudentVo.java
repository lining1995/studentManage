package com.biz.std.vo;

import com.biz.std.model.Grade;
import com.biz.std.model.SubjectScore;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * Created by lining on 2017/5/21.
 */
public class StudentVo implements Serializable {
    private static final long serialVersionUID = -19304033793437861L;
    /*
         * * id
        */
    private int id;
    /*
    * 学号
    * */
    private String studentNumber;
    /*
    * *学生姓名
    */
    private String name;

    /*
    * *学生姓名
    */
    private String sex;

    /*
    * * 生日
    */
    private Date birthday;
    /*
    * 头像，照片
    * */
    private String logoPath;
    /*
    * 班级
    * */
    private String gradeName;
    private int gradeId;
    /**
     * 科目成绩
     */
    private List<SubjectScoreVo> subjectScoreVos;
    /**
     * 平均分
     */
    private double average;
    /**
     * 科目数
     */
    private int subjectNumber;

    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    public List<SubjectScoreVo> getSubjectScoreVos() {
        return subjectScoreVos;
    }

    public void setSubjectScoreVos(List<SubjectScoreVo> subjectScoreVos) {
        this.subjectScoreVos = subjectScoreVos;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public int getSubjectNumber() {
        return subjectNumber;
    }

    public void setSubjectNumber(int subjectNumber) {
        this.subjectNumber = subjectNumber;
    }
}
