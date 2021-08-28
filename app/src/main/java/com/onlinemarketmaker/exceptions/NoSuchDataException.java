package com.onlinemarketmaker.exceptions;

public class NoSuchDataException extends Exception {
    @Override
    public String toString() {
        return "No such Data Found!";
    }
}
