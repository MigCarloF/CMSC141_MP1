package com.company;

import java.io.*;
import java.util.Scanner;

public class CaseSplitter {

    private String fileName;

    public CaseSplitter(String filename){
        this.fileName = filename;
    }

    public Scanner openFile() {//returns file in scanner
        Scanner x = null;
        File file = new File(fileName);

        if(file.exists()) { //this if statement erases previous data
            PrintWriter writer = null;
            try {
                writer = new PrintWriter(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            writer.print("");
            writer.close();
        }

        try {
            x = new Scanner(file);

        } catch (IOException e) {
            System.out.println("Error in: openFile 'No file found'");
        }
        return x;
    }
    
    public void readFile(Scanner x) {
        String line = x.nextLine();
        boolean error = false;
        int cases;
        try{
            cases = Integer.parseInt(line);
        } catch (NullPointerException e1) {
            writeToFile("No data!");
            error = true;
        } catch (NumberFormatException e) {
            writeToFile("Invalid input! State number of cases in integers");
            error = true;
        } catch (Exception e) {
            System.out.println("General Exception in readFile");
        }

        while(x.hasNext() && !error){

        }

        x.close();
    }

    private void writeToFile (String text) {
        File output = new File(fileName);

        FileWriter writer;

        try {
            writer = new FileWriter(output, true);
            BufferedWriter bw = new BufferedWriter(writer);
            PrintWriter out = new PrintWriter(bw);
            out.println(text);
        } catch (IOException e) {
            System.out.println("Error in writeFile");
        }
    }
}