package lab1.strategy;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String lastName;
    private List<Subject> subjects = new ArrayList<>();
    private double average;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public Student() {
    }

    public Student(String lastName, ArrayList<Subject> subjects, double average) {
        this.lastName = lastName;
        this.subjects = subjects;
        this.average = average;
    }

    public void addSubject(Subject subject) {
        this.subjects.add(subject);
    }

    public void checkAverage() throws Exception {
        if (subjects.size() == 0) {
            throw new Exception("No mark");
        }

        double average = subjects.stream().mapToInt(Subject::getMark).sum() / (double) subjects.size();
        if (average != this.average) {
            System.out.println("Average is not correct");
            this.average = average;
        }
    }
}
