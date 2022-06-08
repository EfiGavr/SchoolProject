package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.StudentPerCourse;
import util.DbUtils;
import java.sql.SQLException;

public class StudentPerCourseDao {

    public List<StudentPerCourse> getAllStudentsPerCourse() {

        List<StudentPerCourse> studentsPerCourse = new ArrayList<>();
        Connection con = DbUtils.getConnection();
        String sql;
        sql = "select courses.*, students.* "
                + "from students "
                + "join student_per_course "
                + "on student_per_course.Stud_ID=students.St_ID "
                + "join courses "
                + "on courses.C_ID=student_per_course.Cour_ID";
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getDate(5) + " " + rs.getDate(6) + " " + rs.getInt(7) + " " + rs.getString(8) + " " + rs.getString(9) + " " + rs.getDate(10) + " " + rs.getInt(11));
                StudentPerCourse studentPerCourse = new StudentPerCourse(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getDate(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getDate(10), rs.getInt(11));
                studentsPerCourse.add(studentPerCourse);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pst.close();
                con.close();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(StudentPerCourseDao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
        return studentsPerCourse;
    }
}
