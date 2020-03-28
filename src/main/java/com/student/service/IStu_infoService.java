package com.student.service;

import com.student.pojo.Stu_info;

import java.util.List;

public interface IStu_infoService {

    /**
     * 新增学生信息
     * @param stu_info 学生信息对象
     * @return 新增成功返回true
     */
    public boolean addStudent(Stu_info stu_info);

    /**
     * 查询学生信息
     * @param field 字段名
     * @param value 值
     * @return
     */
    public List<Stu_info> queryStudent(String field, String value);

    public Stu_info findStudentByS_name(String s_name);
}
