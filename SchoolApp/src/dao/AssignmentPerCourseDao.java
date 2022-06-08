package dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import model.AssignmentPerCourse;
import util.DbUtils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AssignmentPerCourseDao {

    public List<AssignmentPerCourse> getAllAssignmentsPerCourse() {

        List<AssignmentPerCourse> assignmentsPerCourse = new ArrayList<>();
        Connection con = DbUtils.getConnection();
        String sql;
        sql = "select Title, Course_Type, Course_Stream, as_description, SubDateTime, TotalMark, OralMark from courses "
                + "join assignments on courses.C_ID=assignments.Course_ID";
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getDate(5) + " " + rs.getFloat(6) + " " + rs.getFloat(7));
                AssignmentPerCourse assignmentPerCourse = new AssignmentPerCourse(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getFloat(6), rs.getFloat(7));
                assignmentsPerCourse.add(assignmentPerCourse);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pst.close();
                con.close();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(AssignmentPerCourseDao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
        return assignmentsPerCourse;
    }
}
