package Assignment03;

import java.util.Scanner;

/**
 * All the input and output of the program.
 * 
 * @author Dennis den Hollander (s4776658) 
 * @author Tom Kamp (s4760921)
 */
public class View
{
    private final Scanner SCANNER;

    public View() {
        this.SCANNER = new Scanner(System.in);
    }
    
    public void welcomeMessage() {
        System.out.println("Welcome to the geometric object machine!");
        instructions();
    }
    
    public void instructions() {
        System.out.println("[x] Type 'circle' to add a circle.");
        System.out.println("[x] Type 'rectangle' to add a rectangle.");
        System.out.println("[x] Type 'move' to move an object");
        System.out.println("[x] Type 'remove' to remove an object");
        System.out.println("[x] Type 'show' to show the list of all objects");
        System.out.println("[x] Type 'sort' to sort the list based on your preferences");
        System.out.println("[x] Type 'quit' to terminate the program");
    }
    
    public String sortLeftOrBottom() {
        System.out.print("Type 'x' to sort from most left to most right.\n"
                    + "Type 'y' to sort from most down to most up.\n"
                    + "Enter anything else to sort on area.\n"
                    + "Your choice: ");
        return SCANNER.next();
    }
    
    public String sortAscendingOrDescending() {
        System.out.print("\n"
                + "Type 'ascending' to sort the array from low to high.\n"
                + "Type 'descending' to sort from high to low.\n"
                + "Your choice: ");
        return SCANNER.next();
    }
    
    public String retrieveCommandPrompt() {
        System.out.print("Enter command: ");
        return SCANNER.next().toLowerCase();
    }
    
    public double getDoubleInput(String message) {
        System.out.print(message);
        return SCANNER.nextDouble();
    }
    
    public int getIntegerInput(String message) {
        System.out.print(message);
        return SCANNER.nextInt();
    }
    
    public void terminate() {
        System.out.println("Program terminated.");
    }
    
    public void showStoredShapes (ObjectManager shapes) {
        System.out.println("\nList of currently stored shapes:" + shapes);
    }
    
    public void invalidInput() {
        System.out.println("I could not understand your command. Please try again.");
    }
    
    public void invalidIndex() {
        System.out.println("Invalid index. Please try again.");
    }
    
    public void emptyList() {
        System.out.println("No geometric shapes have been defined yet.");
    }
    
    public void newLine() {
        System.out.print("\n");
    }
}
