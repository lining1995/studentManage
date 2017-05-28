package com.biz.std.util;

import com.biz.std.model.SubjectScore;
import com.biz.std.vo.SubjectScoreVo;
import com.google.common.base.Function;

/**
 * Created by Administrator on 2017/5/27.
 */
public class SubjectScore2SubjectScoreVo implements Function<SubjectScore,SubjectScoreVo> {
    @Override
    public SubjectScoreVo apply(SubjectScore subjectScore) {
        SubjectScoreVo subjectScoreVo=new SubjectScoreVo();
        subjectScoreVo.setId(subjectScore.getId());
        subjectScoreVo.setScore(subjectScore.getScore());
        subjectScoreVo.setStudentId(subjectScore.getStudent().getId());
        subjectScoreVo.setSubjectId(subjectScore.getSubject().getId());
        subjectScoreVo.setSubjectName(subjectScore.getSubject().getName());
        return subjectScoreVo;
    }
}
