
package model;

import java.util.Date;


public class Course {
    
    private int c_id;
    private String title;
    private String tream;
    private String type;
    private Date startDate;
    private Date endDate;

    public Course() {
    }

    public Course(int c_id, String title, String tream, String type, Date startDate, Date endDate) {
        this.c_id = c_id;
        this.title = title;
        this.tream = tream;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTream() {
        return tream;
    }

    public void setTream(String tream) {
        this.tream = tream;
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
    
    
    
}
