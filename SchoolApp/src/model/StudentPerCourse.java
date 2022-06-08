package model;

import java.util.Date;

public class StudentPerCourse {

    private int course_Id;
    private String courseTitle;
    private String courseStream;
    private String courseType;
    private Date startDateCourse;
    private Date endDateCourse;
    private int student_Id;
    private String fisrstName;
    private String lastName;
    private Date birth;
    private int tuitionFees;

    public StudentPerCourse() {
    }

    public StudentPerCourse(int course_Id, String courseTitle, String courseStream, String courseType, Date startDateCourse, Date endDateCourse, int student_Id, String fisrstName, String lastName, Date birth, int tuitionFees) {
        this.course_Id = course_Id;
        this.courseTitle = courseTitle;
        this.courseStream = courseStream;
        this.courseType = courseType;
        this.startDateCourse = startDateCourse;
        this.endDateCourse = endDateCourse;
        this.student_Id = student_Id;
        this.fisrstName = fisrstName;
        this.lastName = lastName;
        this.birth = birth;
        this.tuitionFees = tuitionFees;
    }

    public int getCourse_Id() {
        return course_Id;
    }

    public void setCourse_Id(int course_Id) {
        this.course_Id = course_Id;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseStream() {
        return courseStream;
    }

    public void setCourseStream(String courseStream) {
        this.courseStream = courseStream;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public Date getStartDateCourse() {
        return startDateCourse;
    }

    public void setStartDateCourse(Date startDateCourse) {
        this.startDateCourse = startDateCourse;
    }

    public Date getEndDateCourse() {
        return endDateCourse;
    }

    public void setEndDateCourse(Date endDateCourse) {
        this.endDateCourse = endDateCourse;
    }

    public int getStudent_Id() {
        return student_Id;
    }

    public void setStudent_Id(int student_Id) {
        this.student_Id = student_Id;
    }

    public String getFisrstName() {
        return fisrstName;
    }

    public void setFisrstName(String fisrstName) {
        this.fisrstName = fisrstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public int getTuitionFees() {
        return tuitionFees;
    }

    public void setTuitionFees(int tuitionFees) {
        this.tuitionFees = tuitionFees;
    }

   
}
