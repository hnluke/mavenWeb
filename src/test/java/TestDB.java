import com.student.dao.impl.Stu_infoDaoImpl;
import com.student.db.DBConnection;
import com.student.pojo.Stu_info;

import java.sql.Connection;

public class TestDB {
    public static void main(String[] args) {
        Connection conn = DBConnection.getConnect("c3p0");
        Stu_info stu_info = new Stu_info();
        stu_info.setS_no("002");
        stu_info.setS_name("Lisa");
        stu_info.setS_major("Network");
        stu_info.setS_status("Learning");
        Stu_infoDaoImpl stu_infoDao = new Stu_infoDaoImpl(conn);
        if(stu_infoDao.insertStu_info(stu_info)) {
            System.out.println("注册学生信息成功");
        }else{
            System.out.println("注册学生信息失败");
        }
    }
}
