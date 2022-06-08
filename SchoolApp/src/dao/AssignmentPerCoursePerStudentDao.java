package dao;

import java.util.ArrayList;
import java.util.List;
import model.AssignmentPerCoursePerStudent;
import util.DbUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AssignmentPerCoursePerStudentDao {

    public List<AssignmentPerCoursePerStudent> getAllAssignmentsPerCoursePerStudent() {

        List<AssignmentPerCoursePerStudent> assignmentsPerCoursePerStudent = new ArrayList<>();
        Connection con = DbUtils.getConnection();
        String sql;
        sql = "select students.*, C_ID, Title, Course_Stream, Course_Type,StartDate,EndDate, assignments.*  from assignments "
                + "join courses on assignments.Course_ID=courses.C_ID "
                + "join student_per_course on student_per_course.Cour_ID=courses.C_ID "
                + "join students on student_per_course.Stud_ID=students.St_ID";
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getDate(4) + " " + rs.getInt(5) + " " + rs.getInt(6) + " " + rs.getString(7) + " " + rs.getString(8) + " " + rs.getString(9) + " " + rs.getDate(10) + " " + rs.getDate(11) + " " + rs.getInt(12) + " " + rs.getString(13) + " " + rs.getDate(14) + " " + rs.getFloat(15) + " " + rs.getFloat(16));
                AssignmentPerCoursePerStudent assignmentPerCoursePerStudent = new AssignmentPerCoursePerStudent(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getDate(10), rs.getDate(11), rs.getInt(12), rs.getString(13), rs.getDate(14), rs.getFloat(15), rs.getFloat(16));
                assignmentsPerCoursePerStudent.add(assignmentPerCoursePerStudent);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pst.close();
                con.close();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(AssignmentPerCoursePerStudentDao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
        return assignmentsPerCoursePerStudent;
    }
}
