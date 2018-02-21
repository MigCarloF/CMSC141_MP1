package com.company;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CodeProper {

    FileReadWrite frw;


    public CodeProper() {
        run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        String fileName;
        String allLines = "";
        frw = new FileReadWrite();
        frw.eraseOutput();
        boolean exit = false;
        boolean isDef;

        while (true) {
            System.out.print("Input filename and extension (type exit to exit): ");
            fileName = sc.nextLine();

            if (fileName.equals("exit")) {
                exit = true;
                break;
            }

            try {
                frw.openFile(fileName);
                break;
            } catch (IOException e) {
                System.out.println("File does not exist");
            }
        }

        if (!exit && !(frw == null)) {

            //phase 1 collect number of test cases
            int testCases = collectNumber();
            if (testCases < 0) {
                System.out.println("Invalid Case Numbers");
            } else if (testCases == 0) {
                System.out.println("Lol thanks sir no cases to check");
            } else {
                //enter this case if testCases > 0

                //concats all lines to allLines variable
                while (frw.hasNext()) {
                    allLines = allLines.concat(frw.readFile());
                    if(!(allLines.charAt(allLines.length()-1) == ';')){
                        allLines = allLines + " ";
                    }
                }

                //trims the final space of allLines to avoid an exception
                allLines = deleteFinalSpaces(allLines);

                StringTokenizer tok = new StringTokenizer(allLines, ";{", true);
                if (tok.countTokens() == 0) {
                    System.out.println("put tokens pls");
                }

                //main loop
                while (tok.hasMoreTokens() && testCases > 0) {

                    isDef = false;

                    testCases--;
                    String currentLine = tok.nextToken(";{");
                    if(currentLine.equals(" ")){
                        break;
                    } else if (currentLine.equals(";") || currentLine.equals("{")){
                        frw.writeToFile("YOU CANT DO THAT");
                        System.out.println("YOU CANT DO THAT");
                        break;
                    }
                    currentLine = deleteFirstSpace(currentLine);

                    //concats the delimiter if split by delimiter and not end of string
                    if (tok.hasMoreTokens()) {
                        String nextTok = tok.nextToken();
                        currentLine = currentLine.concat(nextTok);

                        if (nextTok.equals("{")) { //for definition continuation of closing curly
                            isDef = true;
                            if (tok.hasMoreTokens()) {
                                currentLine = currentLine.concat(tok.nextToken("}")); //concats until }
                                currentLine = currentLine.concat(tok.nextToken("}")); //concats the delimiter
                            }
                        }

                    }
                    System.out.println(currentLine);

                    if (isDef) {
                        if (isValidFuncDef(currentLine)) {
                            frw.writeToFile("VALID FUNC DEF");
                            System.out.println("VALID FUNC DEF");
                        } else {
                            frw.writeToFile("INVALID FUNC DEF");
                            System.out.println("INVALID FUNC DEF");
                        }
                    } else if (isFuncDec(currentLine)) {
                        if (FuncDecValidity.isValidFuncDec(currentLine)) {
                            frw.writeToFile("VALID FUNC DEC");
                            System.out.println("VALID FUNC DEC");
                        } else {
                            frw.writeToFile("INVALID FUNC DEC");
                            System.out.println("INVALID FUNC DEC");
                        }
                    } else {
                        if (VarDecValidity.isValidVarDec(currentLine)) {
                            frw.writeToFile("VALID VAR DEC");
                            System.out.println("VALID VAR DEC");
                        } else {
                            frw.writeToFile("INVALID VAR DEC");
                            System.out.println("INVALID VAR DEC");
                        }
                    }

                    System.out.println("");
                }

            }
        } else {
            System.out.println("Thanks!");
        }

    }

    private boolean isValidFuncDef(String currentLine) {
        return new Random().nextBoolean();
    }

    private boolean isValidFuncDec(String currentLine) {
        return new Random().nextBoolean();
    }

    private boolean isValidVarDec(String currentLine) {
        return new Random().nextBoolean();
    }

    //deletes initial space "       hi  " to "hi  "
    @SuppressWarnings("Duplicates")
    public String deleteFirstSpace(String line) {
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

    public String deleteFinalSpaces(String line) {
        String newLine;
        int i;


        for(i = line.length()-1; i >= 0; i--) {
            if (line.charAt(i) == ';' || line.charAt(i) == '}') {
                break;
            }
        }
        newLine = line.substring(0, ++i);

        return newLine;
    }

    private int collectNumber() { //returns -1 if line is not a number
        String num = frw.readFile();
        try {
            return Integer.parseInt(String.valueOf(num));
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private boolean isFuncDec(String line) {

        StringTokenizer tokzr = new StringTokenizer(line, "; ", true);
        String string = tokzr.nextToken();
        String token = tokzr.nextToken();
        //checks if what was sent was one whole string until ;
        if (token.equals(";")) {
            return false;
        }

        string = tokzr.nextToken(";");
        string = string.concat(tokzr.nextToken());

        //for testcase 'int ((x)) = 4;
        int parCount = 0;
        boolean countPar = false;

        if (string.charAt(0) == '(') {
            parCount++;
            countPar = true;
        }

        for (int i = 0; i < string.length(); i++) {
            if (countPar) {
                if (parCount == 0) {
                    countPar = false;
                } else if (string.charAt(i) == '(' && i != 0) {
                    parCount++;
                } else if (string.charAt(i) == ')') {
                    parCount--;
                } else if (string.charAt(i) == ';') {
                    return false;
                }
            }
            if (!countPar) {
                if (string.charAt(i) == ';') {
                    return false;
                } else if (string.charAt(i) == '=') { //returns false when = appears first
                    return false;
                } else if (string.charAt(i) == '(') {
                    return true;
                }
            }
        }
        return false;
    }

}
