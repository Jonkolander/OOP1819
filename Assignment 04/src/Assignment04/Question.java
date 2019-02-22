package Assignment04;

/**
 * @author Dennis den Hollander (s4776658)
 * @author Tom Kamp (s4760921)
 */
public abstract class Question {
    
    protected int score = 3;
    
    @Override
    abstract public String toString();
    
    abstract public boolean isCorrect(String answer);
    
    abstract public String correctAnswer();
    
    public void setScore(int s) {
        this.score = (s < 1 || s > 5) ? 3 : s;
    };
    
}
