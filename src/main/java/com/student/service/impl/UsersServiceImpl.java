package com.student.service.impl;

import com.student.dao.impl.UsersDaoImpl;
import com.student.pojo.Users;
import com.student.service.IUsersService;

import java.sql.Connection;

public class UsersServiceImpl implements IUsersService {
    Connection conn = null;
    UsersDaoImpl usersDao = null;
    public UsersServiceImpl(Connection conn) {
        this.conn = conn;
        usersDao = new UsersDaoImpl(conn);
    }
    /**
     * 验证用户名和密码
     * @author Luke
     * @param u_name 用户名
     * @param u_pwd 密码
     * @return
     */
    @Override
    public boolean verifyUsers(String u_name, String u_pwd) {
        boolean flag = false;
        Users users = usersDao.findUserByU_name(u_name);
        if(users != null) {
            if(users.getU_name().equals(u_name) &&
                users.getU_pwd().equals(u_pwd)) {
                flag = true;
            }
        }

        return flag ;
    }

    @Override
    public Users findUsers(String u_name) {
        Users users = null;
        users = usersDao.findUserByU_name(u_name);
        return users;
    }

    @Override
    public boolean alterPwd(Users users) {
        return usersDao.updateUserPwd(users);
    }
}
