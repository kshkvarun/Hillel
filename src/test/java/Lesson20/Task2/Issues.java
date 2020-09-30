package Lesson20.Task2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;

@XmlAccessorType(XmlAccessType.FIELD)
public class Issues {

    @XmlElement(name = "Issue")
    private ArrayList<Issue> issues1;

    public Issues() {
    }

    public Issues(ArrayList<Issue> issues1) {
        this.issues1 = issues1;
    }

    public ArrayList<Issue> getIssues1() {
        return issues1;
    }

    public void setIssues1(ArrayList<Issue> issues1) {
        this.issues1 = issues1;
    }

    @Override
    public String toString() {
        return "Issues{" +
                "issues1=" + issues1 +
                '}';
    }
}
