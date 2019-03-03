package Assignment06;

/**
 * @author Dennis den Hollander (s4776658)
 * @author Tom Kamp (s4760921)
 */
public class Main {
    
    public static void main (String[] args) {
        int[] board = {2,10,3,4, 1,6,16,7, 5,11,12,8, 13,9,14,15};
        SlidingGame s1 = new SlidingGame(board);
        
        System.out.println("Starting board: ");
        System.out.println(s1 + "\n");
        
        Solver solver = new Solver(s1);
        System.out.println(solver.solve());
    }   
}
