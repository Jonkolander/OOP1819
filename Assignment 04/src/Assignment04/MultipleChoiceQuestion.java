package Assignment04;

/**
 * @author Dennis den Hollander
 */
public class MultipleChoiceQuestion extends Question {

    public MultipleChoiceQuestion(String question, String [] answers, int correctAnswer, int score) {
        
    }
    
    public MultipleChoiceQuestion(String question, String [] answers, int correctAnswer) {
        
    }
    
    @Override
    public String toString() {
        return "";
    }

    @Override
    public boolean isCorrect(String answer) {
        return true;
    }

    @Override
    public String correctAnswer() {
        return "";
    }

    @Override
    public void setScore(int s) {

    }

}
