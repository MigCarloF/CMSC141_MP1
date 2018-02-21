package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class FuncDefValidity {

    private static ArrayList<String> varNames = new ArrayList<>();

    public FuncDefValidity() {}

    public static boolean isValidFuncDef(String line) {
        varNames.clear();
        StringTokenizer tok = new StringTokenizer(line,"{", true);

        String string = tok.nextToken();
        string = string.concat(tok.nextToken());

        ArrayList variableNames = new ArrayList();

        if(!isValidFnHead(string)){
            return false;
        }

        string = tok.nextToken(";}");
        if(string.equals("}")){}//todo
        String token = tok.nextToken();


        //if(!VarDecValidity)

        return true;
    }


    public static boolean isValidFnHead(String line) {

        if(!FuncDecValidity.isValidFuncDec(line)){ //covers a lot of cases
            return false;
        }

        StringTokenizer tok = new StringTokenizer(line, "{ ", true);

        //get func return data type
        //int y (int x, int y){
        String string = tok.nextToken();//"int"
        String token = tok.nextToken();// " "
        string = trimEdges(string);

        if(token.equals("{")){
            return false;
        }

        boolean valid = isValidDataType(string) || string.equals("void");

        if (!valid){
            return false;
        }

        //get var name
        string = tok.nextToken("({");// "y "
        token = tok.nextToken("({");//"("
        string = trimEdges(string);//"y"

        if(!isValidVarName(string)){
            return false;
        }

        varNames.add(string);

        if(token.equals("{")){
            return false;
        }

        int state = 1;


        //int y (int x, int z) {
        //        1  2  1  23
        // "," -> go to case 1
        // ")" -> go to case 3
        //
        boolean breakLoop = false;
        while(true) {
            switch (state){
                case 1:
                    //for case (    int y) {
                    string = trimEdges(tok.nextToken("{").concat(tok.nextToken())); //int x, int y) {
                    tok = new StringTokenizer(string, "{ ", true); // int x){

                    string = tok.nextToken("{ ");
                    valid = isValidDataType(string); //tok.nextToken() = "int"
                    token = tok.nextToken();// " "
                    if(token.equals("{")){
                        return false;
                    }
                    if(!valid){
                        return false;
                    }
                    state++;
                    break;
                case 2:
                    string = tok.nextToken("{),");
                    token = tok.nextToken();
                    if(token.equals("{") ) {
                        return false;
                    }

                    if(!isValidVarName(string)){
                        return false;
                    }

                    varNames.add(string);
                    if(token.equals(",")) {
                        state=1;
                    } else if (token.equals(")")) {
                        state = 3;
                    } else {
                        System.out.println("How'd you get here? @isValidFnHead state 3");
                    }
                    break;
                case 3:
                    string = tok.nextToken("{");
                    if(string.equals("{")){ // if ){
                        breakLoop = true;
                    } else { //if ) {
                        token = tok.nextToken();
                        string = string.concat(token);
                        string = trimEdges(string);
                        if(string.charAt(0) == '{'){ // checks for ") wlfae{"
                            breakLoop = true; //true if ")        {"
                        } else {
                            return false;
                        }
                    }
                    break;
                default:
                    System.out.println("How'd you get here? @FuncDefValidity.isValidFnHead switchcase default");
            }
            if(breakLoop){
                break;
            }
        }

        return true;
    }

    private static String trimEdges(String string) {
        string = deleteFirstSpace(string);
        return deleteFinalSpaces(string);

    }

    public static String deleteFinalSpaces(String line) {
        String newLine;
        int i;

        for(i = line.length()-1; i >= 0; i--) {
            if (line.charAt(i) != ' ') {
                break;
            }
        }
        newLine = line.substring(0, ++i);

        return newLine;
    }
    //deletes initial space "       hi  " to "hi  "
    @SuppressWarnings("Duplicates")
    public static String deleteFirstSpace(String line) {
        String newLine;
        int i;

        if (line.charAt(0) != ' ') {
            return line;
        }

        for (i = 0; i < line.length(); i++) {
            if (line.charAt(i) != ' ') {
                break;
            }

        }
        newLine = line.substring(i);
        return newLine;
    }

    public static boolean isValidVarName(String string){
        boolean valid = false;

        if(isValidDataType(string) || string.equals("void")){
            return false;
        }
        for(int i = 0; i < string.length(); i++){
            if(i == 0){
                valid = (string.charAt(0) >= 'a' && string.charAt(0) <= 'z') || (string.charAt(0) >= 'A' && string.charAt(0) <= 'Z') || string.charAt(0) == '_';
            }else if(string.charAt(i) < '0'){
                return false;
            }else if(string.charAt(i) > '9' && string.charAt(i) < 'A'){
               return false;
            }else if(string.charAt(i) > 'Z' && string.charAt(i) < '_') {
                return false;
            }else if(string.charAt(i) > '_' && string.charAt(i) < 'a'){
                return false;
            }else if(string.charAt(i) > 'z'){
                return false;
            }

        }
        return valid;
    }

    public static boolean isValidDataType(String type){
        switch (type){
            case "int":
            case "float":
            case "char":
            case "double":
                return true;
            default:
                return false;
        }
    }
    private ArrayList<String> gatherVarNameHead(String line){
        ArrayList<String> list = new ArrayList<String>();

        String string;
        return null;
    }
}
