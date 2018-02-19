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
        frw = new FileReadWrite();
        boolean exit = false;

        while(true) {
            System.out.print("Input filename and extension (type exit to exit): ");
            String fileName = sc.nextLine();

            if(fileName.equals("exit")){
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

        if (exit == false){

            //phase 1 collect number of test cases
            int testCases = collectNumber();
            if (testCases < 0) {

            } else if (testCases == 0) {

            } else {
                //VALID FIRST LINE TODO put code here
                String caseType = identifyCase();

                StringTokenizer tok = new StringTokenizer(line, ";{");

                if(caseType == "definition") {
                    System.out.println("DEFINITION!");
                } else if (caseType == "declaration") {
                    System.out.println("DECLARATION");
                    if(isFuncDec()){

                    } else if (isVarDec()) {

                    }

                } else {
                    //TODO What does this do?
                    System.out.println("WHATYOU!?");
                }
                System.out.println(line);
            }
        } else {
            System.out.println("Thanks!");
        }

    }

    private String identifyCase() {
        //phase 2 gather string lines until string contains { } or ;
        //concats per file read
        boolean definition = false;
        boolean declaration = false;
        boolean skipToCurly = false;

        String line = "";
        int i = 0;
        while(true && frw.hasNext()) {
            definition = false;
            declaration = false;

            line = line.concat(frw.readFile());

            for(  ; i < line.length(); i++) { //for loop checks if first case is ; or {
                if(skipToCurly == false && line.charAt(i) == ';'){
                    declaration = true;
                    break;
                } else if (skipToCurly == false && line.charAt(i) == '{'){

                    if(line.contains("}")){ //line must contain } if it opens up with { to be a valid definition
                        break;
                    }
                    definition = true;
                    skipToCurly = true;

                } else if (skipToCurly == true && line.contains("}")) {
                    definition = true;
                    break;
                }
            }
        }

        if(declaration) {
            return "declaration";
        }
        else if (definition) {
            return "definition";
        }
        else {
            return "other";
        }
    }
    private int collectNumber() { //returns -1 if line is not a number
        String num = frw.readFile();
        try {
            return Integer.parseInt(String.valueOf(num));
        } catch (NumberFormatException e) {
            return -1;
        }
     }

    private boolean isFuncDec() {
        //TODO delete this after combining
        Random rand = new Random();
        return rand.nextBoolean();
    }

    private boolean isVarDec() {
        //TODO delete this after combining
        Random rand = new Random();
        return rand.nextBoolean();
    }

}
