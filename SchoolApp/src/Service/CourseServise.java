package Service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import util.DbUtils;
import util.Validation;

public class CourseServise {

    public void insertCourse() {

        Connection con = DbUtils.getConnection();

        System.out.println("Give course's title :");
        Scanner sc = new Scanner(System.in);
        String title = sc.nextLine();

        System.out.println("Give course's stream :");
        String stream = sc.nextLine();

        System.out.println("Give course's type :");
        String type = sc.nextLine();
        System.out.println("Give course's start date :");
        String date = sc.nextLine();
        Validation validation = new Validation();

        // date format get and validation
        while (!validation.isValidLocalDate(date)) {
            System.out.println("The date of birth should be at format 'yyyy-MM-dd'");
            date = sc.nextLine();
        }
        Date startDate = Date.valueOf(date);

        System.out.println("Give course's end date :");
        String date2 = sc.nextLine();

        while (!validation.isValidLocalDate(date2)) {
            System.out.println("The date of birth should be at format 'yyyy-MM-dd'");
            date2 = sc.nextLine();
        }
        Date endDate = Date.valueOf(date2);

        String sql = "Insert into courses (Title,Course_Stream,Course_Type,StartDate,EndDate) values(?,?,?,?,?)";
        PreparedStatement pst = null;
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, title);
            pst.setString(2, stream);
            pst.setString(3, type);
            pst.setDate(4, startDate);
            pst.setDate(5, endDate);

            pst.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {

            try {
//                rs.close();
                pst.close();
                con.close();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(CourseServise.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
    }
}
