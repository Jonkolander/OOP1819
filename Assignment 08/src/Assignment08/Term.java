package Assignment08;

import java.util.Scanner;

/**
 * For representing terms in a polynomial.
 *
 * @author Sjaak Smetsers
 * @date 19-04-2016
 *
 * ==============================================
 *
 * Modified by:
 * @author Dennis den Hollander | (s4776658)
 * @author Tom Kamp             | (s4760921)
 */
public class Term {

  /**
   * Each term consists of a coefficient and an exponent
   */
  private double coefficient;
  private int exponent;

  /**
   * a get-method for the exponent
   *
   * @return exponent
   */
  public int getExponent() {
    return exponent;
  }

  /**
   * a get-method for the coefficient
   *
   * @return coefficient
   */
  public double getCoefficient() {
    return coefficient;
  }

  /**
   * A two-argument constructor
   *
   * @param coefficient the value for the coefficient
   * @param exponent the value for the exponent
   */
  public Term(double coefficient, int exponent) {
    this.coefficient = coefficient;
    this.exponent = exponent;
  }

  /**
   * A copy-constructor
   *
   * @param term the term to be copied
   */
  public Term(Term term) {
    this(term.coefficient, term.exponent);
  }

  /**
   * For adding two terms with equal exponents
   *
   * @param term the term added to this
   * @require exponent == t.exponent
   */
  public void plus(Term term) {
    coefficient += term.coefficient;
  }

  public void minus(Term term) {
    coefficient -= term.coefficient;
  }

  /**
   * For multiplying two terms
   *
   * @param term the multiplier
   */
  public void times(Term term) {
    exponent += term.exponent;
    coefficient *= term.coefficient;
  }

  /**
   * Converts a term into a readable representation the standard format is %fx^%d
   *
   * @return the string representing the term
   */
  @Override
  public String toString() {
    switch (exponent) {
      case 0:
        return String.format("%f", coefficient);
      case 1:
        return String.format("%fx", coefficient);
      default:
        return String.format("%fx^%d", coefficient, exponent);
    }
  }

  /**
   * Standard implementation of equality
   *
   * @param may_be_term
   * @return
   */
  @Override
  public boolean equals(Object may_be_term) {
    if (may_be_term == null || getClass() != may_be_term.getClass()) {
      return false;
    } else {
      Term term = (Term) may_be_term;
      return exponent == term.exponent
              && coefficient == term.coefficient;
    }
  }

  /**
   * A static method for converting scanner input into a term. The expected format is two numbers (coef, exp) separated by whitespaces. The coef should be either an integer or a decimal number. The exp is an integer.
   *
   * @param s the scanner providing the input
   * @return null if no term could be found, the found term otherwise
   */
  public static Term scanTerm(Scanner s) {
    String coef_patt = "\\-?\\d+(\\.\\d+)?";
    if (s.hasNext(coef_patt)) {
      String coef = s.next(coef_patt);
      int exp = s.nextInt();
      return new Term(Double.parseDouble(coef), exp);
    } else {
      return null;
    }
  }
}
