package Assignment04;

import java.util.List;
import java.util.Scanner;

/**
 * @author Dennis den Hollander (s4776658)
 * @author Tom Kamp (s4760921)
 */
public class View {
    
    private final Scanner SCANNER = new Scanner(System.in);
    
    public String getUserInput() {
        System.out.print("> Your answer: ");
        return SCANNER.nextLine();
    }
    
    public void showQuestion(Question question) {
        System.out.println(question);
    }
    
    public void correct () {
        System.out.println("Correct!\n");
    }
    
    public void wrongAnswer(String correctAnswer) {
        System.out.println("Wrong! The answer was: '" + correctAnswer + "'\n");
    }
    
    public void printScoreBoard(List<Question> questions, List<Question> wrong_questions) {
        System.out.println("[First round]\n");
        System.out.printf("%-15s | %s\n", "Question", "Score");
        System.out.println("----------------+-------");
        for (Question question : questions) {
            if (question.score > 0) {
                System.out.printf("Question %d %-4s | %d\n", questions.indexOf(question) + 1, "", question.score);
            }
        }
        
        if (wrong_questions.size() > 0) {
            System.out.println("\n[Second round]\n");
            System.out.printf("%-15s | %s\n", "Question", "Score");
            System.out.println("----------------+-------");
            for (Question question : wrong_questions) {
                System.out.printf("Question %d %-4s | %d\n", questions.indexOf(question) + 1, "", question.score);
            }
        }
    }

}
