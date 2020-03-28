package com.student.controller;

import com.student.factory.StudentFactory;
import com.student.pojo.Stu_info;
import com.student.pojo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;


/**
 * @author ：Luke
 * @date ：Created in 2020/3/22 15:55
 * @description：Demo
 * @modified By：
 * @version: 1.0$
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    /**
     * 用户登录Control
     * @param users
     * @return
     */
    @RequestMapping(value="", method = RequestMethod.POST)
    public String login(@ModelAttribute Users users, HttpServletRequest request) {
        if(StudentFactory.getUsersServiceImpl().verifyUsers(users.getU_name(), users.getU_pwd())) {
            request.getSession().setAttribute("user", users.getU_name());
            return "main";
        }else{
            return "redirect:/";
        }
    }

    /**
     * 新增用户界面返回
     * @return
     */
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public String insertReturn(@PathVariable("id") Integer id, HttpServletRequest req) {
        if(id == 1)
            return "main";
        else if(id == 2) {
            req.getSession().invalidate();
            return "redirect:/";

        }
        return null;
    }


    /**
     * 查询操作
     * @param conditions 字段名
     * @param contexts 字段值
     * @return
     */
    @RequestMapping(value="/operate", method = RequestMethod.GET)
    //public ModelAndView query(@PathVariable("field") String field, @PathVariable("value") String value) {
    public ModelAndView query(String conditions, String contexts) {
        System.out.println("Entered...");
        System.out.println();
        ModelAndView mav = new ModelAndView();
        List query_list = StudentFactory.getStu_infoServiceImpl().queryStudent(conditions, contexts);
        mav.addObject("query_list", query_list);
        mav.setViewName("query");
        return mav;
    }
    /**
     * 新增等操作control
     * @param stu_info
     * @param request
     * @return
     */
    @RequestMapping(value="/operate/{id}", method = RequestMethod.POST)
    public String insert(@PathVariable("id") String id, Stu_info stu_info,
                         HttpServletRequest request, MultipartFile file){

        //if(id == 2) {
            if(StudentFactory.getStu_infoServiceImpl().addStudent(stu_info)) {
                String path= "";
                // 获取要上传的文件名
                String fileName= file.getOriginalFilename();
                String suffix = fileName.substring(fileName.indexOf('.'));
                path = request.getServletContext().getRealPath("");
                path = path + "files\\" + id + suffix;
                try {
                    file.transferTo(new File(path));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                request.setAttribute("tages", "新增成功");
            }else{
                request.setAttribute("tages", "新增失败");
            }
            return "insert";
        //}
        //return "redirect:main.jsp";

    }



    @RequestMapping(value="/operate/{id}" , method = RequestMethod.PUT)
    public String alterPwd(@PathVariable(value="id")  String uid, String ori_pwd,
                           String new_pwd, HttpServletRequest request) {
        // 当前用户名
        String user = (String)request.getSession().getAttribute("user");
        // 当前用户对象
        Users users = StudentFactory.getUsersServiceImpl().findUsers(user);
        String tages = "";
        if(!users.getU_pwd().equals(ori_pwd)) {
            tages = "原始密码不正确";
        }else if("".equals(new_pwd)) {
            tages = "密码不能设置为空";
        }else{
            Users user2 = new Users();
            user2.setU_name(user);
            user2.setU_pwd(new_pwd);
            if(StudentFactory.getUsersServiceImpl().alterPwd(user2)) {
                tages = "密码修改成功";
            }else{
                tages = "密码修改失败";
            }
        }
        request.setAttribute("tages", tages);
        return "alterpwd";
    }


    @RequestMapping(value="/query")
    public String query() {
        return "query";
    }

    @RequestMapping(value="/insert")
    public String insert(){
        return "insert";
    }

    @RequestMapping(value="/alterpwd")
    public String alter() {
        return "alterpwd";
    }


}
