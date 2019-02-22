package Assignment04;

/**
 * @author Dennis den Hollander (s4776658)
 * @author Tom Kamp (s4760921)
 */
public class ThisThatQuestion extends Question {

    private String question;
    private String answer1, answer2;
    private int correctAnswer;
    private int score;
    
    ThisThatQuestion (String question, String answer1, String answer2, int correctAnswer, int score) {
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.correctAnswer = correctAnswer;
        this.score = score;
    }
    
    ThisThatQuestion (String question, String answer1, String answer2, int correctAnswer) {
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.correctAnswer = correctAnswer;
    }
    
    @Override
    public String toString() {
        return this.answer1 + " or " + this.answer2 + ": " + this.question;
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
