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
        questions.add(new OpenQuestion("What is the capital city of the Netherlands?", "Amsterdam"));
        questions.add(new MultipleChoiceQuestion("What letter comes after the X in the alphabet?", new String[] { "Y", "H", "Z" }, 0, 4));
        questions.add(new ThisThatQuestion("Programming is fun", "Yes", "No", 1, 9));
        
        Quiz quiz = new Quiz(questions);
        quiz.start();
    }
    
}
