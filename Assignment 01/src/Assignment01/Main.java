package Assignment01;

/**
 * This assignment is designed according to the MVC (Model View Controller) guidelines
 * 
 * @author Dennis den Hollander (s4776658)
 * @author Tom Kamp (s4760921)
 */
public class Main {

    public final static View VIEW = new View();
    
    public static void main (String[] args) {
        int groupSize = VIEW.enterGroupSize();
        
        Group students = new Group(new Student[groupSize]);
        for (int student = 0; student < groupSize; student++) {
            String[] newStudent = VIEW.enterStudent().split(" ", 2);
            
            int studentNumber = Integer.parseInt(newStudent[0]);
            String fullName = newStudent[1];
            students.addStudent(new Student(fullName, studentNumber), student);
        }
        
        VIEW.update(students);
        
        while(true) {
            String adjustedStudent = VIEW.adjustStudent();
            boolean isNumeric = VIEW.isNumeric(adjustedStudent);
            if (isNumeric && Integer.parseInt(adjustedStudent) < 0) {
                VIEW.terminate();
                break;
            }
            
            int studentNumber = Integer.parseInt(adjustedStudent.split(" ", 2)[0]);
            String fullName = adjustedStudent.split(" ", 2)[1];
            
            Student student = students.getStudent(studentNumber);
            if (student == null) {
                VIEW.invalidStudent();
                continue;
            }
            student.setName(fullName);
            
            VIEW.update(students);
        }
    }
    
}
