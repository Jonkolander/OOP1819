package Assignment07;

import java.io.IOException;
import java.io.Writer;

/**
 * @author Dennis den Hollander s4776658
 * @author Tom Kamp s4760921
 */
public class GreyNode implements QTNode {

    /** The four children, starting at North West, counting clockwise */
    private final QTNode children[];

    public GreyNode() {
        children = new QTNode[4];
    }

    @Override
    public void fillBitmap(int x, int y, int width, Bitmap bitmap) {
        children[0].fillBitmap(x, y, width / 2, bitmap);
        children[1].fillBitmap(x + width / 2, y, width / 2, bitmap);
        children[2].fillBitmap(x + width / 2, y + width / 2, width / 2, bitmap);
        children[3].fillBitmap(x, y + width / 2, width / 2, bitmap);
    }

    @Override
    public void writeNode(Writer out) throws IOException {
        out.write("1");
        for (QTNode child : children)
            child.writeNode(out);
    }

    /**
     * Set one of the children nodes
     * @param index the position of the child: 0 = NW; 1 = NE; 2 = SE; 3 = SW
     * @param child the child node
     */
    public void setChild(int index, QTNode child) {
        assert (index >= 0 && index <= 3);

        children[index] = child;
    }

    /**
     * Compress the current node
     * @return a BlackLeaf if all the children are black, a WhiteLeaf if all the 
     * children are white, or itself otherwise.
     */
    QTNode compress() {
        if (children[0].getClass() == children[1].getClass() 
                && children[1].getClass() == children[2].getClass() 
                && children[2].getClass() == children[3].getClass())
            return children[0];
        return this;
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