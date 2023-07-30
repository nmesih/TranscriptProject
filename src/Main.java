import main.CourseGrade;
import main.GenerateTranscript;
import main.Transcript;
import util.Grade;

public class Main {
    public static void main(String[] args) {
        CourseGrade courseGradeComp = new CourseGrade("COMP", 404, 4, Grade.A);
        CourseGrade courseGradeEce = new CourseGrade("ECE", 101, 4, Grade.C);
        CourseGrade courseGradeMath = new CourseGrade("MATH", 305, 3, Grade.B);
        CourseGrade courseGradeCeng = new CourseGrade("CENG", 201, 4, Grade.A);
        CourseGrade courseGradeMe = new CourseGrade("ME", 509, 3, Grade.D);


        Transcript transcript = new Transcript(1112234);
        transcript.addCourseTaken(courseGradeComp);
        transcript.addCourseTaken(courseGradeEce);
        transcript.addCourseTaken(courseGradeMath);
        transcript.addCourseTaken(courseGradeCeng);
        transcript.addCourseTaken(courseGradeMe);
        System.out.println(transcript);

        GenerateTranscript generateTranscript = new GenerateTranscript();
        generateTranscript.takeInputFromUser();
        System.out.println("-------------");
        generateTranscript.takeInputFromFile();
    }
}