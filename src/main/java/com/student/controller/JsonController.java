package com.student.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import com.student.factory.StudentFactory;
import com.student.pojo.Stu_info;
import com.student.pojo.Users;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/json")
public class JsonController {
    @ResponseBody
    @RequestMapping(value="/jsondata", produces = {"application/json;charset=utf-8"})
    public List<String> recieveJson(@RequestBody String user, HttpServletResponse resp) {
        String str = "有重名";
        List<String> list = new ArrayList<String>();
        list.add(str);
        Gson gson = new Gson();
        Users users = new Users();
        users = gson.fromJson(user, Users.class);
        Stu_info dbUser = StudentFactory.getStu_infoServiceImpl().findStudentByS_name(users.getU_name());
        if(dbUser != null) {
            return list;
        }
        else{
            return null;
        }

    }
}
