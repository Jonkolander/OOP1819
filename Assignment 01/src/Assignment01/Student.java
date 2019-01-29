package Assignment01;

/**
 * This class represents information about a student
 * 
 * @author Dennis den Hollander (s4776658)
 * @author Tom Kamp (s4760921)
 */
public class Student {

    private String firstName;
    private String surName;
    private final int STUDENT_NUMBER;
    
    public Student (String firstName, String surName, int studentNumber) {
        this.firstName = firstName;
        this.surName = surName;
        this.STUDENT_NUMBER = studentNumber;
    }
    
    public void setFirstName(String newName) {
        this.firstName = newName;
    }
    
    public void setSurName(String newName) {
        this.surName = newName;
    }
    
    public int getStudentNumber() {
        return this.STUDENT_NUMBER;
    }
    
    @Override
    public String toString() {
        return firstName + " " + surName + ", " + "s" + STUDENT_NUMBER;
    }
    
}
