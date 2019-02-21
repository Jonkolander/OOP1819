package Assignment04;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Dennis den Hollander (s4776658)
 * @author Tom Kamp (s4760921)
 */
public class Main {

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        List <Question> questions = new LinkedList<>();
        questions.add(new OpenQuestion("What is the complexity of a binary search?", "O(log N)", 2));
        questions.add(new OpenQuestion("What is the minimal amount of constructors for a Java class?", "0"));
        
        for (int i = 0; i < questions.size(); i++) {
            System.out.print(questions.get(i));
            System.out.print("> You answer: ");
            String answer = scanner.nextLine();
            System.out.println(questions.get(i).isCorrect(answer));
        }
        
        scanner.close();
    }
    
}
