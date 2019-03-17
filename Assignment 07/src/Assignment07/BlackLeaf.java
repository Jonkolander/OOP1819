package Assignment07;

import java.io.IOException;
import java.io.Writer;

/**
 * @author Dennis den Hollander s4776658
 * @author Tom Kamp s4760921
 */
public class BlackLeaf implements QTNode {
    
    private final boolean BOOLEAN_VALUE = false;
    private final String STRING_VALUE = "0";
    
    @Override
    public void fillBitmap(int x, int y, int width, Bitmap bitmap) {
        int old_x = x, old_y = y;
        for (; x < old_x + width; x++)
            for (y = old_y; y < old_y + width; y++)
                bitmap.setBit(x, y, BOOLEAN_VALUE);
    }
    
    @Override
    public void writeNode(Writer out) throws IOException {
        out.write("0" + STRING_VALUE);
    }
    
    @Override
    public void fillArea(int x, int y, int width, Bitmap bitmap, boolean val){
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                bitmap.setBit(x+i, y+j, val);
            }
        }
    }  
}
