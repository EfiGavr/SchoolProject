package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
import util.DbUtils;
import util.Validation;
import java.sql.Date;
import java.sql.SQLException;

public class StudentServise {

    public void insertStudent() {

        Connection con = DbUtils.getConnection();
        System.out.println("Give student's first name :");
        Scanner sc = new Scanner(System.in);
        String fname = sc.nextLine();
        System.out.println("Give student's last name :");
        String lname = sc.nextLine();
        System.out.println("Give student's date of birth (YYYY-MM-DD) :");
        String date = sc.nextLine();
        Validation validation = new Validation();
        while (!validation.isValidLocalDate(date)) {
            System.out.println("The date of birth should be at format 'yyyy-MM-dd'");
            date = sc.nextLine();
        }
        Date dateOfBirth = Date.valueOf(date);
        int tuitionFees = 0;
        System.out.println("Give student's tuition fees :");
        while (!sc.hasNextInt()) {
            System.out.println("Wrong input! Tuition fees should be a number without decimal part");
            sc.nextLine();
        }
        tuitionFees = sc.nextInt();
        String sql = "Insert into students (firstName,lastName,DateOfBirth,TuitionFees) values(?,?,?,?)";
        PreparedStatement pst = null;
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, fname);
            pst.setString(2, lname);
            pst.setDate(3, dateOfBirth);
            pst.setInt(4, tuitionFees);
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                pst.close();
                con.close();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(StudentServise.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
    }
}
