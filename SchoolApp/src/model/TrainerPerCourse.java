
package model;

import java.util.Date;


public class TrainerPerCourse {
    private int course_Id;
    private String courseTitle;
    private String courseStream;
    private String courseType;
    private Date startDateCourse;
    private Date endDateCourse;
    private int trainer_Id;
    private String fisrstName;
    private String lastName;
    private String subject;

    public TrainerPerCourse() {
    }

    public TrainerPerCourse(int course_Id, String courseTitle, String courseStream, String courseType, Date startDateCourse, Date endDateCourse, int trainer_Id, String fisrstName, String lastName, String subject) {
        this.course_Id = course_Id;
        this.courseTitle = courseTitle;
        this.courseStream = courseStream;
        this.courseType = courseType;
        this.startDateCourse = startDateCourse;
        this.endDateCourse = endDateCourse;
        this.trainer_Id = trainer_Id;
        this.fisrstName = fisrstName;
        this.lastName = lastName;
        this.subject = subject;
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

    public int getTrainer_Id() {
        return trainer_Id;
    }

    public void setTrainer_Id(int trainer_Id) {
        this.trainer_Id = trainer_Id;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    
}
