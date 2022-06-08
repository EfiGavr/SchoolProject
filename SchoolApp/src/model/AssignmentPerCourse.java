
package model;

import java.util.Date;

public class AssignmentPerCourse {
    
    private String title;
    private String type;
    private String stream;
    private String description;
    private Date SubDate;
    private float totalMark;
    private float oralMark;

    public AssignmentPerCourse() {
    }

    public AssignmentPerCourse(String title, String type, String stream, String description, Date SubDate, float totalMark, float oralMark) {
        this.title = title;
        this.type = type;
        this.stream = stream;
        this.description = description;
        this.SubDate = SubDate;
        this.totalMark = totalMark;
        this.oralMark = oralMark;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getSubDate() {
        return SubDate;
    }

    public void setSubDate(Date SubDate) {
        this.SubDate = SubDate;
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
