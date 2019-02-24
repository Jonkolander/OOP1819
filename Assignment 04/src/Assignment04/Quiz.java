package Assignment04;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Dennis den Hollander (s4776658)
 * @author Tom Kamp (s4760921)
 */
public class Quiz {

    private final View VIEW = new View();
    private final List<Question> QUESTIONS;
    private final List<Question> WRONG_QUESTIONS = new LinkedList<>();
    
    public Quiz (List<Question> questions) {
        this.QUESTIONS = questions;
    }
    
    public void start () {
        for (Question question : this.QUESTIONS) {
            VIEW.showQuestion(question);
            if(question.isCorrect(VIEW.getUserInput())) {
                VIEW.correct();
            } else {
                VIEW.wrongAnswer(question.correctAnswer());
                question.score = 0;
                this.WRONG_QUESTIONS.add(question);
            }
        }
            
        for (Question repeatedQuestion : this.WRONG_QUESTIONS) {
            VIEW.showQuestion(repeatedQuestion);
            if(repeatedQuestion.isCorrect(VIEW.getUserInput())) {
                VIEW.correct();
            } else {
                VIEW.wrongAnswer(repeatedQuestion.correctAnswer());
                repeatedQuestion.score = 0;
            }
        }
        
        VIEW.printScoreBoard(this.QUESTIONS, this.WRONG_QUESTIONS);
    }
    
}
