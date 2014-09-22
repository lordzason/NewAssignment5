package edu.grinnell.csc207.LZY.utils;

public class Exponentiation
{
  public static int expt(int base, int expt)
  {
    // Fields 
    int halfExpt = expt / 2;
    int answer = 1;

    // Special cases 
    if (expt == 0)
      {
        return 1;
      } // ends if
    else if (expt == 1)
      {
        return base;
      } // ends else if

    // Test for even exponents
    if (expt % 2 == 0)
      {
        for (int index = 0; index < halfExpt; index++)
          {
            answer = answer * base;
          }// ends for
        answer *= answer;
      }// ends if

    // Test for odd exponenets
    else
      {
        halfExpt = (expt - 1) / 2;
        for (int index = 0; index < halfExpt; index++)
          {
            answer = answer * base;
          } // ends for
        answer *= answer * base;
      } // ends else
    return answer;

  }// expt(int base, int expont)
}
