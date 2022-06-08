package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import util.DbUtils;

public class TrainerService {

    public void insertTrainer() {

        Connection con = DbUtils.getConnection();
        System.out.println("Give trainer's first name :");
        Scanner sc = new Scanner(System.in);
        String fname = sc.nextLine();
        System.out.println("Give trainer's last name :");
        String lname = sc.nextLine();
        System.out.println("Give trainer's subject :");
        String subject = sc.nextLine();
        String sql = "Insert into trainers (firstName,lastName,Tr_Subject) values(?,?,?)";
        PreparedStatement pst = null;
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, fname);
            pst.setString(2, lname);
            pst.setString(3, subject);
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
