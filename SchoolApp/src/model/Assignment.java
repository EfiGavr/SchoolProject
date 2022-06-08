package model;

import java.util.Date;

public class Assignment {

    private int a_id;
    private String description;
    private Date subDate;
    private float totalMark;
    private float oralMark;

    public Assignment() {
    }

    public Assignment(int a_id, String description, Date subDate, float totalMark, float oralMark) {
        this.a_id = a_id;
        this.description = description;
        this.subDate = subDate;
        this.totalMark = totalMark;
        this.oralMark = oralMark;
    }

    public int getA_id() {
        return a_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
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
