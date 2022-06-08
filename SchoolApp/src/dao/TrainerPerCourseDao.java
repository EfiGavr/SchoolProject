package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.TrainerPerCourse;
import util.DbUtils;

public class TrainerPerCourseDao {

    public List<TrainerPerCourse> getAllTrainersPerCourse() {

        List<TrainerPerCourse> trainersPerCourse = new ArrayList<>();
        Connection con = DbUtils.getConnection();
        String sql;
        sql = "select courses.*, trainers.* from trainers "
                + "join trainer_per_course on trainer_per_course.Train_ID=trainers.T_ID "
                + "join courses on courses.C_ID=trainer_per_course.Cor_ID";
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getDate(5) + " " + rs.getDate(6) + " " + rs.getInt(7) + " " + rs.getString(8) + " " + rs.getString(9) + " " + rs.getString(10));
                TrainerPerCourse trainerPerCourse = new TrainerPerCourse(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getDate(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10));
                trainersPerCourse.add(trainerPerCourse);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pst.close();
                con.close();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(StudentPerCourseDao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
        return trainersPerCourse;
    }
}
