package com.dmeritano.parser.exceptions;

public class ParameterException extends Exception{
    public ParameterException(String message){
        super("Parameter Error -> " + message);
    }
}
