//Taken from Yazan and Charlie

package edu.grinnell.csc207.LZY.utils;


public class Calculator
{

  public static Fraction[] storeResult = new Fraction[8];
  static char oper =0;
  static int status =0;
  static Fraction result = null;
  int s;

  /*
    public static String[] splitAt(String input, char sep)
    {
      ArrayList<String> output = new ArrayList<String>(0);
      stringIterator: while (true)
        {  public static String[] splitCSV(String input)
        {

          char sep = ',';
          // define output array
          ArrayList<String> output = new ArrayList<String>(0);

          stringIterator: while (true)
            {
              if (input.charAt(0) != '"')
                {// no quotation mark in the current
                 // element to scan
                  int splitIndex = input.indexOf(sep);
                  if (splitIndex == -1)
                    {
                      output.add(input);
                      break stringIterator;
                    }
                  output.add(input.substring(0, splitIndex));
                  input = input.substring((splitIndex + 1), input.length());
                }
              else
                { // there is a quote
                  int i = 1;
                  scanner: while (true)
                    {
                      if (input.charAt(i) == '"' && i + 1 == input.length())
                        {
                          // if dual-char scanner reaches the end of the string,
                          // then extract
                          output.add(input.substring(1, i));
                          break stringIterator;
                        }
                      if (input.charAt(i) == '"' && input.charAt(i + 1) == '"')
                        {
                          input =
                              input.substring(0, i)
                                  + input.substring(i + 1, input.length());
                        }
                      if (input.charAt(i) == '"' && input.charAt(i + 1) == sep)
                        {
                          // if dual-char scanner reaches ", signifying the end of
                          // the element, extract
                          int splitIndex = i + 1;
                          output.add(input.substring(1, (splitIndex - 1)));
                          input = input.substring((splitIndex + 1), input.length());
                          break scanner;
                        }
                      else
                        i++;
                    }
                }
            } //splitCSV(String input)

          String[] arrayOutput = new String[output.size()];
          arrayOutput = output.toArray(arrayOutput);
          return arrayOutput;
        }

          int sepIndex = input.indexOf(sep);
          if (sepIndex == -1)
            {
              output.add(input);
              break stringIterator;
            }
          output.add(input.substring(0, sepIndex));
          input = input.substring((sepIndex + 1), input.length());
        }

      // thanks to
      // http://stackoverflow.com/questions/5374311/convert-arrayliststring-to-string
      String[] arrayOutput = new String[output.size()];
      arrayOutput = output.toArray(arrayOutput);
      return arrayOutput;
    } //splirAt(String input, char sep);



    /*
      public static BigInteger calculatorEval0(String input)
      { // "1 + 2 + 12
        BigInteger result;
        char oper;
        int sepIndex = input.indexOf(" ");

        if (sepIndex > 0)
          {
            result = new BigInteger(input.substring(0, sepIndex));
            input = input.substring((sepIndex + 1), input.length()); // set                                                                                                 // input="2 + 12"
          }
        else
          {
            result = new BigInteger((input.substring(0, input.length())));
            return result;
          }

        stringIterator: while (true)
          {
            oper = input.charAt(0); // set oper="+"
            switch (oper)
              {
                case '+':
                  {
                    input = input.substring(2, input.length());
                    sepIndex = input.indexOf(" ");
                    if (sepIndex == -1)
                      {
                        BigInteger modifier =
                            new BigInteger(input.substring(0, input.length()));
                        result = result.add(modifier);
                        break stringIterator;
                      }
                    else
                      {
                        result =
                            result.add(new BigInteger(input.substring(0, sepIndex)));
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
                            result.subtract(new BigInteger(
                                                           input.substring(0,
                                                                           input.length())));
                        break stringIterator;
                      }
                    else
                      {
                        result =
                            result.subtract(new BigInteger(
                                                           input.substring(0,
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
                            result.divide(new BigInteger(
                                                         input.substring(0,
                                                                         input.length())));
                        break stringIterator;
                      }
                    else
                      {
                        result =
                            result.divide(new BigInteger(input.substring(0,
                                                                         sepIndex)));
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
                            result.multiply(new BigInteger(
                                                           input.substring(0,
                                                                           input.length())));
                        break stringIterator;
                      }
                    else
                      {
                        result =
                            result.multiply(new BigInteger(
                                                           input.substring(0,
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
                      {
                        result =
                            result.pow(new BigInteger(
                                                      input.substring(0,
                                                                      input.length())).intValue());
                        break stringIterator;
                      }
                    else
                      {
                        result =
                            result.pow(new BigInteger(input.substring(0, sepIndex)).intValue());
                        input = input.substring((sepIndex + 1), input.length());
                      }
                    break;
                  }
                default:
                  break;
              }
          }

        return result;
      } //calculatorEval0(String input)
    */

  public static Fraction evaluate(String input, Fraction result, char oper,
                                  int sepIndex, int rValue)
  {
    stringIterator: while (true)
      {
        oper = input.charAt(0); // set oper="+"
        switch (oper)
          {
            case '=':
              {
                storeResult[rValue] = calculatorEval1(input);
                //result = null;
                //break stringIterator;
                result = storeResult[rValue];
                break stringIterator;
              }
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
  } //evaluate(String input, Fraction result, char oper, int sepIndex)

  public static Fraction calculatorEval1(String input)
  {
    int sepIndex = input.indexOf(" ");

    if (sepIndex > 0)
      {
        //check if the first value is a number, or 'r_"
        if ((input.charAt(0) == 'r')) //if there is a value within 'r_'
          {
            if (storeResult[Character.getNumericValue(input.charAt(1))] != null) //check to see if r_ has a value
              {
                result =
                    storeResult[Character.getNumericValue(input.charAt(1))]; //set result to value 'r_'
                status = 1;
                System.out.println("r contains a value");
              }
            else
              {
              status =0;
              System.out.println("r is null");
              }
          }
        else
          result = new Fraction(input.substring(2));
        input = input.substring((sepIndex + 1), input.length()); // set   
      }
    else
      {
        result = new Fraction((input.substring(0, input.length())));
        return result;
      }

    result = evaluate(input, result, oper, sepIndex, input.charAt(1));
    System.out.println("calculator result:" + result.toString());
    return result;
  }//calculatorEval0(String input)

  /*public static void main(String[] args)
  {
    System.out.println(calculatorEval1(
                                       "r2 = 3/4").toString());
  }*/
}
