package com.company;

import java.util.*;




public class FuncDecValidity {

  static int stringIndex = 0;
  
  // if true, one of the parameters is void, check arraylist number
  static boolean voidFlag = false;
  
  static ArrayList<String> functionNames = new ArrayList<String>();
  
  // add static array lists for function names, and variable names as parameters/ arguements
  // each function should have its own array of argument/ parameter names

  public static void main(String[] args) { 
    
    
    String test1 = "    int   square(int)  ;";
    
    String xd ="char";
    
    String test7 = "int ";
    
    String test2 = "char hello(int);";
    
    String test3 = "void hello(int);";
    
    String test4 = "int gcd(int,int);";
    
    String test5 = "double hello(int);";
      
    String test6 = " int squareint (int k, int  ) , noarg(), circle(int  radius , char doink),box( int), cake(int,int )  ;" ;
    
    String test9 = "int circle(int  radius ,  char radius  );";
    
    String comma ="a,  ,a";
   
    boolean tester;
    
 //   tester = isValidFuncDec(test1);
 //   tester = isValidFuncDec(test2);
 //   tester = isValidFuncDec(test3);
 //   tester = isValidFuncDec(test4);
    //tester = isValidFuncDec(test4);
    
  //         tester = isValidFuncDec(test6);
   // tester = isValidParameters("int k");
       // tester = hasNoDoubleComma(comma);
// tester = isValidFuncName("2whop");
 //    tester = isDataType(xd,0,2);
    //System.out.println(hey);
    
    return;
  }
  
//  SAMPLES THAT SHOULD WORK
  
//  int square(int);
//  int    square (int);
//  void display();
//  void compute(void);
//  int magic(void k);
//  void delete(int);
//  void delete(int), int x = 3;
//  void    delete (   int    );
//  int power(int,int);
//  char toLower (char);
//  char toLower (char), tryAgain();  
//  double squareRoot(float);
//  int gcd(int,int), lcm(int,int);
//  int isPrime(int n), isNotPrime(int);
//  char _isOkay_1();
//  int   bob(),marley();
  
  
// SAMPLES THAT SHOULD NOT WORK
  
//  int    square (int), ssds;
// char toLowser (char,);
// char toLowser (char,  ,  , );
// char toLowser (char,,  );
// char toLowser (char,s);
// squareint (int k, int   )   , circle(int    radius),box(  int), cake(int,int)  ;
// lcm(int factor,int factor);
//  int gcd(int,int), gcd(int,int);
// int kek((char));
//  Int kek();
//  ints kek(,);
//  int dingo(ints);
//  int snake(int());
//  int space burrito();
//  char bag(int bag)int pupper; ( no comma and having int again)
//  int int keepo(int int);
//  void faceless(hello);
//  void chicken(int void);
//  void chicken;(int; vo;d);
//  int gre(en)(int chicken);
//  char (jail);
//  char (in t jail);
//  char astronaut)char x(;
//  int what(int(int));
//  char where(int));
//  char nobody;

  
// for(char xd : codestring){
//   System.out.print(xd);
// }  
  
//  PROCEDURE
//   1. USE .TRIM() TO REMOVE LEADING AND TRAILING WHITESPACES
//  
//   2. CHECK IF RETURN TYPE IS VALID (X use startswith ?) (X THEN MAYBE SPLIT THE STRING?,
//                                     after split, use is empty, add to another str array if false?)                                                                                     )
//     
//     2.1 THERE SHOULD BE A SPACE BETWEEN RETURN TYPE AND FUNC NAME, if char is not space return false, otherwise trim x nope
//     
//   3. // DONT MID THIS SHIfT, REDUNDANT  CHECK AGAIN THAT THE FUNCTION NAME IS NOT A PRIMITIVE DATA TYPE
  
//   create arraylist of func names, empty for now
//    4. loop ( while ( idk condition yet)  maybe while(true) or while(stringIndex != str.length()?
//            
//            4.1 get funcname, check if its ok
//                   ok checklist:
//                      1. not a data type
//                      2. not already declared
//                      3. starts with letter or '_', only alphanumeric characters
//                if ok, add to arraylist of func names, 
//             
//                create array list of its arguements
//             
//               if followed by space, if it is
//                      1.traverse by loop and adjust string index accordingly until it finds a character not space
//                        check what character is, return false if not (
//                                                                      
//            4.2 get arguements,check if they are ok
//                   if followed by space, if it is
//                      1.traverse by loop and adjust string index accordingly until it finds a character not space
//                        check if its a data type or closing parenthesis, return false if not
//                                                                        
//                                                                        
//                    if followed by space, if it is
//                      1.traverse by loop and adjust string index accordingly until it finds a character not space
//                        return false if datatype. return false if data type was void and character isnt ')' or ','
  //                                ACTUALLY VOID CAN HAVE A NAME WTF BUT IF VOID THEN ONLY THAT SHOULD BE ARGUEMENT
//                                                                        
//                    get parameter name, check if already in arraylist, if found return false, else add to arraylist
//                                                                        
//                    if followed by space, if it is
//                      1.traverse by loop and adjust string index accordingly until it finds a character not space
//                        return false if character isnt ')' or ','
//                                                                        
//                  if character is ',' 
//                                                                        
//                    back to 4.2 but it should return false if it finds ')' after ','
//                  
//                  if character is ')'
//                    
//                     check for space and comma and semi colon, if comma back to 4.1, if semi colon return true
                                                   
                                                                        
                                                                        
// RULES
//  A DATATYPE CAN ONLY BE FOLLOWED BY A SPACE, A COMMA OR A CLOSING PARENTHESIS ')'
//  AN OPENING PARENTHESIS CAN ONLY BE FOLLOWED BY A SPACE OR A DATATYPE OR A CLOSING PARENTHESIS;
//  A CLOSING PARENTHESIS CAN ONLY BE FOLLOWED BY A COMMA OR A SEMICOLON OR A SPACEBAR
// A COMMA CAN ONLY BE FOLLOWED BY A SPACE, A DATA TYPE, OR A FUNCTION NAME
  
