package com.cleancoder.args;
import java.util.*;
public class ArgsMain 
{
   private static Map<Character, String> typeMap;
   public  static void fetchTypeMap(String s)
   {
   	typeMap= new HashMap<Character,String>();
  	 ParseSchema p=new ParseSchema();
   typeMap=p.get_map();

   }
   public static void fetchSetValues(Supervisor arg) throws ArgsException
   {
     Scanner sc=new Scanner(System.in);
     boolean flag;
      System.out.println("Enter True/False");
       flag=sc.nextBoolean();
     while(flag) 
     {
       
        char c=sc.next().charAt(0);
        String s1=typeMap.get(c);
        switch(s1)
        {
          case "int":
            System.out.printf("%d\n",arg.getInt(c));
            break;
          case "boolean":
            System.out.printf("%s\n",arg.getBoolean(c));
            break;
          case "string":
            System.out.printf("%s\n",arg.getString(c));
            break;
          case "double":
            System.out.printf("%f\n",arg.getDouble(c));
            break;
          case "string_array":
            String []arr=arg.getStringArray(c);
            for(int j=0;j<arr.length;j++)
             System.out.printf("%s\n",arr[j]);
            break;
          default:
           System.out.println("sry");
           break;
        }
         System.out.println("Enter True/False");
         flag=sc.nextBoolean();
     }

     
}
  public static void main(String[] args) 
  {
    try 
    {
      
      String schema="f,s*,n#,a##,p[*]";
      Supervisor arg = new Supervisor(schema,args);
      fetchTypeMap(schema);
      fetchSetValues(arg);
      
    } 
    catch (ArgsException e) 
    {
      System.out.printf("Argument error: %s\n", e.errorMessage());
    }
  }

  
}
