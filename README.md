# Software Engineering
## Name: Aditya Gupta Roll No: 2019201067
## 1. Synopsis
This program is (written in JAVA Programming Language)  taking a schema along with corresponding command line argument containing respective character values.
Schema: f,s*,a##,n#,p[*] \
Schema:
 - char    - Boolean arg.
 - char*   - String arg.
 - char#   - Integer arg.
 - char##  - double arg.
 - char[*] - one element of a string array\
Command Line Argument: -f -s aditya -n 40 -a 4.66 -p asd -p fgh -p jkl

### 2. Program functioning with description of classes and their methods
- ArgsMain.java :
 This class is used to pass Schema to the Args class and check the values that is set for corresponding character.
- CharacterParser.java : 
    1. This is a supervise class which is performing three different functions using three different classes.
    2. The three functioning includes-
       -Parsing Given schema and populating map with charType objects.
       -parsing dynamic command line input to set different values to different variables of different datatypes.
       -To find the variables values of different types, and also to check whether variable value is set or not.
- ParseSchema.java : 
    1. It populates Map<char,ArgumentMarshaler> with character and its respective datatype objects defined by given Schema
    2. returns populated Map to Args.java
- ParseArgument.java :
    - This class is used to fill variable values based on given command line argument String,
    - and fill set<character> to check the corresponding char value is set or not.
- BooleanInitializer :set boolean variable value as true or false accordingly.
- StringInitializer : Intitalizes String corresponding to character passed
- StringArrayInitializer : Intitalizes Multiplte Strings corresponding to character passed as Array
- IntegerInitializer : Intitalizes Integer corresponding to character passed
- DoubleInitializer : Intitalizes Double corresponding to character passed
- MapInitializer : Intitalizes String Map corresponding to character passed


## 3. cleaning Techniques Implimented aprior
   1. Number of lines in methods should not exceed to 7-8.
   2. Methods should have less than three arguments.
   3. Comments shouldbe ignored as much as they can be.
   4. Exception handling is handled, but not completely.

## 4. IMPLEMENTED FEATURES
   - Exception handling
   - Interface method Overriding
   - Modularity
   - Class with  default constructor
   - command line input processing(Dynamic)
   - Inheritance


## 5. Code Cleaning Techniques
   1. Modularity of Tasks are divided into sub-tasks
   2. Readability criteria
   3. Naming itself should include its definition
   4. redundancy removal
   5. comments strictly when required
   6. removal of Errors with exception handling
   7. Reusability of Code
   8. Access Specifiers : public, private, protected 

      
