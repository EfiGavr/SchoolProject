package Service;

import dao.CoursesDao;
import dao.StudentsDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.Scanner;
import util.DbUtils;
import util.Validation;

public class AssignmentPerStudentPerCourseServise {

    public void insertAssignmentPerStudentPerCourse() {

        Connection con = DbUtils.getConnection();

        System.out.println("Give assignments's description :");
        Scanner sc = new Scanner(System.in);
        String description = sc.nextLine();

        // submition date time get and validation
        Validation validation = new Validation();

        System.out.println("Give Assignment's submition's date and time at format yyyy-MM-dd HH:mm:ss");
        String subDateTime = sc.nextLine();
        while (!validation.isValidLocalDateTime(subDateTime)) {
            System.out.println("Wrong input!!! Give Assignment's submition's date and time at format yyyy-MM-dd HH:mm:ss");
            subDateTime = sc.nextLine();
        }

        // oral mark get and validation
        float oralMark = 0.0f;
        System.out.println("Give Assignment's oral mark");
        while (!sc.hasNextFloat()) {
            System.out.println("Wrong input ! Assignment's oral mark should be a number. For decimal numbers use a '.' (dot) for decimal parts. Give the oral mark again.");
            sc.nextLine();

        }
        oralMark = sc.nextFloat();

        //total mark get and validation
        float totalMark = 0.0f;
        System.out.println("Give Assignment's total mark");
        while (!sc.hasNextFloat()) {
            System.out.println("Wrong input ! Assignment's total mark should be a number. For decimal numbers use a ',' (comma) for decimal parts. Give the oral mark again.");
            sc.nextLine();
        }
        totalMark = sc.nextFloat();

        CoursesDao courses = new CoursesDao();
        courses.getAllCourses();

        System.out.println("Type the id of the course you want to add the assignment in");
        int c_id = sc.nextInt();

        PreparedStatement pst = null;
        ResultSet rs = null;

        String sql = "Select C_ID from courses where C_ID ='" + c_id + "'";
//        System.out.println(sql);
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (!rs.next()) {

                courses.getAllCourses();
                System.out.println("You gave a wrong id. Type again." + "\n");
                c_id = sc.nextInt();
                sql = "Select C_ID from courses where C_ID ='" + c_id + "'";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
            }
            String sqlass = "Insert into assignments (as_description,SubDateTime,TotalMark,OralMark,Course_ID) values(?,?,?,?,?)";

            pst = con.prepareStatement(sqlass);
            pst.setString(1, description);
            pst.setString(2, subDateTime);
            pst.setFloat(3, oralMark);
            pst.setFloat(4, totalMark);
            pst.setInt(5, c_id);

            pst.executeUpdate();

            int assignment_id = rs.getInt(1);
            String sqlinsert = "Insert into assignment_per_course_per_student (A_ID) values(?)";
            pst = con.prepareStatement(sqlinsert);
            pst.setInt(1, assignment_id);

            String sqlCourse = "Select * from courses where C_ID ='" + c_id + "'";
            pst = con.prepareStatement(sqlCourse);
            ResultSet rs2 = pst.executeQuery();

            int courseId = rs2.getInt(1);
            String title = rs2.getString(2);
            String stream = rs2.getString(3);
            String type = rs2.getString(4);
            Date startDate = rs2.getDate(5);
            Date endDate = rs2.getDate(6);

            String sql2 = "Insert into assignment_per_course_per_student (C_ID,Title,Course_Stream,Course_Type,StartDate,EndDate,as_description,SubDateTime,TotalMark,OralMark,Course_ID) values(?,?,?,?,?,?,?,?,?,?,?)";

            pst = con.prepareStatement(sql2);
            pst.setInt(1, courseId);
            pst.setString(2, title);
            pst.setString(3, stream);
            pst.setString(4, type);
            pst.setDate(5, startDate);
            pst.setDate(6, endDate);
            pst.setString(7, description);
            pst.setString(8, subDateTime);
            pst.setFloat(9, oralMark);
            pst.setFloat(10, totalMark);
            pst.setInt(11, c_id);

            StudentsDao students = new StudentsDao();
            students.getAllStudents();
            System.out.println("\n" + "Type the id of the student you want to add in a course" + "\n");
            int s_id = sc.nextInt();
            pst = null;
            rs = null;

            sql = "Select St_ID from students where St_ID ='" + s_id + "'";

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

            String sqlStudent = "Select * from students where St_ID ='" + s_id + "'";
            pst = con.prepareStatement(sqlStudent);

            int studentId = rs.getInt(1);
            String firstName = rs.getString(2);
            String lastName = rs.getString(3);
            Date Date = rs.getDate(4);
            int fees = rs.getInt(5);

            sql2 = "Insert into assignment_per_course_per_student (St_ID,firstName,lastName,DateOfBirth,TuitionFees) values(?,?,?,?,?)";
            pst = con.prepareStatement(sql2);
            pst.setInt(1, studentId);
            pst.setString(2, firstName);
            pst.setString(3, lastName);
            pst.setDate(4, Date);
            pst.setInt(5, fees);

            pst.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                pst.close();
                con.close();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(TrainerService.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
    }
}
