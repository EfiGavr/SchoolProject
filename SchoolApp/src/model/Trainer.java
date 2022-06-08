
package model;

public class Trainer {
    
    private int t_id;
    private String firtName;
    private String lastName;
    private String subject;

    public Trainer() {
    }

    public Trainer(int t_id, String firtName, String lastName, String subject) {
        this.t_id = t_id;
        this.firtName = firtName;
        this.lastName = lastName;
        this.subject = subject;
    }

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public String getFirtName() {
        return firtName;
    }

    public void setFirtName(String firtName) {
        this.firtName = firtName;
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
