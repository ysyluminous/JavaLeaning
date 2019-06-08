package com.itheima.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

/************************************************************************
 *
 * Filename:	
 *
 * Describe: 
 *
 * @author Yao Siyuan on 1/12/2017.
 *
 * Summary:	
 *
 * @version 0.1
 *
 * Record:
 *			0.1:
 *
 ************************************************************************/
public class UsersException extends Exception{

    private final String msg;

    public UsersException(String msg){
        super(msg);
        this.msg = msg;
    }

    @Override
    public String getMessage() {

        return super.getMessage();
    }

    @Override
    public String getLocalizedMessage() {
        return super.getLocalizedMessage();
    }

    @Override
    public synchronized Throwable getCause() {
        return super.getCause();
    }

    @Override
    public synchronized Throwable initCause(Throwable cause) {
        return super.initCause(cause);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }

    @Override
    public void printStackTrace(PrintStream s) {
        super.printStackTrace(s);
    }

    @Override
    public void printStackTrace(PrintWriter s) {
        super.printStackTrace(s);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return super.fillInStackTrace();
    }

    @Override
    public StackTraceElement[] getStackTrace() {
        return super.getStackTrace();
    }

    @Override
    public void setStackTrace(StackTraceElement[] stackTrace) {
        super.setStackTrace(stackTrace);
    }
}
