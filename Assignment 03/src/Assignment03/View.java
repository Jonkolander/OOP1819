package Assignment03;

import java.util.Scanner;

/**
 * @author Dennis den Hollander (s4776658) 
 * @author Tom Kamp (s4760921)
 */
public class View
{
    private final Scanner SCANNER;

    public View() {
        this.SCANNER = new Scanner(System.in);
    }
    
    public String getStringInput(String message) {
        System.out.print(message);
        return SCANNER.next();
    }
    
    public double getDoubleInput(String message) {
        System.out.print(message);
        return SCANNER.nextDouble();
    }
    
    public int getIntegerInput(String message) {
        System.out.print(message);
        return SCANNER.nextInt();
    }
    
    public void printToConsole(String message) {
        System.out.println(message);
    }
    
}
