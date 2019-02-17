package Assignment03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * This class is responsible for managing the stored objects
 * 
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
        
        // Make sure that only the not empty objects get sorted
        List<Geometric> list = Arrays.asList(shapes);
        List<Geometric> geometricObjects = list.subList(0, shapesInList);
        List<Geometric> emptyObjects = list.subList(shapesInList, list.size());
        
        if(command2.toLowerCase().equals("descending")) {
            Collections.reverse(geometricObjects);
        }
        
        ArrayList<Geometric> sortedList = new ArrayList<>();
        sortedList.addAll(geometricObjects);
        sortedList.addAll(emptyObjects);
        
        shapes = sortedList.toArray(new Geometric[sortedList.size()]);
    }  
    
    @Override
    public String toString(){
        String str = "";
        for (Geometric shape : shapes){
            str += shape != null ? "\n " + shape : "\n <empty>";
        }
        return str;
    }
}
