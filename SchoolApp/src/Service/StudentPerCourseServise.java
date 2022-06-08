package Service;

import dao.CoursesDao;
import dao.StudentsDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import util.DbUtils;

public class StudentPerCourseServise {

    public void insertStudentPerCourse() {

        boolean flag = true;
        while (flag) {
            Connection con = DbUtils.getConnection();
            StudentsDao students = new StudentsDao();
            Scanner sc = new Scanner(System.in);
            students.getAllStudents();
            System.out.println("\n" + "Type the id of the student you want to add in a course" + "\n");
            int s_id = sc.nextInt();

            PreparedStatement pst = null;
            ResultSet rs = null;

            String sql = "Select St_ID from students where St_ID ='" + s_id + "'";
            try {
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();

                while (!rs.next()) {
                    students.getAllStudents();
                    System.out.println("\n" + "You gave a wrong id. Type again." + "\n");
                    s_id = sc.nextInt();
                    sql = "Select St_ID from students where St_ID ='" + s_id + "'";
                    pst = con.prepareStatement(sql);
                    rs = pst.executeQuery();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            CoursesDao courses = new CoursesDao();
            courses.getAllCourses();
            System.out.println("\n" + "Type the id of the course you want to the student in" + "\n");
            int c_id = sc.nextInt();

            pst = null;
            rs = null;

            sql = "Select C_ID from courses where C_ID ='" + c_id + "'";
            try {
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                while (!rs.next()) {
                    courses.getAllCourses();
                    System.out.println("\n" + "You gave a wrong id. Type again." + "\n");
                    c_id = sc.nextInt();
                    sql = "Select C_ID from courses where C_ID ='" + c_id + "'";
                    pst = con.prepareStatement(sql);
                    rs = pst.executeQuery();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            pst = null;
            rs = null;
            sql = "Select * from student_per_course where Stud_ID ='" + s_id + "' and Cour_ID ='" + c_id + "'";
            try {
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                if (!rs.next()) {
                    String sql2 = "Insert into student_per_course (Stud_ID,Cour_ID) values(?,?)";
                    pst = con.prepareStatement(sql2);
                    pst.setInt(1, s_id);
                    pst.setInt(2, c_id);
                    pst.executeUpdate();
                    flag = false;
                } else {
                    courses.getAllCourses();
                    System.out.println("\n" + "The combination of student and course, already exists" + "\n");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    pst.close();
                    con.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(StudentPerCourseServise.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            }
        }
    }
}
