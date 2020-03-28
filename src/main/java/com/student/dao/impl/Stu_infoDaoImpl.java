package com.student.dao.impl;

import com.student.dao.IStu_infoDao;
import com.student.pojo.Stu_info;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Stu_infoDaoImpl implements IStu_infoDao {

    Connection conn = null;
    PreparedStatement ps = null;

    public Stu_infoDaoImpl(Connection conn) {
        this.conn = conn;
    }

    /**
     * 按条件查询学生信息
     * @param field 字段名称(如果字段名称为空，则查询所有记录)
     * @param value 字段值
     * @return
     */
    @Override
    public List<Stu_info> findStuByConditions(String field, String value) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<Stu_info> stu_list = new ArrayList<Stu_info>();
        String sql_tail = "";
        if (!"".equals(field)) {
            sql_tail = " where " + field + " like '%" + value + "%'";
        }
        String sql = "select * from stu_info" + sql_tail;
        try {
            ps = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Stu_info stu_info = new Stu_info();
                stu_info.setS_id(rs.getInt("s_id"));
                stu_info.setS_name(rs.getString("s_name"));
                stu_info.setS_no(rs.getString("s_no"));
                stu_info.setS_major(rs.getString("s_major"));
                stu_info.setS_regtime(sdf.format(rs.getTimestamp("s_regtime")));
                stu_info.setS_status(rs.getString("s_status"));
                stu_list.add(stu_info);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeStatement();
        return stu_list;
    }

    /**
     * 新增学生信息
     * @param stu_info 学生信息对象
     * @return 插入成功返回true
     */
    @Override
    public boolean insertStu_info(Stu_info stu_info) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        boolean flag = false;
        String sql = "insert into stu_info (s_no,s_name,s_major,s_status,s_regtime)"
        + " values (?,?,?,?,?)";
        try {
            ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setString(1, stu_info.getS_no());
            ps.setString(2, stu_info.getS_name());
            ps.setString(3, stu_info.getS_major());
            ps.setString(4, stu_info.getS_status());
            ps.setString(5, stu_info.getS_regtime());
            if (ps.executeUpdate() > 0) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeStatement();
        return flag;
    }

    /**
     * 删除学生信息
     * @author Luke
     * @param stu_info 学生信息对象
     * @return
     */
    @Override
    public boolean deleteStu_info(Stu_info stu_info) {
        return false;
    }

    /**
     * 依据学生姓名查找学生信息
     * @param s_name 学生姓名
     * @return
     */
    @Override
    public Stu_info findStuInfoByS_name(String s_name) {
        Stu_info stu_info = null;
        String sql = "select * from stu_info where s_name = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, s_name);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                stu_info = new Stu_info();
                stu_info.setS_id(rs.getInt("s_id"));
                stu_info.setS_name(rs.getString("s_name"));
                stu_info.setS_no(rs.getString("s_no"));
                stu_info.setS_major(rs.getString("s_major"));
                stu_info.setS_status(rs.getString("s_status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stu_info;
    }

    private void closeStatement() {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
