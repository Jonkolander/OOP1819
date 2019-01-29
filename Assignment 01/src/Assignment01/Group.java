package Assignment01;

/**
 * This class represents a group, containing students and ways
 * to manipulate information about students in this group
 * 
 * @author Dennis den Hollander (s4776658)
 * @author Tom Kamp (s4760921)
 */
public class Group {

    private final Student[] STUDENTS;
    
    public Group (int groupSize) {
        this.STUDENTS = new Student[groupSize];
    }
    
    public Student[] getStudents() {
        return this.STUDENTS;
    }
    
    public void addStudent(Student student, int index) {
        this.STUDENTS[index] = student;
    }
    
    public Student getStudent(int studentNumber) {
        for (Student student : this.STUDENTS) {
            if (student.getStudentNumber() == studentNumber) {
                return student;
            }
        }
        return null;
    }
    
}
