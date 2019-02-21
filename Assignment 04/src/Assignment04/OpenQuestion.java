package Assignment04;

/**
 * @author Dennis den Hollander
 */
public class OpenQuestion extends Question {

    private String question;
    private String answer;
    private int points;
    
    public OpenQuestion (String question, String answer, int points) {
        this.question = question;
        this.answer = answer;
        this.points = points;
    }
    
    public OpenQuestion (String question, String answer) {
        this.question = question;
        this.answer = answer;
    }
    
    @Override
    public String toString() {
        return this.question + "\n";
    }

    @Override
    public boolean isCorrect(String answer) {
        return this.answer.equalsIgnoreCase(answer);
    }

    @Override
    public String correctAnswer() {
        return this.answer;
    }
    
    @Override
    public void setScore(int s) {
        if( s < 1 || s > 5 )
            this.points = 3;
        else
            this.points = s;
    }

}
