package Assignment03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Dennis den Hollander (s4776658)
 * @author Tom Kamp (s4760921)
 */
public class ObjectManager {
    
    private Geometric[] shapes;
    private int shapesInList = 0;
    
    public ObjectManager(int size) {
        this.shapes = new Geometric[size];
    }
    
    public void addShape(Geometric shape) {
        shapes[shapesInList] = shape;
        shapesInList++;
    }
    
    public Geometric getShape(int index) {
        return shapes[index];
    }
    
    public void removeShape(int index) {
        for (int i = index; i < shapes.length-1; i++) {
            shapes[i] = shapes[i+1];
        }
        shapes[shapes.length-1] = null;
        shapesInList--;
    }
    
    public boolean isEmpty() {
        return shapesInList == 0;
    }
    
    /**
     * Sorts based on the command which comparator to use {@code command}
     * And also sorts on ascending/descending {@code command2}
     * This function exludes null's in the sorting process!
     * @param command
     * @param command2 
     */
    public void sort(String command, String command2) {
        switch (command.toLowerCase()) {
            case "x":
                Arrays.sort(shapes, 0, shapesInList, (Geometric a, Geometric b) -> Double.compare(a.bottom(), b.bottom()));
                break;
            case "y":
                Arrays.sort(shapes, 0, shapesInList, (Geometric a, Geometric b) -> Double.compare(a.left(), b.left()));
                break;
            default:
                Arrays.sort(shapes, 0, shapesInList);
        }
        
        List<Geometric> list = Arrays.asList(shapes);
        List<Geometric> nonNull = list.subList(0, shapesInList);
        List<Geometric> nullElements = list.subList(shapesInList, list.size());
        
        if(command2.toLowerCase().equals("descending")) 
            Collections.reverse(nonNull);
        
        ArrayList<Geometric> list3 = new ArrayList<>();
        list3.addAll(nonNull);
        list3.addAll(nullElements);
        
        shapes = list3.toArray(new Geometric[list3.size()]);
    }
    
    public boolean containsNull() {
        int count = 0;
        for (Geometric o : shapes) {
            if (o != null)
                count++;
        }
        return count != shapes.length;
    }    
    
    @Override
    public String toString(){
        String str = "";
        for (Geometric shape : shapes){
            str += shape + "\n";
        }
        return str;
    }
}
