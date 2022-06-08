package Service;

import dao.CoursesDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import util.DbUtils;
import util.Validation;

public class AssignmentService {

    public void insertAssignment() {

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
        System.out.println(sql);
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
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        String sql2 = "Insert into assignments (as_description,SubDateTime,TotalMark,OralMark,Course_ID) values(?,?,?,?,?)";

        try {
            pst = con.prepareStatement(sql2);
            pst.setString(1, description);
            pst.setString(2, subDateTime);
            pst.setFloat(3, oralMark);
            pst.setFloat(4, totalMark);
            pst.setInt(5, c_id);

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
