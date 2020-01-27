package com.cleancoder.args;

import static com.cleancoder.args.ArgsException.ErrorCode.*;

import java.util.*;

public class IntegerInitializer implements CharacterParser {
  private int intValue = 0;
   public IntegerInitializer() throws ArgsException 
  {
    this.intValue=0;
  }
  public void set(Iterator<String> currentArgument) throws ArgsException {
    String parameter = null;
    try {
      parameter = currentArgument.next();
      intValue = Integer.parseInt(parameter);
    } catch (NoSuchElementException e) {
      throw new ArgsException(MISSING_INTEGER);
    } catch (NumberFormatException e) {
      throw new ArgsException(INVALID_INTEGER, parameter);
    }
  }

  public static int getValue(CharacterParser am) {
    if (am != null && am instanceof IntegerInitializer)
      return ((IntegerInitializer) am).intValue;
    else
      return 0;
  }
}
