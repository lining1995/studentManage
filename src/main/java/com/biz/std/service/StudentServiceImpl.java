package com.biz.std.service;

import com.biz.std.model.Student;
import com.biz.std.model.Subject;
import com.biz.std.model.SubjectScore;
import com.biz.std.repository.GradeRepository;
import com.biz.std.repository.StudentRepository;
import com.biz.std.repository.SubjectRepository;
import com.biz.std.repository.SubjectScoreRepository;
import com.biz.std.util.Student2StudentVo;
import com.biz.std.vo.StudentVo;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/5/21.
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private GradeRepository gradeRepository;
    @Autowired
    private SubjectScoreService subjectScoreService;

    @Override
    public List<StudentVo> getStudentAll() {
        return Lists.transform(studentRepository.findAll(),new Student2StudentVo());
    }

    @Override
    public List<StudentVo> getStudents(int pageNumber, int pageSize) {
        PageRequest request = this.buildPageRequest(pageNumber,pageSize);
        List<Student> students= studentRepository.findAll(request).getContent();
        return Lists.transform(students,new Student2StudentVo());
    }

    @Override
    public StudentVo getStudentById(int id) {
        return new Student2StudentVo().apply(studentRepository.findById(id));
    }

    @Transactional
    @Override
    public String addStudent(StudentVo studentVo,int gradeId) {
        Student student=new Student();
        student.setBirthday(studentVo.getBirthday());
        student.setName(studentVo.getName());
        student.setSex(studentVo.getSex());
        student.setStudentNumber(studentVo.getStudentNumber());
        student.setGrade(gradeRepository.findById(gradeId));
        studentRepository.save(student);
        return "success";
    }
    @Transactional
    @Override
    public String deleteStudentById(int id) {
        Student student=studentRepository.findById(id);
        subjectScoreService.deleteSubjectScoreByStudent(student);
        studentRepository.deleteById(id);
        return "success";
    }
    @Transactional
    @Override
    public String updateStudentById(StudentVo studentVo,int id,int gradeId) {
        Student student=studentRepository.findById(id);
        student.setStudentNumber(studentVo.getStudentNumber());
        student.setSex(studentVo.getSex());
        student.setName(studentVo.getName());
        student.setBirthday(studentVo.getBirthday());
        student.setGrade(gradeRepository.findById(gradeId));
        studentRepository.save(student);
        return "success";
    }

    @Override
    public String uploadLogo(int id,String logoPath) {
        Student student=studentRepository.findById(id);
        student.setLogoPath(logoPath);
        studentRepository.save(student);
        return "success";
    }


    //构建PageRequest
    private PageRequest buildPageRequest(int pageNumber, int pagzSize) {
        return new PageRequest(pageNumber - 1, pagzSize, null);
    }
}
