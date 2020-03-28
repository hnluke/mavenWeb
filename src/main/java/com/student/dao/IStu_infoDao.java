package com.student.dao;

import com.student.pojo.Stu_info;

import java.util.List;

public interface IStu_infoDao {

    /**
     * 依据不同的条件来查询学生表
     * @param field 字段名称(如果字段名称为空，则查询所有记录)
     * @param value 字段值
     * @return 学生信息对象
     */
    public List<Stu_info> findStuByConditions(String field, String value);
    /**
     * 注册学生信息
     * @param stu_info
     * @return
     */
    public boolean insertStu_info(Stu_info stu_info);

    /**
     * 删除学生信息
     * @param stu_info 学生信息对象
     * @return 删除成功返回true
     */
    public boolean deleteStu_info(Stu_info stu_info);

    /**
     * 依据学生姓名查找信息
     * @param s_name 学生姓名
     * @return 如果找到，返回学生信息，否则返回null
     */
    public Stu_info findStuInfoByS_name(String s_name);


}
