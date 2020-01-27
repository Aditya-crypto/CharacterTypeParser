package com.cleancoder.args;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static com.cleancoder.args.ArgsException.ErrorCode.MISSING_STRING;

public class StringInitializer implements CharacterParser {
  private String stringValue;
   public StringInitializer() throws ArgsException 
  {
    this.stringValue = "";
  }
  public void set(Iterator<String> currentArgument) throws ArgsException {
    try {
      stringValue = currentArgument.next();
    } catch (NoSuchElementException e) {
      throw new ArgsException(MISSING_STRING);
    }
  }

  public static String getValue(CharacterParser am) {
    if (am != null && am instanceof StringInitializer)
      return ((StringInitializer) am).stringValue;
    else
      return "";
  }
}
