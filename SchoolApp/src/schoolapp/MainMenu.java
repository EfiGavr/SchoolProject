package schoolapp;

import Service.AssignmentPerStudentPerCourseServise;
import Service.AssignmentService;
import Service.CourseServise;
import Service.StudentPerCourseServise;
import Service.StudentServise;
import Service.TrainerPerCourseService;
import Service.TrainerService;
import dao.AssignmentPerCourseDao;
import dao.AssignmentPerCoursePerStudentDao;
import dao.AssignmentsDao;
import dao.CoursesDao;
import dao.StudentPerCourseDao;
import dao.StudentToManyCoursesDao;
import dao.StudentsDao;
import dao.TrainerPerCourseDao;
import dao.TrainersDao;
import java.util.Scanner;

public class MainMenu {

    StudentsDao sds = new StudentsDao();
    AssignmentsDao ads = new AssignmentsDao();
    TrainersDao tds = new TrainersDao();
    CoursesDao cds = new CoursesDao();
    StudentPerCourseDao stPcds = new StudentPerCourseDao();
    TrainerPerCourseDao tpcds = new TrainerPerCourseDao();
    AssignmentPerCourseDao aspcds = new AssignmentPerCourseDao();
    AssignmentPerCoursePerStudentDao asPercPerST = new AssignmentPerCoursePerStudentDao();
    StudentToManyCoursesDao manyCds = new StudentToManyCoursesDao();

