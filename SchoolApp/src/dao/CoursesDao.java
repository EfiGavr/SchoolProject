package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Course;
import util.DbUtils;
import java.sql.SQLException;

public class CoursesDao {

    public List<Course> getAllCourses() {

        List<Course> courses = new ArrayList<>();
        Connection con = DbUtils.getConnection();
        String sql = "Select * from courses";
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getDate(5) + " " + rs.getDate(6));
                Course course = new Course(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getDate(6));
                courses.add(course);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pst.close();
                con.close();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(CoursesDao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
        return courses;
    }
}
