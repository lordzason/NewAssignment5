package edu.grinnell.csc207.LZY.utils;

import java.io.PrintWriter;
import java.math.BigDecimal;

public class Test
{

  public static void main(String[] args)
  {
    PrintWriter pen = new PrintWriter(System.out, true);
   // Utils.sqrt(BigDecimal.valueOf(4),BigDecimal.valueOf(0));
    //pen.println(Utils.sqrt(BigDecimal.valueOf(10),BigDecimal.valueOf(0.000001)));
    pen.println(Exponentiation.expt(100,0));

  }

}
