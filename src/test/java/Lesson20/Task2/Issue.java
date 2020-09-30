package Lesson20.Task2;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Issue {
    @XmlValue
    private String issue2;

    @XmlAttribute (name = "type")
    private Integer type;

    public Issue() {
    }

    public Issue(String issue2, Integer type) {
        this.issue2 = issue2;
        this.type = type;
    }

    public String getIssue2() {
        return issue2;
    }

    public void setIssue2(String issue2) {
        this.issue2 = issue2;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "issue2='" + issue2 + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
