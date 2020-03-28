package com.student.pojo;

import java.io.Serializable;

public class Users implements Serializable {
    public final static long serialVersionUID = 100L;

    private Integer u_id;
    private String u_name;
    private String u_pwd;
    private String u_prio;


    public  Users() {

    }
    public Users(Integer u_id, String u_name, String u_pwd, String u_prio) {
        this.u_id = u_id;
        this.u_name = u_name;
        this.u_pwd = u_pwd;
        this.u_prio = u_prio;
    }

    public Integer getU_id() {
        return u_id;
    }

    public void setU_id(Integer u_id) {
        this.u_id = u_id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getU_pwd() {
        return u_pwd;
    }

    public void setU_pwd(String u_pwd) {
        this.u_pwd = u_pwd;
    }

    public String getU_prio() {
        return u_prio;
    }

    public void setU_prio(String u_prio) {
        this.u_prio = u_prio;
    }

    @Override
    public String toString() {
        return "Users{" +
                "u_id=" + u_id +
                ", u_name='" + u_name + '\'' +
                ", u_pwd='" + u_pwd + '\'' +
                ", u_prio='" + u_prio + '\'' +
                '}';
    }
}
