package com.cleancoder.args;

import java.util.*;

import static com.cleancoder.args.ArgsException.ErrorCode.*;

public class Supervisor 
{
  private Map<Character, CharacterParser> charTypeObj;
  private ListIterator<String> currentArgument;
  private Set<Character> valueIsSet;
  public Supervisor(String schema,String[] args) throws ArgsException 
  {
    charTypeObj = new HashMap<Character, CharacterParser>();
    valueIsSet = new HashSet<Character>();
    ParseSchema parse=new ParseSchema(schema);
    charTypeObj=parse.getMap();
    ParseArgumentString p=new ParseArgumentString(Arrays.asList(args),charTypeObj);
    valueIsSet=p.getSet();
  
  }
  public boolean has(char arg)
   {
    return valueIsSet.contains(arg);
   }

  public int nextArgument() 
  {
    return currentArgument.nextIndex();
  }

  public boolean getBoolean(char arg) 
  {
    return BooleanInitializer.getValue(charTypeObj.get(arg));
  }

  public String getString(char arg) 
  {
    return StringInitializer.getValue(charTypeObj.get(arg));
  }

  public int getInt(char arg) 
  {
    return IntegerInitializer.getValue(charTypeObj.get(arg));
  }

  public double getDouble(char arg) 
  {
    return DoubleInitializer.getValue(charTypeObj.get(arg));
  }

  public String[] getStringArray(char arg)
  {
    return StringArrayInitializer.getValue(charTypeObj.get(arg));
  }

  public Map<String, String> getMap(char arg) 
  {
    return MapInitializer.getValue(charTypeObj.get(arg));
  }
};
