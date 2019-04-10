package Assignment08;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * The test suite for the polynomial class
 *
 * @author Dennis den Hollander | (s4776658)
 * @author Tom Kamp | (s4760921)
 */
public class PolynomialTest {

  private Polynomial instance;

  public PolynomialTest() { }

  @BeforeClass
  public static void setUpClass() { }

  @AfterClass
  public static void tearDownClass() { }

  @Before
  public void setUp() { }

  @After
  public void tearDown() { }

  /**
   * @class Polynomial
   * @method toString()
   */
  @Test
  public void toStringTest() {
    System.out.println("[LOGS] Testing toString() ...");

    int coefficient;
    int exponent;

    // CASE: If exponent is zero, then do not include the 'x'
    exponent = 0;
    for (coefficient = 0; coefficient < 10; coefficient++) {
      instance = new Polynomial(coefficient + " " + exponent);
      assertEquals(instance.toString(), coefficient + ",000000");
    }
    
    // CASE: If the exponent is equal to 1, include the 'x'
    exponent = 1;
    for (coefficient = 0; coefficient < 10; coefficient++) {
      instance = new Polynomial(coefficient + " " + exponent);
      assertEquals(instance.toString(), coefficient + ",000000x");
    }
    
    // CASE: If the exponent is higher than 1, do include the 'x' with '^'
    for (coefficient = 0; coefficient < 10; coefficient++) {
      for (exponent = 2; exponent < 10; exponent++) {
        instance = new Polynomial(coefficient + " " + exponent);
        assertEquals(instance.toString(), coefficient + ",000000x^" + exponent);
      }
    }
    
    // CASE: If a second term is negative, do not show a superfluous '+' symbol
    instance = new Polynomial("6 7 -3 1");
    assertThat(instance.toString(), not(containsString("+")));
  }

  /**
   * @class Polynomial
   * @method plus()
   */
  @Test
  public void additionTest() {
    System.out.println("[LOGS] Testing plus() ...");
    
    int coefficient;
    int exponent;
    
    /**
     * CASE: The same terms negative + positive = 0 (compensating)
     */
    for (coefficient = 0; coefficient < 10; coefficient++) {
      for (exponent = 0; exponent < 10; exponent++) {
        instance = new Polynomial(coefficient + " " + exponent);
        Polynomial negativeInstance = new Polynomial(-coefficient + " " + exponent);
        instance.plus(negativeInstance);
        assertEquals(instance.evaluate(1), 0, 0);
      }
    }
    
    /**
     * CASE: 
     *   => x + y       | exponent 0
     *   => xc + yc     | exponent 1
     *   => xc^e + yc^e | exponent >= 2 (otherwise)
     */
    for (exponent = 0; exponent < 10; exponent++) {
      for (coefficient = 0; coefficient < 10; coefficient++) {
        for (int otherCoefficient = 0; otherCoefficient < 10; otherCoefficient++) {
          if (coefficient - otherCoefficient == 0) continue;
          instance = new Polynomial(coefficient + " " + exponent);
          Polynomial otherInstance = new Polynomial(otherCoefficient + " " + exponent);
          instance.plus(otherInstance);
          switch(exponent) {
            case 0: 
              assertEquals(instance.toString(), coefficient + otherCoefficient + ",000000"); 
              break;
            case 1: 
              assertEquals(instance.toString(), coefficient + otherCoefficient + ",000000x"); 
              break;
            default: 
              assertEquals(instance.toString(), coefficient + otherCoefficient + ",000000x^" + exponent); 
              break;
          }
          
        }
      }
    }
    
    /**
     * CASE: complex addition
     */
    Polynomial A = new Polynomial("3 9 -1 5 8 4");  // f(x) = 3x^9 -  x^5 + 8x^4
    Polynomial B = new Polynomial("4 9 4 4 1 -3");  // g(x) = 4x^9 + 4x^4 + x^-3
    
    A.plus(B);                                      // f(x) + g(x) = 7x^9 - x^5 + 12x^4 + x^-3 
    assertEquals(A.toString(), "7,000000x^9-1,000000x^5+12,000000x^4+1,000000x^-3");
    
    /**
     * CASE: test commutativity of the plus operator
     */
    Polynomial polynomialA = new Polynomial("3 4");
    Polynomial polynomialB = new Polynomial("5 6");
    Polynomial polynomialC = new Polynomial("5 6");
    Polynomial polynomialD = new Polynomial("3 4");
    
    polynomialA.plus(polynomialB);
    polynomialC.plus(polynomialD);
    
    // Fill in with random number 5 and expect same outputs
    assertEquals(polynomialA.evaluate(5), polynomialC.evaluate(5), 0);
    
    /**
     * CASE: test associativity of the plus operator
     */
    polynomialA = new Polynomial("3 4");
    polynomialB = new Polynomial("5 6");
    polynomialC = new Polynomial("7 8");
    
    // ( a + b ) + c
    polynomialA.plus(polynomialB);
    polynomialA.plus(polynomialC);
    double evaluationA = polynomialA.evaluate(5);
    
    polynomialA = new Polynomial("3 4");
    polynomialB = new Polynomial("5 6");
    polynomialC = new Polynomial("7 8");
    
    // a + ( b + c )
    polynomialB.plus(polynomialC);
    polynomialA.plus(polynomialB);
    double evaluationB = polynomialA.evaluate(5);
    
    assertEquals(evaluationA, evaluationB, 0);
  }

