package com.cleancoder.args;

import java.util.*;

import static com.cleancoder.args.ArgsException.ErrorCode.*;
class ParseSchema {
  private Map < Character, CharacterParser > charTypeObj;
  private static Map < Character, String > typeMap;
  public ParseSchema(String schema) throws ArgsException {
    charTypeObj = new HashMap < Character, CharacterParser > ();
    typeMap = new HashMap < Character, String > ();
    parseSchema(schema);

  }
  public ParseSchema() {

  }
  private void parseSchema(String schema) throws ArgsException {
    for (String element: schema.split(","))
      if (element.length() > 0)
        parseSchemaElement(element.trim());
  }

  private void parseSchemaElement(String element) throws ArgsException {
    char elementId = element.charAt(0);
    String elementTail = element.substring(1);
    validateSchemaElementId(elementId);
    if (elementTail.length() == 0) {
      charTypeObj.put(elementId, new BooleanInitializer());
      typeMap.put(elementId, "boolean");
    } else if (elementTail.equals("*")) {
      charTypeObj.put(elementId, new StringInitializer());
      typeMap.put(elementId, "string");
    } else if (elementTail.equals("#")) {
      charTypeObj.put(elementId, new IntegerInitializer());
      typeMap.put(elementId, "int");
    } else if (elementTail.equals("##")) {
      charTypeObj.put(elementId, new DoubleInitializer());
      typeMap.put(elementId, "double");
    } else if (elementTail.equals("[*]")) {
      charTypeObj.put(elementId, new StringArrayInitializer());
      typeMap.put(elementId, "string_array");
    } else if (elementTail.equals("&")) {
      charTypeObj.put(elementId, new MapInitializer());
      typeMap.put(elementId, "nothing");
    } else
      throw new ArgsException(INVALID_ARGUMENT_FORMAT, elementId, elementTail);
  }

  private void validateSchemaElementId(char elementId) throws ArgsException {
    if (!Character.isLetter(elementId))
      throw new ArgsException(INVALID_ARGUMENT_NAME, elementId, null);
  }
  public Map < Character, CharacterParser > getMap() {
    return charTypeObj;
  }
  public Map < Character, String > get_map() {
    return typeMap;
  }
}
