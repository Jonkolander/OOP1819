package Assignment04;

/**
 * @author Dennis den Hollander (s4776658)
 * @author Tom Kamp (s4760921)
 */
public class ThisThatQuestion extends Question {

    private final String QUESTION;
    private final String ANSWER1, ANSWER2;
    private final int CORRECT_ANSWER;
    
    public ThisThatQuestion (String question, String answer1, String answer2, int correctAnswer, int score) {
        super.setScore(score);
        this.QUESTION = question;
        this.ANSWER1 = answer1;
        this.ANSWER2 = answer2;
        this.CORRECT_ANSWER = correctAnswer;
    }
    
    public ThisThatQuestion (String question, String answer1, String answer2, int correctAnswer) {
        this.QUESTION = question;
        this.ANSWER1 = answer1;
        this.ANSWER2 = answer2;
        this.CORRECT_ANSWER = correctAnswer;
    }
    
    @Override
    public String toString() {
        return this.ANSWER1 + " or " + this.ANSWER2 + ": " + this.QUESTION;
    }

    @Override
    public boolean isCorrect(String answer) {
        String correctAnswer = this.CORRECT_ANSWER == 1 ? this.ANSWER1 : this.ANSWER2;
        return correctAnswer.equalsIgnoreCase(answer);
    }

    @Override
    public String correctAnswer() {
        return this.CORRECT_ANSWER == 1 ? this.ANSWER1 : this.ANSWER2;
    }
    
}
