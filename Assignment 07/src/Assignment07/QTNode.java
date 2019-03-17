package Assignment07;

import java.io.IOException;
import java.io.Writer;

/**
 * Representation of a node in a QTree
 * @author Sjaak Smetsers
 * @author Dennis den Hollander s4776658
 * @author Tom Kamp s4760921
 */
public interface QTNode {
    public void fillBitmap(int x, int y, int width, Bitmap bitmap);

    public void writeNode(Writer out) throws IOException;

    public void fillArea(int x, int y, int width, Bitmap bitmap, boolean val);
}