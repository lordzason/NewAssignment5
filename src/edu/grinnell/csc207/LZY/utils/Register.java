package edu.grinnell.csc207.LZY.utils;

public class Register
{
  // Field
  Fraction value;
  boolean state = false;

  // Constructor

  public Register()
  {
  }

  // Methods
  public void setValue(Fraction someValue)
  {
    this.value = someValue;
  }

  public void setState()
  {
    this.state = true;
  }

  public Fraction getVal()
  {
    return this.value;
  }

  public boolean getState()
  {
    return this.state;
  } 
}
