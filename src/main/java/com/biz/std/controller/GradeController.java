package com.biz.std.controller;

import com.biz.std.service.GradeService;
import com.biz.std.vo.GradeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by Administrator on 2017/5/23.
 */
@Controller
@RequestMapping(value = "grade")
public class GradeController {
    @Autowired
    private GradeService gradeService;
    @RequestMapping(value = "getGradeAll")
    public ModelAndView getAll(){
        List<GradeVo> gradeVos=gradeService.getGradeAll();
        ModelAndView modelAndView=new ModelAndView("../grade_table.jsp");
        modelAndView.addObject("gradeVos",gradeVos);
        return modelAndView;
    }
    @RequestMapping(value = "deleteGrade")
    public ModelAndView deleteGrade(HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("id"));
        gradeService.deleteGrade(id);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("../grade/getGradeAll.do");
        return modelAndView;
    }
    @RequestMapping(value = "gradeForm")
    public ModelAndView gradeForm(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();
        String idStr= request.getParameter("id");
        if(idStr!=null&&!"".equals(idStr)){
            int id=Integer.parseInt(idStr);
            GradeVo gradeVo=gradeService.getGradeById(id);
            modelAndView.addObject("gradeVo",gradeVo);
        }
        modelAndView.setViewName("../jsp/grade_form.jsp");
        return modelAndView;
    }
    @RequestMapping(value = "addGrade")
    public ModelAndView addGrade(HttpServletRequest request){
        String name= null;
        try {
            name = new String(request.getParameter("grade_name").getBytes("ISO-8859-1"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        GradeVo gradeVo=new GradeVo();
        gradeVo.setName(name);
        gradeService.addGrade(gradeVo);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("../grade/getGradeAll.do");
        return modelAndView;
    }
    @RequestMapping(value = "updateGrade")
    public ModelAndView updateGrade(HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("grade_id"));
        String name= null;
        try {
            name = new String(request.getParameter("grade_name").getBytes("ISO-8859-1"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        GradeVo gradeVo=new GradeVo();
        gradeVo.setId(id);
        gradeVo.setName(name);
        gradeService.updateGrade(gradeVo);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("../grade/getGradeAll.do");
        return modelAndView;
    }
}
