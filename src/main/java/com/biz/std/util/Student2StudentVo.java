package com.biz.std.util;

import com.biz.std.model.Student;
import com.biz.std.model.SubjectScore;
import com.biz.std.vo.StudentVo;
import com.google.common.base.Function;
import com.google.common.collect.Lists;

import java.util.List;


/**
 * Created by Administrator on 2017/5/21.
 */
public class Student2StudentVo implements Function<Student,StudentVo> {
    @Override
    public StudentVo apply(Student student) {
        StudentVo studentVo=new StudentVo();
        studentVo.setBirthday(student.getBirthday());
        studentVo.setSex(student.getSex());
        studentVo.setSubjectScoreVos(Lists.transform(student.getSubjectScores(),new SubjectScore2SubjectScoreVo()));
        studentVo.setStudentNumber(student.getStudentNumber());
        studentVo.setName(student.getName());
        studentVo.setLogoPath(student.getLogoPath());
        studentVo.setId(student.getId());
        studentVo.setGradeName(student.getGrade().getName());
        studentVo.setGradeId(student.getGrade().getId());
        List<SubjectScore> subjectScores=student.getSubjectScores();
        if(subjectScores!=null&&subjectScores.size()!=0){
            studentVo.setSubjectNumber(subjectScores.size());
            double sum=0;
            for (int i=0;i<subjectScores.size();i++){
                sum=subjectScores.get(i).getScore()+sum;
            }
            studentVo.setAverage(sum/subjectScores.size());
        }else {
            studentVo.setAverage(0);
            studentVo.setSubjectNumber(0);
        }
        return studentVo;
    }
}
