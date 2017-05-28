package com.biz.std.service;

import com.biz.std.model.Student;
import com.biz.std.model.Subject;
import com.biz.std.vo.SubjectVo;

/**
 * Created by Administrator on 2017/5/22.
 */
public interface SubjectScoreService {
    String addSubjectScore(int studentId, int subjectId);

    String updateSubjectScore(int id, double score);

    String deleteSubjectScore(int id);

    String deleteSubjectScoreByStudent(Student student);

    String deleteSubjectScoreBySubject(Subject subject);
}