  public static boolean isValidFuncDec(String bob ){
  
    stringIndex = 0;
    voidFlag = false;
    functionNames.clear();
    bob = bob.trim();
    //System.out.print(bob);
   
    boolean continueFlag = true;
    
    continueFlag = isDataType(bob, stringIndex, 1);
    
    if(!continueFlag)
      return false;
    
    // at this point return type is valid
    
    while(true){
     
      String funcName;
      
     
      chewSpace(bob);      
      
      continueFlag = hasOpeningParenthesis(bob);
    
      if(!continueFlag)
        return false;
      
      funcName = getFuncName(bob);
      
      continueFlag = isValidFuncName(funcName);
      
        
      if(!continueFlag)
        return false;
      
     //  System.out.println(funcName);
      
      functionNames.add(funcName);
      
      stringIndex += funcName.length();
 
      chewSpace(bob);

      stringIndex++;
      
      chewSpace(bob);

      // at this point function name is valid, and stringIndex points to first character after (
      
      String parameters;
      
      ArrayList<String> parameterList = new ArrayList<String>();
      
      continueFlag = hasClosingParenthesis(bob);
    
      if(!continueFlag)
        return false;
 
      parameters = getParameters(bob);
      
      // need to find a way to catch double ,, or , , etc before splitting
      
      continueFlag = hasNoDoubleComma(parameters);
    
      if(!continueFlag)
        return false;
      
      //////
      
      int parameterCount = 0;
      
      for (String parameter: parameters.split(",")) {
         
         parameter = parameter.trim();

         
         continueFlag = isValidParameters(parameter);
         
         parameterCount++;

         if(voidFlag && parameterCount > 1)
           return false;
         
         if(!continueFlag)
           return false;
         
         if(parameter.contains(" ")){
          String paramName = getParameterName(parameter);
          if(parameterList.contains(paramName))
               return false;
           parameterList.add(paramName);
         }
      }
      
      //System.out.println(parameters);
      
      stringIndex += parameters.length();

      chewSpace(bob);
 
      // at this point stringIndex points to (
      
      if(stringIndex!=bob.length()-1)
       stringIndex++;
      chewSpace(bob);
      

      
      // at this point stringIndex should point to next character after '(', expects comma or semicolon
      if(bob.charAt(stringIndex) == ';' || bob.charAt(stringIndex) == '{' )
        return true;
      
      else if(bob.charAt(stringIndex) != ','){ 
        stringIndex = 0;
        return false;
      }
      stringIndex++;

    }
  }
  
  //CHECKS if int, char, double, float or void, then moves stringIndex to index after type
  
  //TODO - maybe add another parameter to what to check
  
