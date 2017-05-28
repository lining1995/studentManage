package com.biz.std.service;

import com.biz.std.model.Grade;
import com.biz.std.model.Student;
import com.biz.std.repository.GradeRepository;
import com.biz.std.util.Grade2GradeVo;
import com.biz.std.vo.GradeVo;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/5/22.
 */
@Service
public class GradeServiceImpl implements GradeService {
    @Autowired
    private GradeRepository gradeRepository;
    @Autowired
    private StudentService studentService;
    @Override
    public List<GradeVo> getGradeAll() {
        return Lists.transform(gradeRepository.findAll(),new Grade2GradeVo());
    }

    @Override
    public GradeVo getGradeById(int id) {
        return new  Grade2GradeVo().apply(gradeRepository.findById(id));
    }

    @Transactional
    @Override
    public String addGrade(GradeVo gradeVo) {
        Grade grade=new Grade();
        grade.setName(gradeVo.getName());
        gradeRepository.save(grade);
        return null;
    }
    @Transactional
    @Override
    public String updateGrade(GradeVo gradeVo) {
        Grade grade=gradeRepository.findById(gradeVo.getId());
        grade.setName(gradeVo.getName());
        gradeRepository.save(grade);
        return null;
    }
    @Transactional
    @Override
    public String deleteGrade(int id) {
        Grade grade=gradeRepository.findById(id);
        for (Student student:grade.getStudents()){
            studentService.deleteStudentById(student.getId());
        }
        gradeRepository.deleteById(id);
        return null;
    }
}
