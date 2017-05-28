package com.biz.std.controller;

import com.biz.std.model.SubjectScore;
import com.biz.std.service.SubjectScoreService;
import com.biz.std.vo.SubjectScoreVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.Id;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/5/22.
 */
@Controller
@RequestMapping(value = "subjectScore")
public class SubjectScoreController {
    @Autowired
    private SubjectScoreService subjectScoreService;

    @RequestMapping(value = "addSubjectScore")
    public ModelAndView addSubjectScore(HttpServletRequest request, HttpServletResponse response) {
        int studentVoId = Integer.parseInt(request.getParameter("studentVo_id"));
        int subjectVoId = Integer.parseInt(request.getParameter("subject_select"));
        subjectScoreService.addSubjectScore(studentVoId, subjectVoId);
        ModelAndView modelAndView = new ModelAndView("/student/getStudentList.do");
        return modelAndView;
    }

    @RequestMapping(value = "updateSubjectScore")
    public ModelAndView updateSubjectScore(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("subjectScoreId"));
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        double score = Double.parseDouble(request.getParameter("subjectScore"));
        subjectScoreService.updateSubjectScore(id, score);
        ModelAndView modelAndView = new ModelAndView("/student/entryScore.do?id="+studentId);
        return modelAndView;
    }
}
