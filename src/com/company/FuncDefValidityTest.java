package com.company;

import junit.framework.TestCase;

public class FuncDefValidityTest extends TestCase {
    public void testIsValidFuncDef() throws Exception {
        assertEquals(1,1);
    }

    public void testIsValidVarName() throws Exception {
        assertEquals(true,FuncDefValidity.isValidVarName("shougun"));
        assertEquals(true,FuncDefValidity.isValidVarName("boi"));
        assertEquals(true,FuncDefValidity.isValidVarName("_int"));
        assertEquals(true,FuncDefValidity.isValidVarName("for12"));
        assertEquals(false,FuncDefValidity.isValidVarName("12man"));
        assertEquals(true,FuncDefValidity.isValidVarName("_"));
        assertEquals(false,FuncDefValidity.isValidVarName("go0dbo&"));
        assertEquals(false,FuncDefValidity.isValidVarName("int"));
        assertEquals(false,FuncDefValidity.isValidVarName("float"));
        assertEquals(false,FuncDefValidity.isValidVarName("void"));

    }

    public void testIsValidFnHead() throws Exception {
        assertEquals(true,FuncDefValidity.isValidFnHead("int j(int x){"));
        assertEquals(true,FuncDefValidity.isValidFnHead("void j(int x, float y, double k, int ll_){"));
        assertEquals(true,FuncDefValidity.isValidFnHead("int j(int x, int y){"));
        assertEquals(true,FuncDefValidity.isValidFnHead("int j(int x, float y){"));
        assertEquals(true,FuncDefValidity.isValidFnHead("float j(double x, int k){"));
        assertEquals(false,FuncDefValidity.isValidFnHead("int j(int k, int k){"));
        assertEquals(false,FuncDefValidity.isValidFnHead("int j(inty x){"));
        assertEquals(false,FuncDefValidity.isValidFnHead("inty j(int x=){"));
        assertEquals(false,FuncDefValidity.isValidFnHead("int j(int x, int =x){"));
        assertEquals(false,FuncDefValidity.isValidFnHead("int j(int x, int 12){"));
        assertEquals(false,FuncDefValidity.isValidFnHead("int j(int x, int 12a){"));
        assertEquals(false,FuncDefValidity.isValidFnHead("intj(intx,intA){"));
        assertEquals(false,FuncDefValidity.isValidFnHead("intj (intx,intA){"));
        assertEquals(false,FuncDefValidity.isValidFnHead("int j(float x,void A)        {"));

    }

    public void testIsValidDataType() throws Exception {
        assertEquals(true, FuncDefValidity.isValidDataType("int"));
        assertEquals(true, FuncDefValidity.isValidDataType("float"));
        assertEquals(true, FuncDefValidity.isValidDataType("char"));
        assertEquals(true, FuncDefValidity.isValidDataType("double"));
        assertEquals(false, FuncDefValidity.isValidDataType("void"));
    }

}