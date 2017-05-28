package com.biz.std.vo;

import com.biz.std.model.Student;
import com.biz.std.model.Subject;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/5/22.
 */
public class SubjectScoreVo implements Serializable{
    private static final long serialVersionUID = 4409759576406265628L;
    private int id;
    private int studentId;
    private int subjectId;
    private String subjectName;
    private double score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
