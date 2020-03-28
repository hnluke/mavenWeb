package com.student.service;

import com.student.pojo.Users;

public interface IUsersService {

    /**
     * 验证用户名和密码
     * @param u_name 用户名
     * @param u_pwd 密码
     * @return 验证成功返回true
     */
    public boolean verifyUsers(String u_name, String u_pwd);

    /**
     * 查找用户
     * @param u_name 用户名
     * @return 返回用户对象
     */
    public Users findUsers(String u_name);

    public boolean alterPwd(Users users);
}
