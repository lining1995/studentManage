package com.biz.std.controller;

import com.biz.std.model.Subject;
import com.biz.std.service.GradeService;
import com.biz.std.service.StudentService;
import com.biz.std.service.SubjectService;
import com.biz.std.vo.StudentVo;
import com.biz.std.vo.SubjectVo;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static java.lang.System.currentTimeMillis;

/**
 * Created by Administrator on 2017/5/21.
 */
@Controller
@RequestMapping(value = "student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private GradeService gradeService;
    @Autowired
    private SubjectService subjectService;

    @RequestMapping(value = "getStudentList")
    public ModelAndView getStudentList(HttpServletRequest request) {

        //request.setAttribute("studentVos", studentService.getStudentAll());
        String currentPageStr = request.getParameter("currentPage");
        int currentPage;
        if (currentPageStr == null || "".equals(currentPageStr)) {
            currentPage = 1;
        } else {
            currentPage = Integer.parseInt(currentPageStr);
        }
        ModelAndView modelAndView = new ModelAndView("/student_table.jsp");
        modelAndView.addObject("studentVos", studentService.getStudents(currentPage, 6));
        modelAndView.addObject("pageCount", studentService.getStudentAll().size() / 6 + 1);
        modelAndView.addObject("currentPage", currentPage);
        return modelAndView;
    }

    @RequestMapping(value = "addStudent")
    public ModelAndView addStudent(HttpServletRequest request) {

        StudentVo studentVo = new StudentVo();
        try {
            studentVo.setName(new String(request.getParameter("studentVo_name").getBytes("ISO-8859-1"), "utf-8"));
            studentVo.setSex(new String(request.getParameter("sex_radio").getBytes("ISO-8859-1"), "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        studentVo.setStudentNumber(request.getParameter("studentVo_studentNumber"));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            studentVo.setBirthday(new Date(simpleDateFormat.parse(request.getParameter("birthday")).getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int gradeId=Integer.parseInt(request.getParameter("grade_select"));
        studentService.addStudent(studentVo, gradeId);
        ModelAndView modelAndView=new ModelAndView("/student/getStudentList.do");
        return modelAndView;
    }

    @RequestMapping(value = "updateStudent")
    public ModelAndView updateStudent(HttpServletRequest request) {
        StudentVo studentVo = new StudentVo();
        try {
            studentVo.setName(new String(request.getParameter("studentVo_name").getBytes("ISO-8859-1"), "utf-8"));
            studentVo.setSex(new String(request.getParameter("sex_radio").getBytes("ISO-8859-1"), "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        studentVo.setStudentNumber(request.getParameter("studentVo_studentNumber"));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            studentVo.setBirthday(new Date(simpleDateFormat.parse(request.getParameter("birthday")).getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int gradeId=Integer.parseInt(request.getParameter("grade_select"));
        int id=Integer.parseInt(request.getParameter("studentVo_id"));;
        studentService.updateStudentById(studentVo, id, gradeId);
        ModelAndView modelAndView=new ModelAndView("/student/getStudentList.do");
        return modelAndView;
    }

    @RequestMapping(value = "deleteStudent")
    public ModelAndView deleteStudent(HttpServletRequest request) {
        int id=Integer.parseInt(request.getParameter("id"));
        studentService.deleteStudentById(id);
        ModelAndView modelAndView=new ModelAndView("/student/getStudentList.do");
        return modelAndView;
    }


    @RequestMapping("uploadLogo")
    public ModelAndView uploadLogo( @RequestParam("file") MultipartFile file
                            ,@RequestParam("id") Integer id
            , HttpServletRequest request) {
        String[] fileType = new String[]{".jpg",".gif",".bmp",".png",".jpeg",".ico"};
        //取得上传文件名字
        String fileName = currentTimeMillis()+file.getOriginalFilename();
        //图片保存路径设置
        String filePath = request.getServletContext().getRealPath("/img");
        String ImgFilePath = filePath + File.separator;
        //图片实际在地址
        String imgTruePath = ImgFilePath + fileName;
        //判定是否为图片
        if(fileName.endsWith(fileType[0])||fileName.endsWith(fileType[1])||fileName.endsWith(fileType[2])||fileName.endsWith(fileType[3])||fileName.endsWith(fileType[4])||fileName.endsWith(fileType[5])){
            // 上传文件到服务器
            try {
                file.transferTo(new File(imgTruePath));

            } catch (Exception e) {
                e.printStackTrace();
            }
            //向实体域中添加图片路径

            System.out.println(id);
            studentService.uploadLogo(id,fileName);
        }else {
        }
        ModelAndView modelAndView=new ModelAndView("/student/getStudentList.do");
        return  modelAndView;
    }

    @RequestMapping("studentForm")
    public ModelAndView studentForm(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView("/student_form.jsp");
        String idstr=request.getParameter("id");
        if (idstr==null||"".equals(idstr)){
        }else {
            int id=Integer.parseInt(idstr);
            StudentVo studentVo= studentService.getStudentById(id);
            modelAndView.addObject("studentVo",studentVo);
        }
        modelAndView.addObject("gradeVos",gradeService.getGradeAll());
        return modelAndView;
    }

    @RequestMapping("chooseSubject")
    public ModelAndView chooseSubject(HttpServletRequest request){
        int id =Integer.parseInt(request.getParameter("id"));
        StudentVo studentVo=studentService.getStudentById(id);
        List<SubjectVo> subjectVos=subjectService.getSubjectAll();
        for(int i=0;i< studentVo.getSubjectScoreVos().size();i++){
            for(int j=0;j<subjectVos.size();j++){
             if(studentVo.getSubjectScoreVos().get(i).getSubjectId()==subjectVos.get(j).getId()){
                 subjectVos.remove(j);
             }
            }
        }
        ModelAndView modelAndView=new ModelAndView("/jsp/choose_subject.jsp");
        modelAndView.addObject("subjectVos",subjectVos);
        modelAndView.addObject("studentVo",studentVo);
        return modelAndView;
    }
    @RequestMapping("entryScore")
    public ModelAndView entryScore(HttpServletRequest request){
        int id =Integer.parseInt(request.getParameter("id"));
        StudentVo studentVo=studentService.getStudentById(id);
        ModelAndView modelAndView=new ModelAndView("/jsp/entry_score.jsp");
        modelAndView.addObject("subjectScores" ,studentVo.getSubjectScoreVos());
        return modelAndView;
    }
}
