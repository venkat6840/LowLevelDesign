package creational_patterns.builder;

public class Client {
  public static void main(String args[]) {
    System.out.println("===== Builder Design Pattern =====");

    StudentOrchestrator enggStudentDirector =
        new StudentOrchestrator(new EngineeringStudentBuilder());
    StudentOrchestrator mbaStudentDirector = new StudentOrchestrator(new MBAStudentBuilder());

    // Create students using different builders
    Student engineerStudent = enggStudentDirector.createStudent();
    Student mbaStudent = mbaStudentDirector.createStudent();

    // Print student details
    System.out.println("===> Student details:" + engineerStudent.toString());
    System.out.println("===> Student details:" + mbaStudent.toString());
  }
}
