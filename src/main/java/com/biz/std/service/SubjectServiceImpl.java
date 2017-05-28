package com.biz.std.service;

import com.biz.std.model.Subject;
import com.biz.std.repository.SubjectRepository;
import com.biz.std.util.Subject2SubjectVo;
import com.biz.std.vo.SubjectVo;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/5/22.
 */
@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private SubjectScoreService subjectScoreService;
    @Override
    public List<SubjectVo> getSubjectAll() {
        return Lists.transform(subjectRepository.findAll(),new Subject2SubjectVo());
    }

    @Override
    public SubjectVo getSubjectById(int id) {
        return new Subject2SubjectVo().apply(subjectRepository.findById(id));
    }

    @Transactional
    @Override
    public String addSubject(SubjectVo subjectVo) {
        Subject subject=new Subject();
        subject.setName(subjectVo.getName());
        subjectRepository.save(subject);
        return null;
    }

    @Transactional
    @Override
    public String updateSubject(SubjectVo subjectVo) {
        Subject subject;
        subject=subjectRepository.findById(subjectVo.getId());
        subject.setName(subjectVo.getName());
        subjectRepository.save(subject);
        return null;
    }
    @Transactional
    @Override
    public String deleteSubject(int id) {
        Subject subject=subjectRepository.findById(id);
        subjectScoreService.deleteSubjectScoreBySubject(subject);
        subjectRepository.deleteById(id);
        return null;
    }

}
