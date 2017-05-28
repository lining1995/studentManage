package com.biz.std.util;

import com.biz.std.model.Grade;
import com.biz.std.vo.GradeVo;
import com.biz.std.vo.StudentVo;
import com.google.common.base.Function;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by Administrator on 2017/5/23.
 */
public class Grade2GradeVo implements Function<Grade,GradeVo> {
    @Override
    public GradeVo apply(Grade grade) {
        GradeVo gradeVo=new GradeVo();
        gradeVo.setId(grade.getId());
        gradeVo.setName(grade.getName());
        List<StudentVo> studentVos= Lists.transform(grade.getStudents(),new Student2StudentVo());
        if(studentVos.size()!=0&&studentVos!=null){
            double gradeSum=0;
            for (int i=0;i<studentVos.size();i++){
                gradeSum=gradeSum+studentVos.get(i).getAverage();
            }
            gradeVo.setAverage(gradeSum/studentVos.size());
            gradeVo.setNumber(studentVos.size());
        }else {
            gradeVo.setAverage(0);
            gradeVo.setNumber(0);
        }
        return gradeVo;
    }
}
