package com.cleancoder.args;

import java.util.Iterator;

public class BooleanInitializer implements CharacterParser {
  private boolean booleanValue;
    public BooleanInitializer() throws ArgsException 
  {
    booleanValue = false;
  }

  public void set(Iterator<String> currentArgument) throws ArgsException {
    booleanValue = true;
  }

  public static boolean getValue(CharacterParser am) {
    if (am != null && am instanceof BooleanInitializer)
      return ((BooleanInitializer) am).booleanValue;
    else
      return false;
  }
}

