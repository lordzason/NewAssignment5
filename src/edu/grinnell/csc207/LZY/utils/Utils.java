//Revised based on suggestions from Sam Rebelsky

package edu.grinnell.csc207.LZY.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Utils

{
  // Constant
  public static final BigDecimal half = BigDecimal.valueOf(0.5);
  
   /**** Helper Methods ***/
  
  // Test whether an estimate of a square root is within epsilon
  public static boolean isWithinEpsilon(BigDecimal value, BigDecimal estimate,
                                        BigDecimal errorMargin)
  {

    return ((value.subtract(estimate.pow(2)).abs().compareTo(errorMargin) != 1));

  }// end isWithinEpsilon(BigDecimal value, BigDecimal estimate, BigDecimal errorMargin)

  public static BigDecimal estimateComputation(BigDecimal value,
                                               BigDecimal estimate,int epsilonScale)
  {
    BigDecimal newEstimate =
        (estimate.add(value.divide(estimate, epsilonScale, RoundingMode.HALF_UP)).multiply(Utils.half));
    return newEstimate;
  }
 /*****************************************************************************************************/
  
  
  
  public static BigDecimal sqrt(BigDecimal d, BigDecimal epsilon)
  {
    // Fields
    BigDecimal firstEstimate, newEstimate;
    
    firstEstimate = d.divide(BigDecimal.valueOf(2));
    //approximateAnswer = d.subtract(epsilon);****
    
    int epsilonScale = epsilon.scale();

    // newEstimate holds the first estimation per the algorithm for the Newton-Raphson method
    newEstimate = estimateComputation(d, firstEstimate, epsilonScale);
    
    

    while (!Utils.isWithinEpsilon(d, newEstimate, epsilon))
      {

        firstEstimate = newEstimate;
        newEstimate = estimateComputation(d, firstEstimate, epsilonScale);
        //System.out.println(newEstimate);

      }// ends while
    //System.out.println(newEstimate);
    return newEstimate;

  }//sqrt(BigDecimal d, BigDecimal epsilon)

}//Class Utils
