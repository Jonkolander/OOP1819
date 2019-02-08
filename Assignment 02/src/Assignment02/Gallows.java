package Assignment02;

import java.util.ArrayList;

/**
 * The gallow, containing of a word to be guessed, a list 
 * of already guessed letters and amount of lives.
 * 
 * @author Dennis den Hollander (s4776658)
 * @author Tom Kamp (s4760921)
 */
public class Gallows {

    private final View VIEW = new View();
    private final String GUESS_WORD;
    private final ArrayList<Character> GUESSED_LETTERS = new ArrayList<>();
    private int lives;

    public Gallows() {
        VIEW.announceRandomWord();
        WordReader reader = new WordReader("words.txt");
        this.GUESS_WORD = reader.getWord();
    }
        
    public Gallows(String guessWord) {
        this.GUESS_WORD = guessWord;
    }
    
    public String getWord() {
        return this.GUESS_WORD;
    }

    public void setLives(int newLives) {
        this.lives = newLives;
    }

    public int getLives() {
        return this.lives;
    }
    
    public ArrayList<Character> getGuessedLetters() {
        return this.GUESSED_LETTERS;
    }
    
    public void addGuessedLetter(char c) {
        this.GUESSED_LETTERS.add(c);
    }
}
