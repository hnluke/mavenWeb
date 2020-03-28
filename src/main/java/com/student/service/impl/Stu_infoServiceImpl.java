package com.student.service.impl;

import com.student.dao.impl.Stu_infoDaoImpl;
import com.student.pojo.Stu_info;
import com.student.service.IStu_infoService;

import java.sql.Connection;
import java.util.List;

public class Stu_infoServiceImpl implements IStu_infoService {

    Connection conn = null;
    Stu_infoDaoImpl stu_infoDao = null;

    public Stu_infoServiceImpl(Connection conn) {
        this.conn = conn;
        stu_infoDao = new Stu_infoDaoImpl(conn);
    }
    /**
     * 新增学生信息
     * @author Luke
     * @param stu_info 学生信息对象
     * @return
     */
    @Override
    public boolean addStudent(Stu_info stu_info) {
        return  stu_infoDao.insertStu_info(stu_info);
    }

    @Override
    public List<Stu_info> queryStudent(String field, String value) {
        List<Stu_info> list = null;
        list = stu_infoDao.findStuByConditions(field, value);
        return list;
    }

    @Override
    public Stu_info findStudentByS_name(String s_name) {
        Stu_info stu_info;
        stu_info = stu_infoDao.findStuInfoByS_name(s_name);
        return stu_info;
    }
}
