package com.cleancoder.args;

import static com.cleancoder.args.ArgsException.ErrorCode.*;

import java.util.*;

public class StringArrayInitializer implements CharacterParser {
  private List<String> strings = new ArrayList<String>();
   public StringArrayInitializer() throws ArgsException 
  {
    this.strings = new ArrayList<String>();
  }

  public void set(Iterator<String> currentArgument) throws ArgsException {
    try {
      strings.add(currentArgument.next());
    } catch (NoSuchElementException e) {
      throw new ArgsException(MISSING_STRING);
    }
  }

  public static String[] getValue(CharacterParser am) {
    if (am != null && am instanceof StringArrayInitializer)
      return ((StringArrayInitializer) am).strings.toArray(new String[0]);
    else
      return new String[0];
  }
}
