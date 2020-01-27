# Software Engineering
## Name: Aditya Gupta Roll No: 2019201067
## 1. AIM 
The aim of the JAVA program is to take a schema of characters along with corresponding command line argument containing respective character values.\
Schema: f,s*,a##,n#,p[*] \
Schema:
 - char    - Boolean arg.
 - char*   - String arg.
 - char#   - Integer arg.
 - char##  - double arg.
 - char[*] - one element of a string array\
Command Line Argument: -f -s Bob -n 10 -a 3.2 -p e1 -p e2

## 2. IMPLEMENTED FEATURES
- Modularity
- Exception handling
- Dynamic Input Processing
- Inheritance
- Interface Overriding
- Each Class Contains a Constructor

### Methods Functionality
- ArgsMain.java : Passes the schema and command line argument to Args Class for Schema initialization
- Args.java : 1. Creates a Map for each schema containing <Character,ArgumentMarshaler>, ArgumentMarshaler corresponds to each                  type conversion class.
              2. Creates a Set representing character set or not.
- ParseSchema.java : 1. Map Initialization, Schema is split and each character is associated with corresponding                                         ArgumentMarshaler class.
                     2. returns Map to Args.java
- ParseArgument.java : Set Initialization and returns Set to Args.java
- BooleanArgumentMarshaler : If Character present value=true else false
- StringArgumentMarshaler : Intitalizes String corresponding to character passed
- StringArrayArgumentMarshaler : Intitalizes Multiplte Strings corresponding to character passed as Array
- IntegerArgumentMarshaler : Intitalizes Integer corresponding to character passed
- DoubleArgumentMarshaler : Intitalizes Double corresponding to character passed
- MapArgumentMarshaler : Intitalizes String Map corresponding to character passed

## 3. Code Cleaning Techniques
   1. Modularity: Simple Code with small methods and classes.
      - Small Functions
      - Each Function is doing a single task
      - Less Nested Structure
      - Minimum Number of Arguments i.e. at max 3 
   2. Clear understanding of the code with proper flow.
   3. Naming Convention: Clear Naming of Variables,Functions and Classes to provide ease in understanding of Code.
      - Used Intention revealing Name - related to the solution
      - Used one Word Per Concept for clarity
   4. DRY Principle : Do Not Repeat Yourself , Writing Code in Functions and CLasses to not repat Code
      - Inheritance
      - Overriding
   5. Intelligent Comments : Only Comment where Required
   6. Error Handling : Throwing exceptions is better than returning different codes dependent on errors.
   7. Reusability of Code
   8. Access Specifiers : public, private, protected 
      - proper security for data
      
