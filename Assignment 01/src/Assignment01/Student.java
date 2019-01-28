package Assignment01;

/**
 * This class represents information about a student
 * 
 * @author Dennis den Hollander (s4776658)
 * @author Tom Kamp (s4760921)
 */
public class Student {

    private String fullName;
    private final int STUDENT_NUMBER;
    
    public Student (String fullName, int studentNumber) {
        this.fullName = fullName;
        this.STUDENT_NUMBER = studentNumber;
    }
    
    public void setName(String newName) {
        this.fullName = newName;
    }
    
    public int getStudentNumber() {
        return this.STUDENT_NUMBER;
    }
    
    @Override
    public String toString() {
        return fullName + ", " + "s" + STUDENT_NUMBER;
    }
    
}
