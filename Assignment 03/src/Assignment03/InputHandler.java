package Assignment03;

/**
 * @author Dennis den Hollander (s4776658)
 * @author Tom Kamp (s4760921)
 */
public class InputHandler {
    
    private static final int AMOUNT_OF_OBJECTS = 3;
    private static View view = new View();
    private static ObjectManager shapes = new ObjectManager(AMOUNT_OF_OBJECTS);
    
    public static void Interface(){
        String input = view.getStringInput("Enter command: ").toLowerCase();
        switch (input) {
            case "quit":
                System.out.println("System terminated.");
                return;
            case "show":
                view.printToConsole("List of currently stored shapes: ");
                view.printToConsole(shapes.toString());
                break;
            case "circle":
                shapes.addShape(createCircle()); //add circle to the list
                break;
            case "rectangle":
                shapes.addShape(createRectangle()); //add rectangle to the list
                break;
            case "move":
                if (shapes.isEmpty()) {
                    view.printToConsole("There are no shapes defined yet");
                    break;
                }
                int i1 = view.getIntegerInput("Please enter the index of the shape you want to move: ");
                if (i1 < 0 || i1 > AMOUNT_OF_OBJECTS) {
                    System.out.println("Invalid index.");
                    break;
                }
                double dx = view.getDoubleInput("Desired change on the x-axis: ");
                double dy = view.getDoubleInput("Desired change on the y-axis: ");
                shapes.getShape(i1).move(dx,dy); //move the desired object with dx and dy
                break;
            case "remove":
                if (shapes.isEmpty()) {
                    view.printToConsole("There are no shapes defined yet.");
                    break;
                }
                int i2 = view.getIntegerInput("Please enter the index of the shape you want to remove: ");
                if (i2 < 0 || i2 > AMOUNT_OF_OBJECTS) {
                    System.out.println("Invalid index.");
                    break;
                }                
                shapes.removeShape(i2);
                break;
            case "sort":
                String command = view.getStringInput(
                        "Type 'x' to sort from most left to most right.\n"
                                + "Type 'y' to sort from most down to most up.\n"
                                + "Enter anything else to sort on area.\n"
                                + "Your choice: ");
                String command2 = view.getStringInput("\n"
                        + "Type 'ascending' to sort the array from low to high.\n"
                        + "Type 'descending' to sort from high to low.\n"
                        + "Your choice: ");
                shapes.sort(command, command2);
                break;
            default:
                System.out.println("I could not understand your command. Please try again.");
                break;
        }
        view.printToConsole(""); //empty line for layout
        Interface();
    }
    
    /**
     * 
     * @return new Rectangle
     */
    public static Rectangle createRectangle() {
        view.printToConsole("Please enter decimal values with commas!");
        double x = view.getDoubleInput("Enter the x-coordinate: ");
        double y = view.getDoubleInput("Enter the y-coordinate: ");
        double width = view.getDoubleInput("Enter the width: ");
        double height = view.getDoubleInput("Enter the height: ");
        return new Rectangle(x,y,width,height);
    }
    
    public static Circle createCircle() {
        view.printToConsole("Please enter decimal values with commas!");
        double x = view.getDoubleInput("Enter the x-coordinate: ");
        double y = view.getDoubleInput("Enter the y-coordinate: ");
        double radius = view.getDoubleInput("Enter the circle-radius: ");
        return new Circle(x,y,radius);
    }
    

}
