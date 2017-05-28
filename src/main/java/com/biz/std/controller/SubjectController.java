package com.biz.std.controller;

import com.biz.std.model.Subject;
import com.biz.std.service.SubjectService;
import com.biz.std.vo.SubjectVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by Administrator on 2017/5/22.
 */
@Controller
@RequestMapping(value = "subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;
    @RequestMapping(value = "getSubjectAll")
    public ModelAndView getSubjectAll(){
        List<SubjectVo> subjectVos= subjectService.getSubjectAll();
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("/subject_table.jsp");
        modelAndView.addObject("subjectVos",subjectVos);
        return modelAndView;
    }
    @RequestMapping(value = "deleteSubject")
    public ModelAndView deleteSubject(HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("id"));
        subjectService.deleteSubject(id);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("/subject/getSubjectAll.do");
        return modelAndView;
    }
    @RequestMapping(value = "subjectForm")
    public ModelAndView subjectForm(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();
        String idStr= request.getParameter("id");
        if(idStr!=null&&!"".equals(idStr)){
            int id=Integer.parseInt(idStr);
            SubjectVo subjectVo=subjectService.getSubjectById(id);
            modelAndView.addObject("subjectVo",subjectVo);
        }
        modelAndView.setViewName("/jsp/subject_form.jsp");
        return modelAndView;
    }
    @RequestMapping(value = "addSubject")
    public ModelAndView addSubject(HttpServletRequest request){
        String name= null;
        try {
            name = new String(request.getParameter("subject_name").getBytes("ISO-8859-1"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        SubjectVo subjectVo=new SubjectVo();
        subjectVo.setName(name);
        subjectService.addSubject(subjectVo);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("/subject/getSubjectAll.do");
        return modelAndView;
    }
    @RequestMapping(value = "updateSubject")
    public ModelAndView updateSubject(HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("subject_id"));
        String name= null;
        try {
            name = new String(request.getParameter("subject_name").getBytes("ISO-8859-1"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        SubjectVo subjectVo=new SubjectVo();
        subjectVo.setName(name);
        subjectVo.setId(id);
        subjectService.updateSubject(subjectVo);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("/subject/getSubjectAll.do");
        return modelAndView;
    }
}
