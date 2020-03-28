package com.student.dao.impl;

import com.student.dao.IUsersDao;
import com.student.pojo.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersDaoImpl implements IUsersDao {
    Connection conn = null;
    PreparedStatement ps = null;

    public UsersDaoImpl(Connection conn) {
        this.conn = conn;
    }

    /**
     * 依据用户名查找用户
     * @param u_name 用户名
     * @return 返回用户对象
     */
    @Override
    public Users findUserByU_name(String u_name) {
        Users users = null;
        String sql = "select * from users where u_name = '" + u_name + "'";
        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                users = new Users();
                users.setU_id(rs.getInt("u_id"));
                users.setU_name(rs.getString("u_name"));
                users.setU_pwd(rs.getString("u_pwd"));
                users.setU_prio(rs.getString("u_prio"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    /**
     * 依据用户名更新用户密码
     * @author Luke
     * @param users
     * @return 更新成功返回true
     */
    @Override
    public boolean updateUserPwd(Users users) {
        boolean flag = false;
        String sql = "update users set u_pwd = '" + users.getU_pwd()
                + "' where u_name = '" + users.getU_name() + "'";
        try {
            ps = conn.prepareStatement(sql);
            if(ps.executeUpdate() > 0) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flag;
    }
}
