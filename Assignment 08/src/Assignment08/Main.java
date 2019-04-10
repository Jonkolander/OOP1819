package Assignment08;

/**
 * @author Sjaak Smetsers
 *
 * ==============================================
 *
 * Modified by:
 * @author Dennis den Hollander | (s4776658)
 * @author Tom Kamp | (s4760921)
 */
public class Main {

  public static void main(String[] args) {
    int x;
    
    Polynomial p1 = new Polynomial("3.0 1 2 3");
    Polynomial p2 = new Polynomial("4 0 5 3");
    Polynomial p3 = new Polynomial("4 0 -5 3");
    Polynomial p4 = new Polynomial("6 1");

    System.out.println(p1);
    System.out.println(p2);
    System.out.println(p3);
    System.out.println(p4);
    
    System.out.println("\nEvaluations:");
    
    x = 2;
    System.out.println(p1 + " where x = " + x + " equals: " + p1.evaluate(x));
    
    x = 8;
    System.out.println(p3 + " where x = " + x + " equals: " + p3.evaluate(x));
  }

}