  /**
   * @class Polynomial
   * @method minus()
   */
  @Test
  public void subtractionTest() {
    System.out.println("[LOGS] Testing minus() ...");
    
    int coefficient;
    int exponent;
    
    /**
     * CASE: where instance minus the same instance equals 0
     */
    for (coefficient = 0; coefficient < 10; coefficient++) {
      for (exponent = 0; exponent < 10; exponent++) {
        instance = new Polynomial(coefficient + " " + exponent);
        instance.minus(instance);
        assertEquals(instance.evaluate(1), 0, 0);
      }
    }
    
    /**
     * CASE: 
     *   => x - y       | exponent 0
     *   => xc - yc     | exponent 1
     *   => xc^e - yc^e | exponent >= 2 (otherwise)
     */
    for (exponent = 0; exponent < 10; exponent++) {
      for (coefficient = 0; coefficient < 10; coefficient++) {
        for (int otherCoefficient = 0; otherCoefficient < 10; otherCoefficient++) {
          if (coefficient - otherCoefficient == 0) continue;
          instance = new Polynomial(coefficient + " " + exponent);
          Polynomial otherInstance = new Polynomial(otherCoefficient + " " + exponent);
          instance.minus(otherInstance);
          switch(exponent) {
            case 0: 
              assertEquals(instance.toString(), coefficient - otherCoefficient + ",000000"); 
              break;
            case 1: 
              assertEquals(instance.toString(), coefficient - otherCoefficient + ",000000x"); 
              break;
            default: 
              assertEquals(instance.toString(), coefficient - otherCoefficient + ",000000x^" + exponent); 
              break;
          }
          
        }
      }
    }
    
    /**
     * CASE: complex substraction
     */
    Polynomial A = new Polynomial("3 9 -1 5 8 4"); // f(x) = 3x^9 -  x^5 + 8x^4
    Polynomial B = new Polynomial("4 9 4 4 1 -3"); // g(x) = 4x^9 + 4x^4 + x^-3
    
    A.minus(B);                                    // f(x) - g(x) = -x^9 - x^5 + 4x^4 - x^-3
    assertEquals(A.toString(), "-1,000000x^9-1,000000x^5+4,000000x^4-1,000000x^-3");
  }

