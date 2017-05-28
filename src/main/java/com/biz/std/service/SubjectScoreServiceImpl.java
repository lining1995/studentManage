package com.biz.std.service;

import com.biz.std.model.Student;
import com.biz.std.model.Subject;
import com.biz.std.model.SubjectScore;
import com.biz.std.repository.StudentRepository;
import com.biz.std.repository.SubjectRepository;
import com.biz.std.repository.SubjectScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/5/22.
 */
@Service
public class SubjectScoreServiceImpl implements  SubjectScoreService {
    @Autowired
    private SubjectScoreRepository subjectScoreRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Transactional
    @Override
    public String addSubjectScore(int studentId,int subjectId) {
        Subject subject=subjectRepository.findById(subjectId);
        Student student=studentRepository.findById(studentId);
        SubjectScore subjectScore=new SubjectScore();
        subjectScore.setScore(0);
        subjectScore.setSubject(subject);
        subjectScore.setStudent(student);
        subjectScoreRepository.save(subjectScore);
        return "success";
    }
    @Transactional
    @Override
    public String updateSubjectScore(int id, double score) {
        SubjectScore subjectScore=subjectScoreRepository.findById(id);
        subjectScore.setScore(score);
        subjectScoreRepository.save(subjectScore);
        return "success";
    }
    @Transactional
    @Override
    public String deleteSubjectScore(int id) {
        subjectScoreRepository.deleteById(id);
        return "success";
    }
    @Transactional
    @Override
    public String deleteSubjectScoreByStudent(Student student) {
        subjectScoreRepository.deleteByStudent(student);
        return null;
    }

    @Override
    public String deleteSubjectScoreBySubject(Subject subject) {
        subjectScoreRepository.deleteBySubject(subject);
        return null;
    }
}
