package Assignment07;

import java.io.StringReader;

/**
 * @author Dennis den Hollander s4776658
 * @author Tom Kamp s4760921
 */
public class Main {

    public static void main(String[] args) {
        String text = "10011010001010010001010101100011000101000000";
        StringReader input = new StringReader(text);
        
        QTree qt = new QTree(input);
        Bitmap bitmap = new Bitmap(8, 8);
        qt.fillBitmap(bitmap);
        System.out.println("The Bitmap representation:\n\n" + bitmap);
    }
}
