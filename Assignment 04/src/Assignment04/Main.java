package Assignment04;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Dennis den Hollander (s4776658)
 * @author Tom Kamp (s4760921)
 */
public class Main {
    
    public static void main (String[] args) {
        List <Question> questions = new LinkedList<>();
        // questions.add(new ThisThatQuestion("Do you like memes?", "Yes", "No", 1, 4));
//        questions.add(new OpenQuestion("What is the complexity of a binary search?", "O(log N)", 2));
//        questions.add(new OpenQuestion("What is the minimal amount of constructors for a Java class?", "0"));
        questions.add(new MultipleChoiceQuestion("What is the best achievable complexity of in situ sorting?",
                new String [] {
                    "O(N^2)",
                    "O(N log N)",
                    "O(N)",
                    "O(log N)"
                }, 1, 4));
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
        
        Quiz quiz = new Quiz(questions);
        quiz.start();
    }
    
}
