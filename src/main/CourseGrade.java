package main;

import util.Grade;

public class CourseGrade {

    private String courseDepartment;
    private int courseCode;
    private int courseCredit;
    private Grade gradeTaken;

    public CourseGrade(String courseDepartment) {
        this(courseDepartment, 100, 4, Grade.F);
    }

    public CourseGrade(String courseDepartment, int courseCode) {
        this(courseDepartment, courseCode, 4, Grade.F);
    }

    public CourseGrade(String courseDepartment, int courseCode, int courseCredit) {
        this(courseDepartment, courseCode, courseCredit, Grade.F);
    }

    public CourseGrade(String courseDepartment, int courseCode, int courseCredit, Grade gradeTaken) {
        setCourseDepartment(courseDepartment);
        setCourseCode(courseCode);
        setCourseCredit(courseCredit);
        setGradeTaken(gradeTaken);
    }

    public String getCourseDepartment() {
        return courseDepartment;
    }

    public void setCourseDepartment(String courseDepartment) {
        String[] courseDepartments = {"CENG", "COMP", "ECE", "ME", "MATH"};
        for (String department : courseDepartments) {
            if (courseDepartment.toUpperCase().equals(department)) {
                this.courseDepartment = courseDepartment;
                return;
            }
        }
        this.courseDepartment = "CENG";
    }

    public int getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(int courseCode) {
        if (courseCode >= 100 && courseCode <= 599) {
            this.courseCode = courseCode;
            return;
        }
        this.courseCode = 100;
    }

    public int getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(int courseCredit) {
        if (courseCredit == 3) {
            this.courseCredit = courseCredit;
            return;
        }
        this.courseCredit = 4;
    }

    public Grade getGradeTaken() {
        return gradeTaken;
    }

    public void setGradeTaken(double val) {
        double raundVal = Math.round(val);
        if (raundVal == 0) {
            this.gradeTaken = Grade.F;
        } else if (raundVal == 1) {
            this.gradeTaken = Grade.D;
        } else if (raundVal == 2) {
            this.gradeTaken = Grade.C;
        } else if (raundVal == 3) {
            this.gradeTaken = Grade.B;
        } else {
            this.gradeTaken = Grade.A;
        }
    }

    public void setGradeTaken(Grade g) {
        this.gradeTaken = g;
    }

    @Override
    public String toString() {
        return "Department: " + courseDepartment  +
                "  CourseCode: " + courseCode +
                "  Credit: " + courseCredit +
                "  Grade: " + gradeTaken.stringValue;
    }
}
