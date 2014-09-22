package edu.grinnell.csc207.LZY.utils;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class UtilsTest
{

  @Test
  public void testSqrt()
  {
    assertEquals(BigDecimal.valueOf(3), Utils.sqrt(BigDecimal.valueOf(10),BigDecimal.valueOf(0.001)));
  }
  

//  @Test
//  public void testExpt()
//  {
//    assertEquals(729, Utils.expt(3,6));
//  }
}
