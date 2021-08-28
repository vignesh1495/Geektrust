package com.onlinemarketmaker.exceptions;

public class NoFileFoundException extends Exception {

    @Override
    public String toString() {
        return "No such File Found!";
    }
}