
package model;

public class StudentToManyCourses {
    
    private int st_id;
    private String fName;
    private String lName;
    private int count;
    private String title;
    private String type;

    public StudentToManyCourses() {
    }

    public StudentToManyCourses(int st_id, String fName, String lName, int count, String title, String type) {
        this.st_id = st_id;
        this.fName = fName;
        this.lName = lName;
        this.count = count;
        this.title = title;
        this.type = type;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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
    
    
    
    
}
