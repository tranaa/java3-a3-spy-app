package com.tranaa.aaron_vinayak_a3.filters;

import java.io.CharArrayWriter;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * Wrapper class, taken from class material
 * @author paulbonenfant
 */
public class MyWrapper extends HttpServletResponseWrapper {
    
    CharArrayWriter caw = new CharArrayWriter();
    PrintWriter writer = new PrintWriter(caw);
    
    public MyWrapper(HttpServletResponse response) {
        super(response);
    }

    @Override
    public PrintWriter getWriter()  {
        return writer;
    }

    @Override
    public String toString() {
        return caw.toString();
    }    
    
}
