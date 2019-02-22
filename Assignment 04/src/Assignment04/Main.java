package Assignment04;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Dennis den Hollander (s4776658)
 * @author Tom Kamp (s4760921)
 */
public class Main {

    private static List<Question> correctQuestions = new LinkedList<>();
    
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        List <Question> questions = new LinkedList<>();
        questions.add(new OpenQuestion("What is the complexity of a binary search?", "O(log N)", 2));
        questions.add(new OpenQuestion("What is the minimal amount of constructors for a Java class?", "0"));
        questions.add(new MultipleChoiceQuestion("What is the best achievable complexity of in situ sorting?",
                new String [] {
                    "O(N^2)",
                    "O(N log N)",
                    "O(N)",
                    "O(log N)"
                },1, 4));
        questions.add(new MultipleChoiceQuestion("How do you read a non-empty word using scanner s?",
                new  String [] {
                    "s.nextline ()",
                    "s.next (\"\\S+\")",
                    "s.next (\"\\a*\")",
                    "s.next (\"\\S*\")",
                    "s.next (\"\\\\s+\")",
                    "s.next (\"\\s+\")",
                    "s.nextString (\"\\s*\")",
                    "s.next (\"\\\\S+\")",
                    "s.nextString ()"
                }, 7, 1));
        
        while(correctQuestions.size() != questions.size()) {
            for (Question question : questions) {
                if (!correctQuestions.contains(question)) {
                    System.out.println(question);
                    System.out.print("> Your answer: ");
                    String answer = scanner.nextLine();
                    if(question.isCorrect(answer)) {
                        System.out.println("Correct!");
                        correctQuestions.add(question);
                    } else {
                        System.out.println("Wrong! The answer was: " + question.correctAnswer());
                    }
                }
            }
        }
        
        scanner.close();
    }
    
}
