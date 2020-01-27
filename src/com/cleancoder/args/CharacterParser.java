package com.cleancoder.args;

import java.util.Iterator;

public interface CharacterParser {
  void set(Iterator<String> currentArgument) throws ArgsException;
}
