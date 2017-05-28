package com.biz.std.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/5/21.
 */
@Entity
public class Grade implements Serializable{
    private static final long serialVersionUID = -1651952136589761624L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 10,nullable = false)
    private String name;
    @OneToMany(fetch=FetchType.EAGER,mappedBy = "grade")
    private List<Student> students;
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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
