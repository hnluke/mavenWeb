package com.student.pojo;

import java.io.Serializable;
import java.util.Date;

public class Stu_info implements Serializable {
    public final static long serialVersionUID = 100L;

    private Integer s_id;
    private String s_no;
    private String s_name;
    private String s_sex;
    private String s_major;
    private String s_status;
    private String born;
    private String s_regtime;

    public Integer getS_id() {
        return s_id;
    }

    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    public String getS_no() {
        return s_no;
    }

    public void setS_no(String s_no) {
        this.s_no = s_no;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getS_major() {
        return s_major;
    }

    public void setS_major(String s_major) {
        this.s_major = s_major;
    }

    public String getS_status() {
        return s_status;
    }

    public void setS_status(String s_status) {
        this.s_status = s_status;
    }

    public String getS_regtime() {
        return s_regtime;
    }

    public void setS_regtime(String s_regtime) {
        this.s_regtime = s_regtime;
    }

    public String getS_sex() {
        return s_sex;
    }

    public void setS_sex(String s_sex) {
        this.s_sex = s_sex;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }
}
