 /**
   * Inspiration from http://courses.cs.vt.edu/cs2104/Fall12/notes/T17_DivideAndConquer.pdf
   * 
   * Method evaluates the exponentiation of a double 
   * 
   * @param base
   * @param expt
   * @return evaluated expression
   */

package edu.grinnell.csc207.chenzhi17.testpackage;

public class TestClass
{

  public static double expt(double base, double expt)
  {
    //Field
    double answer = 1;

    // Special cases 
    if (expt == 0) // case if exponent is 0
      {
        return 1;
      } // ends if
    else if (expt == 1) // case if exponent is 1
      {
        return base;
      } // ends else if
    else
      {
        while (expt > 0)
          {
            if (expt % 2 == 0)
              {
                base = base * base;

                expt = expt / 2;
              } // if 
            else
              {
                answer *= base;
                expt = expt - 1;
              } //else
          }// while
      }// else

    return answer;
  }//expt2(int base, int expt)
}// class

