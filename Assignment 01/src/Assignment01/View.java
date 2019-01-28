package Assignment01;

import java.util.Scanner;

/**
 * This class regulates the I/O of the program
 * 
 * @author Dennis den Hollander (s4776658)
 * @author Tom Kamp (s4760921)
 */
public class View {

    public Scanner scanner = new Scanner(System.in);
    
    /**
     * Checks whether the user input is numeric
     * @param string
     * @return true if numeric, otherwise false 
     */
    public boolean isNumeric(String string) {
        try {
            Double.parseDouble(string);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
    
    public int enterGroupSize() {
        System.out.print("Please enter the group size: ");
        int groupSize = scanner.nextInt();
        scanner = new Scanner(System.in);
        return groupSize;
    }
    
    public String enterStudent() {
        System.out.print("Please enter a student: ");
        return scanner.nextLine();
    }
    
    public String adjustStudent() {
        System.out.println("\nStudent number and new given / family name?");
        return scanner.nextLine();
    }
    
    public void invalidStudent() {
        System.out.println("The student could unfortunately not be found, please try again.");
    }
    
    public void update(Group students) {
        System.out.println("\nThe group now contains:");
        for (Student student : students.getStudents()) {
            System.out.println(student);
        }
    }
    
    public void terminate() {
        System.out.println("Bye!");
    }
    
}
