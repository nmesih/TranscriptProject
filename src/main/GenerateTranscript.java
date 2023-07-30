package main;

import util.Grade;
import util.GradeTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GenerateTranscript {

    public void takeInputFromUser(){

        // Kullanıcıdan input alarak transkripti oluşturuyoruz.
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Student Id: ");
        int studentId = input.nextInt();
        Transcript transcript = new Transcript(studentId);

        while(true) {
            System.out.print("Enter Department: ");
            String department = input.next();

            System.out.print("Enter Course Code: ");
            int courseCode = input.nextInt();

            System.out.print("Enter Credit: ");
            int credit = input.nextInt();

            CourseGrade courseGrade = new CourseGrade(department, courseCode, credit);

            System.out.print("Enter Grade: ");
            courseGrade.setGradeTaken(input.nextDouble());

            transcript.addCourseTaken(courseGrade);

            System.out.println("Do you want to add new course in transcript? (Yes/No)");
            String choice = input.next();

            if(choice.equalsIgnoreCase("No")){
                break;
            } else if (choice.equalsIgnoreCase("Yes")){
                continue;
            } else {
                System.err.println("Wrong input!");
                break;
            }

        }
        System.out.println(transcript);

    }

    public void takeInputFromFile() {

        // text dosyasındaki bilgilerle transkript oluşturuyoruz.
        Scanner input = new Scanner(System.in);

        System.out.print("Enter filename: ");
        try {
            Scanner fileScanner = new Scanner(new File(input.next()));
            int studentId = fileScanner.nextInt();
            fileScanner.nextLine();
            Transcript transcript = new Transcript(studentId);

            while (fileScanner.hasNextLine()) {
                String text = fileScanner.nextLine();
                String[] courseInfo = text.split(" ");
                String courseDepartment = courseInfo[0];
                int courseCode = Integer.parseInt(courseInfo[1]);
                int courseCredit = Integer.parseInt(courseInfo[2]);
                double gradeTaken = Double.parseDouble(courseInfo[3]);
                CourseGrade courseGrade = new CourseGrade(courseDepartment, courseCode, courseCredit);
                courseGrade.setGradeTaken(gradeTaken);
                transcript.addCourseTaken(courseGrade);
            }
            System.out.println(transcript);
            fileScanner.close();

        } catch (FileNotFoundException e) {
            System.err.println("File not found! ");
        }
    }
}
