package com.company;


import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileReadWrite {

    private Scanner fileLines;
    private static String outputName = "MP1.out";

    /** Core Functions
     *   void openFile(String fileName) -- opens a new file in the scanner
     *   String readFile() -- reads file returns string line by line. Returns "no line" if no more lines and returns "File does not exist" if file does not exist
     *   void writeToFile(String) -- writes file to output at outputName
     *   boolean hasNext() -- checks if there is another line
     *   void eraseOutput() -- erases output at outputName
     *   void close() -- closes scanner
     */

    /**
     * all reading here
     */

    public FileReadWrite(){
        fileLines = null;
    }

    public void close() {
        fileLines.close();
    }

    public String readFile() {
        if(fileLines.equals(null)){
            return "Input filename does not exist";
        }
        return fileLines.hasNext() ? fileLines.nextLine() : "No more lines";
    }

    public void openFile(String fileName) throws IOException {//returns file in scanner
        File file = new File(fileName);
        fileLines = new Scanner(file);
    }

    public boolean hasNext(){
        return fileLines.hasNext();
    }


    /**
     * all writing here\
     */

    public void writeToFile (String text) {
        File output = new File(outputName);

        FileWriter writer;

        try {
            writer = new FileWriter(output, true);
            BufferedWriter bw = new BufferedWriter(writer);
            PrintWriter out = new PrintWriter(bw);
            out.println(text);
            bw.close();
        } catch (IOException e) {
            System.out.println("Error in writeFile");
        }
    }

    public void eraseOutput() {
        //difference with writeToFile is that this doesn't append
        //sets output text to ""
        File output = new File(outputName);

        FileWriter writer;

        try {
            writer = new FileWriter(output, false);
            BufferedWriter bw = new BufferedWriter(writer);
            PrintWriter out = new PrintWriter(bw);
            out.println("");
            bw.close();
        } catch (IOException e) {
            System.out.println("Error in writeFile");
        }
    }

}