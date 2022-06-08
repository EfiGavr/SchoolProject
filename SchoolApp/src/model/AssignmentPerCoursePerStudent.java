package model;

import java.util.Date;

public class AssignmentPerCoursePerStudent {

    private int st_id;
    private String fName;
    private String lName;
    private Date dObirth;
    private int tuitionFees;
    private int course_id;
    private String title;
    private String stream;
    private String type;
    private Date startDate;
    private Date endDate;
    private int asign_id;
    private String description;
    private Date subDate;
    private float totalMark;
    private float oralMark;

    public AssignmentPerCoursePerStudent() {
    }

    public AssignmentPerCoursePerStudent(int st_id, String fName, String lName, Date dObirth, int tuitionFees, int course_id, String title, String stream, String type, Date startDate, Date endDate, int asign_id, String description, Date subDate, float totalMark, float oralMark) {
        this.st_id = st_id;
        this.fName = fName;
        this.lName = lName;
        this.dObirth = dObirth;
        this.tuitionFees = tuitionFees;
        this.course_id = course_id;
        this.title = title;
        this.stream = stream;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
        this.asign_id = asign_id;
        this.description = description;
        this.subDate = subDate;
        this.totalMark = totalMark;
        this.oralMark = oralMark;
    }

    public int getSt_id() {
        return st_id;
    }

    public void setSt_id(int st_id) {
        this.st_id = st_id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public Date getdObirth() {
        return dObirth;
    }

    public void setdObirth(Date dObirth) {
        this.dObirth = dObirth;
    }

    public int getTuitionFees() {
        return tuitionFees;
    }

    public void setTuitionFees(int tuitionFees) {
        this.tuitionFees = tuitionFees;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getAsign_id() {
        return asign_id;
    }

    public void setAsign_id(int asign_id) {
        this.asign_id = asign_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getSubDate() {
        return subDate;
    }

    public void setSubDate(Date subDate) {
        this.subDate = subDate;
    }

    public float getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(float totalMark) {
        this.totalMark = totalMark;
    }

    public float getOralMark() {
        return oralMark;
    }

    public void setOralMark(float oralMark) {
        this.oralMark = oralMark;
    }
    
    

}