  static boolean isDataType(String codeString, int index, int mode){
    
    if(mode == 1){
      
      
      if( codeString.indexOf("int ", index) == index){
        stringIndex += 4;
        return true;
      }

      if( codeString.indexOf("char ", index) == index){
        stringIndex += 5;
        return true;
      }

      if( codeString.indexOf("void ", index) == index){
        stringIndex += 5;
        return true;    
      }

      if( codeString.indexOf("float ", index) == index){
        stringIndex += 6;
        return true;    
      }

      if( codeString.indexOf("double ", index) == index){
        stringIndex += 7;
        return true;  
      }
    }
    
    else if(mode == 2){
            
      return   (codeString.equals("int")
             || codeString.equals("char")
             || codeString.equals("double")
             || codeString.equals("float")
             || codeString.equals("void")
                );

    }
    
    else if(mode == 3){
      
     if(codeString.isEmpty())
       return true;
      
     if        (codeString.equals("int")
             || codeString.equals("char")
             || codeString.equals("double")
             || codeString.equals("float")
                )
      
      return true;
     
     if(codeString.equals("void")){
         voidFlag = true;
         return true;
     }
     
     if(  codeString.startsWith("int ")
       || codeString.startsWith("char ")
       || codeString.startsWith("double ")
       || codeString.startsWith("float "))
     {
       
       
       String name = getParameterName(codeString);
       
      // System.out.println(name);
       
       if( isDataType(name, 0, 2))
      return false;
    
    char[] param = name.toCharArray();

    for (char c : param) {
        if(!Character.isLetterOrDigit(c) && c != '_')
        {
            return false;
        }
    }
    
    if(Character.isDigit(param[0]))
         return false;
      
     return true;
     } 
     
     if(codeString.startsWith("void ")){
       voidFlag = true;
      String name = getParameterName(codeString);
       
      // System.out.println(name);
       
       if( isDataType(name, 0, 2))
      return false;
    
    char[] param = name.toCharArray();

    for (char c : param) {
        if(!Character.isLetterOrDigit(c) && c != '_')
        {
            return false;
        }
    }
    
    if(Character.isDigit(param[0]))
         return false;
      
     return true;
     
     }
    
    }
    return false;
  }
  
  
  static void chewSpace(String s){
  
    while(s.charAt(stringIndex) == ' '){
      stringIndex++;
    }
  }
  
  static boolean hasOpeningParenthesis(String codeString){
  
    int firstOccurence = codeString.indexOf('(', stringIndex);
  
    if(firstOccurence == -1)
      return false;
  
    return true;  
  }
  
  
  static boolean hasClosingParenthesis(String codeString){
  
    int firstOccurence = codeString.indexOf(')', stringIndex);
  
    if(firstOccurence == -1)
      return false;
  
    return true;  
  }  
  
  static boolean hasNoDoubleComma(String codeString){
      
    if(codeString.length() == 1)
      return false;
    if(codeString.endsWith(",") || codeString.startsWith(","))
      return false;
    int index = codeString.indexOf(',');
  
    if(index == -1)
      return true;
    
    while(index != codeString.length()-1){
      if(codeString.charAt(index+1) == ',')
        return false;
      else if(codeString.charAt(index+1) == ' ')
        index++;
      else{
        index = codeString.indexOf(',', index+1);
        if(index == -1)
          return true;
      }
        
    }
    return true;
  }
  
  static String getFuncName(String codeString){
  
    int firstOccurence = codeString.indexOf('(', stringIndex);
  
    String funcName = codeString.substring(stringIndex, firstOccurence);
  
  
    return funcName.trim();  
  }
  
  
  static String getParameterName(String codeString){
  
    int firstOccurence = codeString.indexOf(' ', 0);
    
    String name = codeString.substring(firstOccurence, codeString.length());
    
  
    return name.trim();  
  }
  
  
  static boolean isValidFuncName(String codeString){
    
    if( isDataType(codeString, 0, 2))
      return false;
    
    if(functionNames.contains(codeString))
      return false;
    
    char[] func = codeString.toCharArray();

    for (char c : func) {
        if(!Character.isLetterOrDigit(c) && c != '_')
        {
            return false;
        }
    }
    
    if(Character.isDigit(func[0]))
         return false;
      
    return true;
  }

    static boolean isValidParameters(String codeString){
      
      if(!isDataType(codeString, 0 , 3))
           return false;
         
         
      return true;
  }
  
  static String getParameters(String codeString){
  
    int firstOccurence = codeString.indexOf(')', stringIndex);
  
    String parameters = codeString.substring(stringIndex, firstOccurence);
  
  
    return parameters.trim();  
  }
}
