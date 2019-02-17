package Assignment03;

/**
 * This class handles the user's input and performs
 * the corresponding actions.
 * 
 * @author Dennis den Hollander (s4776658)
 * @author Tom Kamp (s4760921)
 */
public class InputHandler {
    
    private final int AMOUNT_OF_OBJECTS = 5;
    private final View VIEW = new View();
    private final ObjectManager SHAPES = new ObjectManager(AMOUNT_OF_OBJECTS);
    
    public void userPrompt() {
        VIEW.welcomeMessage();
        VIEW.newLine();
        while (true) {
            String input = VIEW.retrieveCommandPrompt();
            switch (input) {
                case "quit":
                    VIEW.terminate();
                    return;
                case "show":
                    VIEW.showStoredShapes(this.SHAPES);
                    break;
                case "circle":
                    addCircle();
                    VIEW.showStoredShapes(this.SHAPES);
                    break;
                case "rectangle":
                    addRectangle();
                    VIEW.showStoredShapes(this.SHAPES);
                    break;
                case "move":
                    moveObject();
                    VIEW.showStoredShapes(this.SHAPES);
                    break;
                case "remove":
                    removeObject();
                    VIEW.showStoredShapes(this.SHAPES);
                    break;
                case "sort":
                    sortObjects();
                    VIEW.showStoredShapes(this.SHAPES);
                    break;
                default:
                    VIEW.invalidInput();
                    break;
                }
            VIEW.newLine();
        }
    }
    
    public void addRectangle() {
        double x = VIEW.getDoubleInput("> Enter the x-coordinate: ");
        double y = VIEW.getDoubleInput("> Enter the y-coordinate: ");
        double width = VIEW.getDoubleInput("> Enter the width: ");
        double height = VIEW.getDoubleInput("> Enter the height: ");
        Rectangle newRectangle = new Rectangle(x, y, width, height);
        this.SHAPES.addShape(newRectangle);
    }
    
    public void addCircle() {
        double x = VIEW.getDoubleInput("> Enter the x-coordinate: ");
        double y = VIEW.getDoubleInput("> Enter the y-coordinate: ");
        double radius = VIEW.getDoubleInput("> Enter the circle-radius: ");
        Circle newCircle = new Circle(x, y, radius);
        this.SHAPES.addShape(newCircle);
    }
    
    public void moveObject() {
        if (SHAPES.isEmpty()) {
            VIEW.emptyList();
            return;
        }
        int shapeIndex = VIEW.getIntegerInput("Please enter the index of the shape you want to move: ");
        if (shapeIndex < 0 || shapeIndex > AMOUNT_OF_OBJECTS) {
            VIEW.invalidIndex();
            return;
        }
        double dx = VIEW.getDoubleInput("Desired change on the x-axis: ");
        double dy = VIEW.getDoubleInput("Desired change on the y-axis: ");
        this.SHAPES.getShape(shapeIndex).move(dx, dy);
    }
    
    public void removeObject() {
        if (SHAPES.isEmpty()) {
            VIEW.emptyList();
            return;
        }
        int shapeIndex = VIEW.getIntegerInput("Please enter the index of the shape you want to remove: ");
        if (shapeIndex < 0 || shapeIndex > AMOUNT_OF_OBJECTS) {
            VIEW.invalidIndex();
            return;
        }                
        SHAPES.removeShape(shapeIndex);
    }

    public void sortObjects() {
        String command = VIEW.sortLeftOrBottom();
        String command2 = VIEW.sortAscendingOrDescending();
        SHAPES.sort(command, command2);
    }
    
}