  /**
   * @class Polynomial
   * @method times()
   */
  @Test
  public void multiplicationTest() {
    System.out.println("[LOGS] Testing times() ...");
    
    int coefficient;
    int exponent;
    
    /**
     * CASE: 
     *   => x * y       | exponent 0
     *   => xc^e * yc^e | exponent >= 1 (otherwise)
     */
    for (exponent = 0; exponent < 10; exponent++) {
      for (coefficient = 0; coefficient < 10; coefficient++) {
        for (int otherCoefficient = 0; otherCoefficient < 10; otherCoefficient++) {
          if (coefficient * otherCoefficient == 0) continue;
          instance = new Polynomial(coefficient + " " + exponent);
          Polynomial otherInstance = new Polynomial(otherCoefficient + " " + exponent);
          instance.times(otherInstance);
          switch(exponent) {
            case 0: 
              assertEquals(instance.toString(), coefficient * otherCoefficient + ",000000"); 
              break;
            default: 
              assertEquals(instance.toString(), coefficient * otherCoefficient + ",000000x^" + (exponent + exponent)); 
              break;
          }
          
        }
      }
    }
    
    /**
     * CASE: complex multiplication
     */
    Polynomial A = new Polynomial("1 1 6 0");  // f(x) = x + 6
    Polynomial B = new Polynomial("1 1 9 0");  // g(x) = x + 9
    
    A.times(B);                                // f(x) * g(x) = (x + 6) * (x + 9) = x^2 + 15x + 54 
    assertEquals(A.toString(), "1,000000x^2+15,000000x+54,000000");
    
    /**
     * CASE: test commutativity of the times operator
     */
    Polynomial polynomialA = new Polynomial("3 4");
    Polynomial polynomialB = new Polynomial("5 6");
    Polynomial polynomialC = new Polynomial("5 6");
    Polynomial polynomialD = new Polynomial("3 4");
    
    polynomialA.times(polynomialB);
    polynomialC.times(polynomialD);
    
    // Fill in with random number 5 and expect same outputs
    assertEquals(polynomialA.evaluate(5), polynomialC.evaluate(5), 0);
    
    /**
     * CASE: test associativity of the times operator
     */
    polynomialA = new Polynomial("3 4");
    polynomialB = new Polynomial("5 6");
    polynomialC = new Polynomial("7 8");
    
    // ( a * b ) * c
    polynomialA.times(polynomialB);
    polynomialA.times(polynomialC);
    double evaluationA = polynomialA.evaluate(5);
    
    polynomialA = new Polynomial("3 4");
    polynomialB = new Polynomial("5 6");
    polynomialC = new Polynomial("7 8");
    
    // a * ( b * c )
    polynomialB.times(polynomialC);
    polynomialA.times(polynomialB);
    double evaluationB = polynomialA.evaluate(5);
    
    assertEquals(evaluationA, evaluationB, 0);
  }
  
  @Test
  public void mixedTests() {
    System.out.println("[LOGS] Testing distributivity ...");
    
    Polynomial A = new Polynomial("1 2");
    Polynomial B = new Polynomial("3 4");
    Polynomial C = new Polynomial("5 6");
    
    B.plus(C);     // (b + c)
    A.times(B);    // a * (b + c)
    double evaluateA = A.evaluate(5);
    
    Polynomial A1 = new Polynomial("1 2");
    Polynomial A2 = new Polynomial("1 2");
    B = new Polynomial("3 4");
    C = new Polynomial("5 6");
    
    A1.times(B);   // (a * b)
    A2.times(C);   // (a * c)
    A1.plus(A2);   // (a * b) + (a * c)
    double evaluateB = A1.evaluate(5);
    
    assertEquals(evaluateA, evaluateB, 0);
    
    System.out.println("[LOGS] Testing that subtraction is the same as negated addition");
    
    A = new Polynomial("37 0");
    B = new Polynomial("19 0");
    
    A.minus(B);
    evaluateA = A.evaluate(5);
    
    A = new Polynomial("37 0");
    B = new Polynomial("19 0");
    Polynomial negate = new Polynomial("-1 0");
    
    B.times(negate);
    A.plus(B);
    evaluateB = A.evaluate(5);
    
    assertEquals(evaluateA, evaluateB, 0);
  }

}
