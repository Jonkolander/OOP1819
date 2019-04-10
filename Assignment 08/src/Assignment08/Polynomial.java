package Assignment08;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * A skeleton class for representing Polynomials
 *
 * @author Sjaak Smetsers
 * @date 19-04-2016
 *
 * ==============================================
 *
 * Modified by:
 * @author Dennis den Hollander | (s4776658)
 * @author Tom Kamp | (s4760921)
 */
public class Polynomial {

  /**
   * A polynomial is a sequence of terms here kept in an List
   */
  List<Term> terms;

  /**
   * A constructor for creating the zero Polynomial zero is presented as an empty list of terms and not as a single term with 0 as a coefficient
   */
  public Polynomial() {
    terms = new LinkedList<>();
  }

  /**
   * A Constructor creating a polynomial from the argument string.
   *
   * @param s a String representing a list of terms which is converted to a scanner and passed to scanTerm for reading each individual term
   */
  public Polynomial(String s) {
    terms = new LinkedList<>();
    Scanner scan = new Scanner(s);

    for (Term t = Term.scanTerm(scan); t != null; t = Term.scanTerm(scan)) {
      terms.add(t);
    }
  }

  /**
   * The copy constructor for making a deep copy
   *
   * @param p the copied polynomial
   *
   */
  public Polynomial(Polynomial p) {
    terms = new LinkedList<>();
    for (Term t : p.terms) {
      terms.add(new Term(t));
    }
  }

  /**
   * A straightforward conversion of a Polynomial into a string based on the toString for terms
   *
   * @return a readable string representation of this
   */
  @Override
  public String toString() {
    this.terms.sort((Term term, Term other) -> {
      return other.getExponent() - term.getExponent();
    });

    StringBuilder sb = new StringBuilder();
    boolean isFirstTerm = true;
    for (Term term : terms) {
      if (!isFirstTerm && term.getCoefficient() >= 0) {
        sb.append('+');
      }
      sb.append(term);
      isFirstTerm = false;
    }
    return sb.toString();
  }

  public void plus(Polynomial otherPolynomial) {
    for (Term otherTerm : otherPolynomial.terms) {
      plus(otherTerm);
    }
  }

  /**
   *
   * @param otherTerm
   */
  public void plus(Term otherTerm) {
    if (otherTerm.getCoefficient() == 0) {
      return;
    }

    Iterator<Term> iterator = this.terms.iterator();
    while (iterator.hasNext()) {
      Term term = iterator.next();
      if (term.getExponent() == otherTerm.getExponent()) {
        term.plus(otherTerm);
        if (term.getCoefficient() == 0) {
          iterator.remove();
        }
        return;
      }
    }
    this.terms.add(new Term(otherTerm));
  }

  /**
   *
   * @param otherPolynomial
   */
  public void minus(Polynomial otherPolynomial) {
    for (Term otherTerm : otherPolynomial.terms) {
      Polynomial temp = new Polynomial(
        otherTerm.getCoefficient()
          + " "
          + otherTerm.getExponent()
      );

      temp.times(new Polynomial("-1 0"));
      plus(temp);
    }
  }

  /**
   *
   * @param otherPolynomial
   */
  public void times(Polynomial otherPolynomial) {
    Polynomial result = new Polynomial();
    for (Term otherTerm : otherPolynomial.terms) {
      for (Term term : this.terms) {
        result.plus(
          new Term(
            otherTerm.getCoefficient() * term.getCoefficient(),
            otherTerm.getExponent() + term.getExponent()
          )
        );
      }
    }

    this.terms = result.terms;
  }
  
  /**
   * 
   * @param x
   * @return result
   */
  public double evaluate (int x) {
    double result = 0.0;
    for (Term term : this.terms) {
      result += term.getCoefficient() * Math.pow(x, term.getExponent());
    }
    
    return result;
  } 

  /**
   * Checks whether this is equal to otherPolynomial
   *
   * @param otherPolynomial
   * @return
   */
  @Override
  public boolean equals(Object otherPolynomial) {
    if (otherPolynomial instanceof Object) {
      return false;
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 89 * hash + Objects.hashCode(this.terms);
    return hash;
  }

}
