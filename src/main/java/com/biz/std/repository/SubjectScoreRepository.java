package com.biz.std.repository;

import com.biz.std.model.Student;
import com.biz.std.model.Subject;
import com.biz.std.model.SubjectScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/5/21.
 */
@Repository
public interface SubjectScoreRepository extends JpaRepository<SubjectScore,Long> {
        SubjectScore findByStudentAndSubject(Student student, Subject subject);
        SubjectScore findByStudent(Student student);
        SubjectScore findById(int id);
        @Transactional
        void deleteById(int id);
        @Transactional
        void deleteByStudent(Student student);
        @Transactional
        void deleteBySubject(Subject subject);
}
