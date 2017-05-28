package com.biz.std.service;

import com.biz.std.model.Grade;
import com.biz.std.vo.GradeVo;

import java.util.List;

/**
 * Created by Administrator on 2017/5/22.
 */
public interface GradeService {
    List<GradeVo> getGradeAll();
    GradeVo getGradeById(int id);
    String addGrade(GradeVo gradeVo);
    String updateGrade(GradeVo gradeVo);
    String deleteGrade(int  id);
}
