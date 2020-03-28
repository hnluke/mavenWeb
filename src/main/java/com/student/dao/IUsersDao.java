package com.student.dao;

import com.student.pojo.Users;

public interface IUsersDao {

    /**
     * 依据用户名查找用户，并返回用户对象
     * @param u_name 用户名
     * @return 返回用户对象
     */
    public Users findUserByU_name(String u_name);

    /**
     * 修改用户密码
     * @param users 用户名
     * @return 修改成功返回true
     */
    public boolean updateUserPwd(Users users);


}
