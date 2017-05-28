package com.biz.std.service;

import com.biz.std.vo.SubjectVo;

import java.util.List;

/**
 * Created by Administrator on 2017/5/22.
 */
public interface SubjectService {
    String addSubject(SubjectVo subjectVo);
    String updateSubject(SubjectVo subjectVo);
    String deleteSubject(int id);
    List<SubjectVo> getSubjectAll();
    SubjectVo getSubjectById(int id);
}
