//Taken from Yazan and Charlie

package csc207.hw5.edu.grinnell.csc207.LZY.utils;

public class Calculator2
{

  public static Fraction[] storeResult = new Fraction[8];
  static char oper = 0;
  static int status = 0;
  static Fraction result = null;
  static int rValue = 0;
  int s;

  /**
   * This is purely evaluating what the input is.
   * This does not do anything with the stored values
   * 
   * @param input
   * @return fraction
   */
  public static Fraction evaluate(String input, Fraction result)
  {
    stringIterator: while (true) // + 3
      {
        int sepIndex;
        oper = input.charAt(0); // set oper="+"
        switch (oper)
          {
            case '+':
              {
                input = input.substring(2, input.length());
                sepIndex = input.indexOf(" ");
                if (sepIndex == -1)
                  {
                    Fraction modifier =
                        new Fraction(input.substring(0, input.length()));
                    result = result.add(modifier);
                    break stringIterator;
                  }
                else
                  {
                    result =
                        result.add(new Fraction(input.substring(0, sepIndex)));
                    input = input.substring((sepIndex + 1), input.length());
                  }
                break;
              }
            case '-':
              {
                input = input.substring(2, input.length());
                sepIndex = input.indexOf(" ");
                if (sepIndex == -1)
                  {
                    result =
                        result.subtract(new Fraction(
                                                     input.substring(0,
                                                                     input.length())));
                    break stringIterator;
                  }
                else
                  {
                    result =
                        result.subtract(new Fraction(input.substring(0,
                                                                     sepIndex)));
                    input = input.substring((sepIndex + 1), input.length());
                  }
                break;
              }
            case '/':
              {
                input = input.substring(2, input.length());
                sepIndex = input.indexOf(" ");
                if (sepIndex == -1)
                  {
                    result =
                        result.divide(new Fraction(
                                                   input.substring(0,
                                                                   input.length())));
                    break stringIterator;
                  }
                else
                  {
                    result =
                        result.divide(new Fraction(input.substring(0, sepIndex)));
                    input = input.substring((sepIndex + 1), input.length());
                  }
                break;
              }
            case '*':
              {
                input = input.substring(2, input.length());
                sepIndex = input.indexOf(" ");
                if (sepIndex == -1)
                  {
                    result =
                        result.multiply(new Fraction(
                                                     input.substring(0,
                                                                     input.length())));
                    break stringIterator;
                  }
                else
                  {
                    result =
                        result.multiply(new Fraction(input.substring(0,
                                                                     sepIndex)));
                    input = input.substring((sepIndex + 1), input.length());
                  }
                break;
              }
            case '^':
              {
                input = input.substring(2, input.length());
                sepIndex = input.indexOf(" ");
                if (sepIndex == -1)
                  { //casting doubles as ints because I can
                    result =
                        result.pow((int) new Fraction(
                                                      input.substring(0,
                                                                      input.length())).doubleValue());
                    break stringIterator;
                  }
                else
                  {
                    result =
                        result.pow((int) new Fraction(input.substring(0,
                                                                      sepIndex)).doubleValue());
                    input = input.substring((sepIndex + 1), input.length());
                  }
                break;
              }
            default:
              break;
          }
      }
    return result;
  } //evaluate(String input);

  public static Fraction calculatorEval1(String input) // r1 = 3/4 + 3 
  {
    int sepIndex = input.indexOf(" "); //find index of space  
    
    if (sepIndex > 0)
      {
        if ((input.charAt(0) == 'r')) //check for r
          {
            if ((input.charAt(3) == '=')) //check if r is equal to something
              {
                rValue = Character.getNumericValue(input.charAt(1)); //get r value before changing input
                input = input.substring((sepIndex + 3), input.length()); //make it equal to everything after =
                storeResult[rValue] = calculatorEval1(input); //r= (everything here)
              }
            else
              {
                if (storeResult[Character.getNumericValue(input.charAt(1))] != null)
                  {
                    result =
                        storeResult[Character.getNumericValue(input.charAt(1))];
                  }
                else
                  {
                    System.out.println("The value is null, expression cannot be evaluated");
                    return null;
                  }
              }
          }
        else
          //if its not an r, then it must be an expression
          {
            result = new Fraction((input.substring(0, sepIndex)));
            input = input.substring((sepIndex + 1), input.length());
            result = evaluate(input, result);
          }
      }
    else
      {
        result = new Fraction((input.substring(0, input.length())));
        return result;
      }
    
    //System.out.println(result.toString());
    
    return result;
  }

  public static void main(String[] args)
  {
    System.out.println(calculatorEval1(
                                       "r1 = 3/1  + 0").toString());
    System.out.println(storeResult[rValue].toString());
  }
  
}
