package com.biz.std.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by lining on 2017/5/21.
 */
@Entity
public class Subject implements Serializable {
    private static final long serialVersionUID = -1723255609124482033L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * 科目名字
     */
    @Column(length = 10, nullable = false)
    private String name;
    /**
     * 科目成绩
     */
    @OneToMany(fetch=FetchType.EAGER, mappedBy = "subject")
    private List<SubjectScore> subjectScores;


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

    public List<SubjectScore> getSubjectScores() {
        return subjectScores;
    }

    public void setSubjectScores(List<SubjectScore> subjectScores) {
        this.subjectScores = subjectScores;
    }

}
