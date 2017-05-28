package com.biz.std.model;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by lining on 2017/5/21.
 */
@Entity
public class Student implements Serializable {
    private static final long serialVersionUID = 6446191500394593832L;
    /*
         * * id
        */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /*
    * 学号
    * */
    @Column(length = 20 ,nullable = false)
    private String studentNumber;
    /*
    * *学生姓名
    */
    @Column(length = 20 ,nullable = false)
    private String name;

    /*
    * *学生姓名
    */
    @Column(length = 10 ,nullable = false)
    private String sex;

    /*
    * * 生日
    */
    @Column( nullable = false)
    private Date birthday;
    /*
    * 头像，照片
    * */
    private String logoPath;
    /*
    * 班级
    * */
    @ManyToOne
    private Grade grade;
    /**
     * 科目成绩
     */
    @OneToMany(fetch=FetchType.EAGER,mappedBy = "student")
    private List<SubjectScore> subjectScores;



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

    public List<SubjectScore> getSubjectScores() {
        return subjectScores;
    }

    public void setSubjectScores(List<SubjectScore> subjectScores) {
        this.subjectScores = subjectScores;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
