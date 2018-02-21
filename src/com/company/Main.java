package com.company;

import com.sun.org.apache.bcel.internal.classfile.Code;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        new CodeProper();

        FuncDefValidity.isValidDataType("int");
    }

    private static void test() {
        char c = ';';
        System.out.println(c == 'd' ? "TRUE" : "FALSE");

    }
}
    