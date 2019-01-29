package Assignment01;

/**
 * This assignment is designed according to the MVC guidelines
 * 
 * @author Dennis den Hollander (s4776658)
 * @author Tom Kamp (s4760921)
 */
public class Main {

    public final static View VIEW = new View();
    
    public static void main (String[] args) {
        int groupSize = VIEW.enterGroupSize();
        
        Group students = new Group(groupSize);
        for (int index = 0; index < groupSize; index++) {
            String[] newStudent = VIEW.enterStudent();
            
            if (newStudent.length > 2) {
                int studentNumber = Integer.parseInt(newStudent[0]);
                String firstName = newStudent[1];
                String surName = newStudent[2];
                
                Student student = new Student(firstName, surName, studentNumber);
                students.addStudent(student, index);
            }
        }
        
        VIEW.updateGroup(students);
        
        while(true) {
            String[] adjustedStudent = VIEW.adjustStudent();
            
            if (adjustedStudent.length < 3) {
                if (adjustedStudent.length < 2) {
                    if (Integer.parseInt(adjustedStudent[0]) < 0) {
                        // The user entered a negative number to terminate the program 
                        VIEW.terminate();
                        break;
                    }
                }
                
                // The user entered a malformed input
                VIEW.invalidInput();
                continue;
            }
            
            int studentNumber = Integer.parseInt(adjustedStudent[0]);
            String firstName = adjustedStudent[1];
            String surName = adjustedStudent[2];
            
            Student student = students.getStudent(studentNumber);
            if (student == null) {
                // A student with the specified studentNumber could not be found
                VIEW.invalidStudent();
                continue;
            }
            
            student.setFirstName(firstName);
            student.setSurName(surName);
            
            VIEW.updateGroup(students);
        }
    }
    
}
