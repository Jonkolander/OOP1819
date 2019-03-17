package Assignment07;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Dennis den Hollander s4776658
 * @author Tom Kamp s4760921
 */
public class QTree {
    QTNode root;
    
    public QTree(Reader input) {
        root = readQTree(input);
    }
 
    public QTree(Bitmap bitmap) {
        root = bitmap2QTree(0, 0,  bitmap.getWidth(), bitmap);
    }

    public void fillBitmap (Bitmap bitmap) {
        root.fillBitmap(0, 0, bitmap.getWidth(), bitmap);
    }

    public void writeQTree(Writer sb) throws IOException {
        root.writeNode(sb);
    }
    
    public static QTNode readQTree(Reader input) {
        try {
            int read = input.read();
            if (read == '1') {
                GreyNode node = new GreyNode();
                for (int i = 0; i < 4; i++)
                    node.setChild(i, readQTree(input));
                return node;
            } else {
                read = input.read();
                return read == '1' ? new WhiteLeaf() : new BlackLeaf();
            }
        } catch (IOException ex) {
            Logger.getLogger(QTree.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static QTNode bitmap2QTree(int x, int y, int width, Bitmap bitmap) {
        if (width == 1) {
            if (bitmap.getBit(x,y)) {
                return new WhiteLeaf();
            } else {
                return new BlackLeaf();
            }
        } else {
            GreyNode node = new GreyNode();
            node.setChild(0, bitmap2QTree(x, y, width / 2, bitmap));
            node.setChild(1, bitmap2QTree(x + width / 2, y, width / 2, bitmap));
            node.setChild(2, bitmap2QTree(x + width / 2, y + width / 2, width / 2, bitmap));
            node.setChild(3, bitmap2QTree(x, y + width / 2, width / 2, bitmap));
            return node.compress();
        }
    }

}