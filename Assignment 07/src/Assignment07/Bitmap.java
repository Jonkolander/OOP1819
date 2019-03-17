package Assignment07;

/**
 * Bitmap: A class for representing bitmap;
 * @author Sjaak Smetsers
 * @author Dennis den Hollander s4776658
 * @author Tom Kamp s4760921
 * @version 15-03-2016
 * Each bit is stored into an two dimensional array
 */
public class Bitmap {
    
    private final boolean[][] raster;
    private final int bmWidth, bmHeight;
    
    /**
     * Creates an empty bitmap of size width * height
     * @param width
     * @param height 
     */
    public Bitmap(int width, int height) {
        this.raster   = new boolean[width][height];
        this.bmWidth  = width;
        this.bmHeight = height;
    }

    /**
     * Gets a bit at the specified position
     * @param x: x coordinate
     * @param y: y coordinate
     * @return the bit value at coordinates x and y of the raster
     */
    public boolean getBit(int x, int y) {
        return raster[x][y];
    }
    
    /**
     * Sets a bit at the specified position
     * @param x: x coordinate
     * @param y: y coordinate
     * @param val: the bit value 
     */
    public void setBit(int x, int y, boolean val){
        raster[x][y] = val;
    }
    
    /**
     * Converts a bitmap into a string
     * 1 is represented by '*'; 0 by 'O'
     * @return the string representation
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < bmHeight; y++) {
            for (int x = 0; x < bmWidth; x++)
               sb.append(raster[x][y] ?  '*' : 'O' );
            sb.append( '\n' );
        }
        return sb.toString();
    }
    
    /**
     * @return the width of the bitmap
     */
    public int getWidth() {
        return bmWidth;
    }

    /**
     * @return the height of the bitmap
     */
    public int getHeight() {
        return bmHeight;
    }
    
    /**
     * Fills a square area of a bitmap with value val
     * @param x: x coordinate of upper-left corner
     * @param y: y coordinate of upper-left corner
     * @param size: size of the square
     * @param val: the bit value 
      */
    public void fillArea( int x, int y, int size, boolean val ){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                setBit(x+i, y+j, val);
            }
        }
    }
    

}