    public void mainMenu() {
        System.out.println("Welcome to School Application !" + "\n"
                + "Give 1 for school's data," + "\n"
                + "Give 2 for inserting data," + "\n"
                + "Give 0 for terminating the application");
        Scanner sc = new Scanner(System.in);
        int entry1 = sc.nextInt();
        while ((entry1 != 1) && (entry1 != 2) && (entry1 != 0)) {
            System.out.println("Wrong Choice !!!"
                    + "give 1 for school's data,"
                    + "give 2 for inserting data."
                    + "give 0 for terminating the application");
            entry1 = sc.nextInt();
        }
        while (entry1 != 0) {
            if (entry1 == 1) {
                System.out.println("\n" + "Give 1 for a list of all the students," + "\n"
                        + "give 2 for a list of all the trainers" + "\n"
                        + "give 3 for a list of all the assignments" + "\n"
                        + "give 4 for a list of all the courses" + "\n"
                        + "give 5 for a list of all the students per course" + "\n"
                        + "give 6 for a list of all the trainers per course" + "\n"
                        + "give 7 for a list of all the assignments per course" + "\n"
                        + "give 8 for a list of all the assignments per course per student" + "\n"
                        + "give 9 for a list of all the students that belong to many courses" + "\n"
                        + "give 0 for terminating the application");
                int entry2 = sc.nextInt();
                while ((entry2 != 1) && (entry2 != 2) && (entry2 != 3) && (entry2 != 4) && (entry2 != 5) && (entry2 != 6) && (entry2 != 7) && (entry2 != 8) && (entry2 != 9) && (entry2 != 0)) {
                    System.out.println("Wrong input !!!" + "\n"
                            + "Give 1 for a list of all the students," + "\n"
                            + "give 2 for a list of all the trainers" + "\n"
                            + "give 3 for a list of all the assignments" + "\n"
                            + "give 4 for a list of all the courses" + "\n"
                            + "give 5 for a list of all the students per course" + "\n"
                            + "give 6 for a list of all the trainers per course" + "\n"
                            + "give 7 for a list of all the assignments per course" + "\n"
                            + "give 8 for a list of all the assignments per course per student" + "\n"
                            + "give 9 for a list of all the students that belong to many courses" + "\n"
                            + "give 0 for terminating the application");
                    entry2 = sc.nextInt();
                }
                switch (entry2) {
                    case 1:
                        System.out.println("Student's list : " + "\n");
                        sds.getAllStudents();
                        break;
                    case 2:
                        System.out.println("Trainer's list : " + "\n");
                        tds.getAllTrainers();
                        break;

                    case 3:
                        System.out.println("Assignment's list : " + "\n");
                        ads.getAllAssignments();
                        break;

                    case 4:
                        System.out.println("Course's list : " + "\n");
                        cds.getAllCourses();
                        break;

                    case 5:
                        System.out.println("Student per course's list : " + "\n");
                        stPcds.getAllStudentsPerCourse();
                        break;

                    case 6:
                        System.out.println("Trainer per course's list : " + "\n");
                        tpcds.getAllTrainersPerCourse();
                        break;
                    case 7:
                        System.out.println("Assignment per course's list : " + "\n");
                        aspcds.getAllAssignmentsPerCourse();
                        break;
                    case 8:
                        System.out.println("Assignment per courseper student's list : " + "\n");
                        asPercPerST.getAllAssignmentsPerCoursePerStudent();
                        break;
                    case 9:
                        System.out.println("Students that belong to many courses list : " + "\n");
                        manyCds.getAllStudentsToManyCourses();
                        break;
                    case 0:
                        entry1 = 0;
                        break;
                }
            } else if (entry1 == 2) {
                System.out.println("\n" + "Give 1 for insert students," + "\n"
                        + "give 2 for insert trainers" + "\n"
                        + "give 3 for insert assignments" + "\n"
                        + "give 4 for insert courses" + "\n"
                        + "give 5 for insert students per course" + "\n"
                        + "give 6 for insert trainers per course" + "\n"
                        + "give 7 for insert assignments per course per student" + "\n"
                        + "give 0 for terminating the application");
                int entry3 = sc.nextInt();
                while ((entry3 != 1) && (entry3 != 2) && (entry3 != 3) && (entry3 != 4) && (entry3 != 5) && (entry3 != 6) && (entry3 != 7) && (entry3 != 0)) {
                    System.out.println("Wrong input !!!" + "\n"
                            + "Give 1 for insert students," + "\n"
                            + "give 2 for insert trainers" + "\n"
                            + "give 3 for insert assignments" + "\n"
                            + "give 4 for insert courses" + "\n"
                            + "give 5 for insert students per course" + "\n"
                            + "give 6 for insert trainers per course" + "\n"
                            + "give 7 for insert assignments per course per student" + "\n"
                            + "give 0 for terminating the application");
                    entry3 = sc.nextInt();
                }
                switch (entry3) {
                    case 1:
                        System.out.println("Insert Student");
                        StudentServise insStud = new StudentServise();
                        insStud.insertStudent();
                        break;
                    case 2:
                        System.out.println("Insert Trainer");
                        TrainerService instr = new TrainerService();
                        instr.insertTrainer();
                        break;
                    case 3:
                        System.out.println("Insert Assignment");
                        AssignmentService insAs = new AssignmentService();
                        insAs.insertAssignment();
                        break;
                    case 4:
                        System.out.println("Insert Course");
                        CourseServise insC = new CourseServise();
                        insC.insertCourse();
                        break;
                    case 5:
                        System.out.println("Insert Student Per Course");
                        StudentPerCourseServise insSpC = new StudentPerCourseServise();
                        insSpC.insertStudentPerCourse();
                        break;
                    case 6:
                        System.out.println("Insert Trainer Per Course");
                        TrainerPerCourseService insTr = new TrainerPerCourseService();
                        insTr.insertTrainerPerCourse();
                        break;
                    case 7:
                        System.out.println("Insert Assignment Per Course Per Student");
                        AssignmentPerStudentPerCourseServise insertLast = new AssignmentPerStudentPerCourseServise();
                        insertLast.insertAssignmentPerStudentPerCourse();
                        break;
                    case 0:
                        entry1 = 0;
                        break;
                }
            } else {
                System.out.println("Terminating the programe...");
            }
        }
    }
}
