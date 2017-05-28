package com.biz.std.util;

import com.biz.std.model.Subject;
import com.biz.std.model.SubjectScore;
import com.biz.std.vo.SubjectVo;
import com.google.common.base.Function;

import java.util.List;

/**
 * Created by Administrator on 2017/5/23.
 */
public class Subject2SubjectVo implements Function<Subject,SubjectVo> {
    @Override
    public SubjectVo apply(Subject subject) {
        SubjectVo subjectVo=new SubjectVo();
        subjectVo.setId(subject.getId());
        subjectVo.setName(subject.getName());
        List<SubjectScore> subjectScores=subject.getSubjectScores();
        if (subjectScores.size()!=0&&subjectScores!=null){
            double sum=0;
            for (int i=0;i<subjectScores.size();i++){
                sum=sum+subjectScores.get(i).getScore();
            }
            subjectVo.setAverage(sum/subjectScores.size());
            subjectVo.setNumber(subjectScores.size());
        }else {
            subjectVo.setAverage(0);
            subjectVo.setNumber(0);
        }
        return subjectVo;
    }
}
