package edu.grinnell.csc207.LZY.utils;

import java.math.BigInteger;

/**
 * A simple implementation of Fractions.
 *
 * @author Samuel A. Rebelsky
 * @author Charlie Gao
 * @author Yazan Kittaneh
 * @author CSC152 2005S
 * @version 1.0 of February 2005
 */
public class Fraction
{
  // +------------------+---------------------------------------------
  // | Design Decisions |
  // +------------------+
  /*
   * (1) Denominators are always positive. Therefore, negative fractions are
   * represented with a negative numerator. Similarly, if a fraction has a
   * negative numerator, it is negative.
   * 
   * (2) Fractions are not necessarily stored in simplified form. To obtain a
   * fraction in simplified form, one must call the simplify method.
   */
  // +--------+-------------------------------------------------------
  // | Fields |
  // +--------+
  /** The numerator of the fraction. Can be positive, zero or negative. */
  BigInteger num;
  /** The denominator of the fraction. Must be non-negative. */
  BigInteger denom;

  // +--------------+-------------------------------------------------
  // | Constructors |
  // +--------------+
  /**
   * Build a new fraction with numerator num and denominator denom.
   *
   * Warning! Not yet stable.
   */
  public Fraction(BigInteger num, BigInteger denom)
  {
    this.num = num;
    this.denom = denom;
  } // Fraction(BigInteger, BigInteger)

  /**
   * Build a new fraction with numerator num and denominator denom.
   *
   * Warning! Not yet stable.
   */
  public Fraction(int num, int denom)
  {
    this.num = BigInteger.valueOf(num);
    this.denom = BigInteger.valueOf(denom);
  } // Fraction(int, int)

 /* public Fraction(String input)
  {
    this.num = new BigInteger(input.substring(0, input.indexOf('/')));
    this.denom =
        new BigInteger(input.substring(input.indexOf('/') + 1, input.length()));
  }
  */

  public Fraction(String input)
  {
    if (input.indexOf('/') != -1)
      {
        this.num = new BigInteger(input.substring(0, input.indexOf('/')));
        this.denom =
            new BigInteger(input.substring(input.indexOf('/') + 1,
                                           input.length()));
      }
    else
      {
        this.num = new BigInteger(input.substring(0, input.length()));
        this.denom = BigInteger.valueOf(1);
      }
  }

  // +---------+------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Express this fraction as a double.
   */
  public double doubleValue()
  {
    return this.num.doubleValue() / this.denom.doubleValue();
  } // doubleValue()

  /**
   * Add the fraction other to this fraction.
   */
  public Fraction add(Fraction addMe)
  {
    BigInteger resultNumerator;
    BigInteger resultDenominator;
    // The denominator of the result is the
    // product of this object's denominator
    // and addMe's denominator
    resultDenominator = this.denom.multiply(addMe.denom);
    // The numerator is more complicated
    resultNumerator =
        (this.num.multiply(addMe.denom)).add(addMe.num.multiply(this.denom));
    // Return the computed value
    return new Fraction(resultNumerator, resultDenominator).gcf();
  }// add(Fraction)

  /**
   * Add the fraction other to this fraction.
   */
  public Fraction subtract(Fraction subtractMe)
  {
    BigInteger resultNumerator;
    BigInteger resultDenominator;
    // The denominator of the result is the
    // product of this object's denominator
    // and subtractMe's denominator
    resultDenominator = this.denom.multiply(subtractMe.denom);
    // The numerator is more complicated
    resultNumerator =
        (this.num.multiply(subtractMe.denom)).subtract(subtractMe.num.multiply(this.denom));
    // Return the computed value
    return new Fraction(resultNumerator, resultDenominator).gcf();
  }// subtract(Fraction)

  /**
   * Multiply the fraction other to this fraction.
   */
  public Fraction multiply(Fraction multiplyMe)
  {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    resultDenominator = this.denom.multiply(multiplyMe.denom);
    resultNumerator = (this.num.multiply(multiplyMe.num));

    // Return the computed value
    return new Fraction(resultNumerator, resultDenominator).gcf();
  }// multiply(Fraction)

  /**
   * Divide the fraction to the divisor.
   */
  public Fraction divide(Fraction divisor)
  {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    resultDenominator = this.denom.multiply(divisor.num);
    resultNumerator = (this.num.multiply(divisor.denom));

    // Return the computed value
    return new Fraction(resultNumerator, resultDenominator).gcf();
  }// divide(Fraction)

  /**
   * Turn improper fraction into proper fraction.
   */
  public Fraction fractional(Fraction improperFrac)
  {
    BigInteger resultNumerator;

    resultNumerator = improperFrac.num.mod(improperFrac.denom);
    return new Fraction(resultNumerator, improperFrac.denom).gcf();
  }//fractional(Fraction improperFrac)

  /**
   * Convert this fraction to a string for ease of printing.
   */
  public String toString()
  {
    // Special case: It's zero
    if (this.num.equals(BigInteger.ZERO))
      {
        return "0";
      } // if it's zero
        // Lump together the string represention of the numerator,
    // a slash, and the string representation of the denominator
    // return this.num.toString().concat("/").concat(this.denom.toString());
    return this.num + "/" + this.denom;
  } // toString()

  /**
   * Returns a new fraction which is the additive inverse of the original fraction. 
   */
  public Fraction negate()
  {
    BigInteger resultNumerator;
    resultNumerator = this.num.negate();
    return new Fraction(resultNumerator, this.denom).gcf();
  } //negate();

  /**
   *  Returns the new fraction that results from raising the given fraction to the given exponent.
   */
  public Fraction pow(int expt)
  {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    resultNumerator = this.num.pow(expt);
    resultDenominator = this.denom.pow(expt);

    return new Fraction(resultNumerator, resultDenominator).gcf();
  } //pow(int expt)

  /**
   *  Returns greatest common factor.
   */
  public Fraction gcf()
  {
    BigInteger resultNumerator;
    BigInteger resultDenominator;
    BigInteger factor;

    factor = this.num.gcd(this.denom);
    resultNumerator = this.num.divide(factor);
    resultDenominator = this.denom.divide(factor);

    return new Fraction(resultNumerator, resultDenominator);
  } //  gcf()

} // class Fraction 