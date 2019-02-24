package Assignment04;

/**
 * @author Dennis den Hollander (s4776658)
 * @author Tom Kamp (s4760921)
 */
public class OpenQuestion extends Question {

    private final String QUESTION;
    private final String ANSWER;
    
    public OpenQuestion (String question, String answer, int score) {
        super.setScore(score);
        this.QUESTION = question;
        this.ANSWER = answer;
    }
    
    public OpenQuestion (String question, String answer) {
        this.QUESTION = question;
        this.ANSWER = answer;
    }
    
    @Override
    public String toString() {
        return this.QUESTION;
    }

    @Override
    public boolean isCorrect(String answer) {
        return this.ANSWER.equalsIgnoreCase(answer);
    }

    @Override
    public String correctAnswer() {
        return this.ANSWER;
    }

    @Override
    public Question duplicate() {
        return new OpenQuestion(this.QUESTION, this.ANSWER, super.score);
    }

}
