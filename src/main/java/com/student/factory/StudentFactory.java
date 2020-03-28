package com.student.factory;

import com.student.db.DBConnection;
import com.student.service.impl.Stu_infoServiceImpl;
import com.student.service.impl.UsersServiceImpl;

import java.sql.Connection;
import java.sql.SQLException;

public class StudentFactory {
    static Connection conn = null;
    static{
        conn = DBConnection.getConnect("c3p0");
    }

    public static UsersServiceImpl getUsersServiceImpl() {
        return new UsersServiceImpl(conn);
    }

    public static Stu_infoServiceImpl getStu_infoServiceImpl() {
        return new Stu_infoServiceImpl(conn);
    }

    public static void closeConnection() {
        try {
            if(conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
