package dao;

import java.util.ArrayList;
import java.util.List;
import model.StudentToManyCourses;
import util.DbUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentToManyCoursesDao {

    public List<StudentToManyCourses> getAllStudentsToManyCourses() {

        List<StudentToManyCourses> studentsToManyCourses = new ArrayList<>();
        Connection con = DbUtils.getConnection();
        String sql;
        sql = "select Stud_ID as Μαθητες, students.firstName,students.lastName,COUNT(Stud_ID) "
                + "as Πληθος_Μαθημάτων,courses.Title, courses.Course_Type "
                + "FROM student_per_course "
                + "join students on students.St_ID=Stud_ID "
                + "join courses on courses.C_ID=Cour_ID "
                + "GROUP BY Stud_ID "
                + "HAVING COUNT(Stud_ID) > 1";
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getInt(4) + " " + rs.getString(5) + " " + rs.getString(6));
                StudentToManyCourses studentToManyCourses = new StudentToManyCourses(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6));
                studentsToManyCourses.add(studentToManyCourses);
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
        return studentsToManyCourses;
    }
}
