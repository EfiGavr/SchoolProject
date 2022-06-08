package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Assignment;
import util.DbUtils;

public class AssignmentsDao {

    public List<Assignment> getAllAssignments() {

        Connection con = DbUtils.getConnection();
        List<Assignment> assignments = new ArrayList<>();
        String sql = "Select * from assignments";
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getTimestamp(3) + " " + rs.getFloat(4) + " " + rs.getFloat(5));
                Assignment assignment = new Assignment(rs.getInt(1), rs.getString(2), rs.getTimestamp(3), rs.getFloat(4), rs.getFloat(5));
                assignments.add(assignment);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pst.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(AssignmentsDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return assignments;
    }
}


