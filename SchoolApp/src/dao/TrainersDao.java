package dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import model.Trainer;
import util.DbUtils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TrainersDao {

    public List<Trainer> getAllTrainers() {

        Connection con = DbUtils.getConnection();
        List<Trainer> trainers = new ArrayList<>();
        String sql = "Select * from trainers";
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
                Trainer trainer = new Trainer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                trainers.add(trainer);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pst.close();
                con.close();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(TrainersDao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
        return trainers;
    }
}
