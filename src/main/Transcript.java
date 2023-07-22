package main;

import java.util.ArrayList;
import java.util.List;

public class Transcript {

    private int studentID;
    private List<CourseGrade> courseGradeList;
    private double GPA;

    public Transcript(int studentID) {
        this.studentID = studentID;
        this.GPA = 0.0;
        this.courseGradeList = new ArrayList<>();
    }

    public void addCourseTaken(CourseGrade courseGrade){
        if (courseGrade != null) {
            this.courseGradeList.add(courseGrade);
            calculateGPA();
        } else {
            System.err.println("Course Grade not found!");
        }
    }

    public void calculateGPA(){

        double totalGrade = 0.0;
        int totalCredits = 0;

        for (CourseGrade courseGrade : courseGradeList) {
            totalGrade += courseGrade.getGradeTaken().getNumericValue() * courseGrade.getCourseCredit();
            totalCredits += courseGrade.getCourseCredit();
        }

        if (totalCredits != 0) {
            this.GPA = totalGrade / totalCredits;
        } else {
            this.GPA = 0.0;
        }
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public List<CourseGrade> getCourseGradeList() {
        return courseGradeList;
    }

    public void setCourseGradeList(List<CourseGrade> courseGradeList) {
        this.courseGradeList = courseGradeList;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        String gradeList = courseGradeList.toString().replaceAll("\\[", "")
                .replaceAll(", ", "\n")
                .replaceAll("]", "");

        return  "Student ID: " + studentID + "\n" +
                gradeList +
                "\nGPA: " + Math.round(GPA * 10.0)/10.0;
    }
}
