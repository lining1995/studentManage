package com.biz.std.service;

import com.biz.std.vo.StudentVo;

import java.util.List;

/**
 * Created by Administrator on 2017/5/21.
 */
public interface StudentService {
    List<StudentVo> getStudentAll();
    List<StudentVo> getStudents(int pageNumber, int pageSize);
    StudentVo getStudentById(int id);
    String addStudent(StudentVo studentVo,int gradeId);
    String deleteStudentById(int id);
    String updateStudentById(StudentVo studentVo,int id,int gradeId);
    String uploadLogo(int id, String logoPath);
}
