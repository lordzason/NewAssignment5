//Revised based on suggestions from Sam Rebelsky

package edu.grinnell.csc207.LZY.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Utils

{
  public static final BigDecimal half = BigDecimal.valueOf(0.5);

  // Test for values within the range of epsilon
  public static boolean isWithinEpsilon(BigDecimal value, BigDecimal estimate,
                                        BigDecimal errorMargin)
  {
    if ((value.subtract(estimate.pow(2)).abs().compareTo(errorMargin) == -1)
        || (value.subtract(estimate.pow(2)).abs().compareTo(errorMargin) == 0))
      {
        return true;
      } // close if

    return false;
  }// end isWithinEpsilon(BigDecimal value, BigDecimal estimate, BigDecimal errorMargin)

  public static BigDecimal estimateComputation(BigDecimal value,
                                               BigDecimal estimate)
  {
    BigDecimal newEstimate =
        (estimate.add(value.divide(estimate, 3, RoundingMode.HALF_UP)).multiply(Utils.half));
    return newEstimate;
  }

  public static BigDecimal sqrt(BigDecimal d, BigDecimal epsilon)
  {
    // Fields
    BigDecimal firstEstimate, newEstimate;

    firstEstimate = d.divide(BigDecimal.valueOf(2));
    //approximateAnswer = d.subtract(epsilon);****

    // newEstimate holds the first estimation per the algorithm for the Newton-Raphson method
    newEstimate = estimateComputation(d, firstEstimate);

    while (Utils.isWithinEpsilon(d, newEstimate, epsilon) == false)
      {

        firstEstimate = newEstimate;
        newEstimate = estimateComputation(d, firstEstimate);
        System.out.println(newEstimate);

      }// ends while
    System.out.println(newEstimate);
    return newEstimate;

  }// close sqrt(BigDecimal d, BigDecimal epsilon)
    


}// close Class
