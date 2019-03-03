package Assignment06;

import java.util.ArrayList;
import java.util.Collection;
import static java.lang.Math.*;

/**
 * @author Dennis den Hollander (s4776658)
 * @author Tom Kamp (s4760921)
 */
public class SlidingGame implements Configuration {
    
    public static final int N = 4, SIZE = N * N, HOLE = SIZE;
    private final int[][] BOARD;
    private int holeX, holeY;
    private Configuration currentParent;
    
    public SlidingGame(int[] start) {
        assert start.length == N*N: "Length of specified board incorrect";
        BOARD = new int[N][N];
        for(int p = 0; p < start.length; p++) {
            BOARD[p % N][p / N] = start[p];
            if (start[p] == HOLE) {
                holeX = p % N;
                holeY = p / N;
            }
        }
    }
    
    public int[][] getBoard () {
        return this.BOARD;
    }
       
    public void setParent(SlidingGame newParent) {
        this.currentParent = newParent;
    }
    
    public SlidingGame copy () {
        int[] temp = new int[SIZE];
        for (int i = 0; i < SIZE; i++)
            temp[i] = BOARD[i % N][i / N];
        SlidingGame copy = new SlidingGame(temp);
        copy.setHole(holeX, holeY);
        return copy;
    }
    
    @Override
    public String toString() {
        String printed = "";
        int row = 0;
        for (int i = 0; i < SIZE; i++) {
            if (i / N > row) {
                printed += "\n";
                row++;
            }
            int col = i % N;
            int numberLength = Integer.toString(SIZE).length();
            if (row == holeY && col == holeX) 
                printed += String.format("[%" + numberLength + "s]", " ");
            else 
                printed += String.format("[%-" + numberLength + "d]", BOARD[col][row]);
        }
        return printed;
    }
    
    @Override
    public boolean isSolution() {
        for (int i = 0; i < SIZE; i++) {
            if (BOARD[i % N][i / N] != i + 1) 
                return false;
        }
        return true;
    }
    
    public void setHole (Direction direction) {
        this.holeX = holeX + direction.GetDX();
        this.holeY = holeY + direction.GetDY();
    }
    
    private void swapDirection (Direction direction) {
        int temp = BOARD[holeX][holeY];
        BOARD[holeX][holeY] = BOARD[holeX + direction.GetDX()][holeY + direction.GetDY()];
        BOARD[holeX + direction.GetDX()][holeY + direction.GetDY()] = temp;
    }
    
    @Override
    public Collection<Configuration> successors() {
        Collection<Configuration> succs = new ArrayList<>();
        if (holeX < N - 1) 
            succs.add(move(Direction.EAST));
        if (holeX > 0) 
            succs.add(move(Direction.WEST));
        if (holeY < N - 1) 
            succs.add(move(Direction.SOUTH));
        if (holeY > 0) 
            succs.add(move(Direction.NORTH));
        return succs;
    }
    
    public Configuration move (Direction direction) {
        SlidingGame dir = this.copy();
        dir.swapDirection(direction);
        dir.setHole(direction);
        dir.setParent(this);
        return dir;
    }
    
    @Override
    public Configuration parent() {
        return currentParent;
    }

    private void setHole(int holeX, int holeY) {
        this.holeX = holeX;
        this.holeY = holeY;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o instanceof SlidingGame) {
            SlidingGame other = (SlidingGame) o;
            int[][] otherBoard = other.getBoard();
            for (int i = 0; i < SIZE; i++)
                if (BOARD[i % N][i / N] != otherBoard[i % N][i / N]) 
                    return false;
        }
        return true;
    }
    
    /**
     * Calculates the hash code for a board
     * @return the hashcode
     */
    @Override
    public int hashCode() {
        int hash = 0;
        for (int x = N-1; x >= 0; x--) 
            for (int y = N-1; y >= 0; y--) 
                hash = 31 * hash + this.BOARD[x][y];
        return hash;
    }

    /**
     * Calculates the manhattan distance of a board
     * @return the total distance to a completed board
     */
    @Override
    public int manhattanDistance() {
        int total = 0;
        for (int x = 0; x < N; x++) 
            for (int y = 0; y < N; y++) {
                int expectedValue = this.BOARD[x][y] - 1; //index conversion
                int dx = x - (expectedValue % N);
                int dy = y - (expectedValue / N);
                total += abs(dx) + abs(dy);
            }
        return total;
    }
    
    @Override
    public int compareTo(Configuration t) {
        return this.manhattanDistance() - t.manhattanDistance();
    }
}