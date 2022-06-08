package Service;

import dao.CoursesDao;
import dao.TrainersDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import util.DbUtils;

public class TrainerPerCourseService {

    public void insertTrainerPerCourse() {
        
        boolean flag = true;
        while (flag) {
            Connection con = DbUtils.getConnection();
            TrainersDao trainers = new TrainersDao();
            Scanner sc = new Scanner(System.in);
            trainers.getAllTrainers();
            System.out.println("\n" + "Type the id of the student you want to add in a course" + "\n");
            int t_id = sc.nextInt();
            PreparedStatement pst = null;
            ResultSet rs = null;
            String sql = "Select T_ID from trainers where T_ID ='" + t_id + "'";
            try {
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                while (!rs.next()) {
                    trainers.getAllTrainers();
                    System.out.println("\n" + "You gave a wrong id. Type again." + "\n");
                    t_id = sc.nextInt();
                    sql = "Select T_ID from trainers where T_ID ='" + t_id + "'";
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
            sql = "Select * from trainer_per_course where Train_ID ='" + t_id + "' and Cor_ID ='" + c_id + "'";
            try {
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                if (!rs.next()) {
                    String sql2 = "Insert into trainer_per_course (Train_ID,Cor_ID) values(?,?)";
                    pst = con.prepareStatement(sql2);
                    pst.setInt(1, t_id);
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
