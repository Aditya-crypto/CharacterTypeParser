package com.cleancoder.args;

import java.util.*;

import static com.cleancoder.args.ArgsException.ErrorCode.*;
class ParseArgumentString
{
    private ListIterator<String> currentArgument;
    private Map<Character, CharacterParser> marshalers;
    private Set<Character> argsFound;
    public ParseArgumentString(List<String> argsList,Map<Character,CharacterParser> ma)throws ArgsException
    {
        marshalers = new HashMap<Character, CharacterParser>();
        argsFound = new HashSet<Character>();
      marshalers=ma;
      if(!marshalers.isEmpty())
         parseArgumentStrings(argsList);
    }
    private void parseArgumentStrings(List<String> argsList) throws ArgsException {
 int count=1;
    for (currentArgument = argsList.listIterator(); currentArgument.hasNext();) {      
String argString = currentArgument.next();

      if (argString.startsWith("-")) {
count++;
    if((argString.substring(1)).length()==1){
parseArgumentCharacters(argString.substring(1));
}
else{
throw new ArgsException(INVALID_ARGUMENTS,argString , null);
}
      } else {
        if(count==1)
        throw new ArgsException(INVALID_ARGUMENTS,argString , null);
        currentArgument.previous();
        break;
      }
    }
  }

  private void parseArgumentCharacters(String argChars) throws ArgsException 
  {
      for(int i=0;i<argChars.length();i++)      
         parseArgumentCharacter(argChars.charAt(i));
  }

  private void parseArgumentCharacter(char argChar) throws ArgsException 
  {
    CharacterParser m = marshalers.get(argChar);
    if (m == null) 
    {

      throw new ArgsException(UNEXPECTED_ARGUMENT, argChar, null);
    } else 
    {
        
      argsFound.add(argChar);
      try 
      {
        m.set(currentArgument);
      } catch (ArgsException e) 
      {
        e.setErrorArgumentId(argChar);
        throw e;
      }
    }
  }
  public Set<Character> getSet()
  {
      return argsFound;
  }
}
