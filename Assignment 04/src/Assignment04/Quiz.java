package Assignment04;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Dennis den Hollander (s4776658)
 * @author Tom Kamp (s4760921)
 */
public class Quiz {

    private final Scanner SCANNER = new Scanner(System.in);
    private final List<Question> QUESTIONS;
    private List<Question> wrongQuestions = new LinkedList<>();
    
    public Quiz (List<Question> questions) {
        this.QUESTIONS = questions;
    }
    
    public void start () {
        for (Question question : this.QUESTIONS) {
            System.out.println("[" + Integer.toString(this.QUESTIONS.indexOf(question) + 1) + "] " + question);
            System.out.print("> Your answer: ");
            String answer = SCANNER.nextLine();
            if(question.isCorrect(answer)) {
                System.out.println("Correct!");
            } else {
                System.out.println("Wrong! The answer was: " + question.correctAnswer());
                wrongQuestions.add(question);
            }
        }
            
        for (Question repeatedQuestion : this.wrongQuestions) {
            System.out.println(repeatedQuestion);
            System.out.print("> Your answer: ");
            String answer = SCANNER.nextLine();
            if(repeatedQuestion.isCorrect(answer)) {
                System.out.println("Correct!");
            } else {
                System.out.println("Wrong! The answer was: " + repeatedQuestion.correctAnswer());
            }
        }
        
        printScoreBoard();
    }
    
    private void printScoreBoard() {
        System.out.printf("%-15s %s\n", "Question", "Score");
        System.out.println("----------------------------");
        for (Question question : this.QUESTIONS) {
            System.out.printf("Question %d %-4s %d\n", this.QUESTIONS.indexOf(question) + 1, "", question.score);
        }
    }
    
}
