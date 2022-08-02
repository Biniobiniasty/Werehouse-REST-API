package com.example.demoTDO.Exception;

public class NoFoundException extends RuntimeException{

    public NoFoundException(int id) {

        super("Cos tu jest nie tak co to jest hm [" + id + "]");

    }

}
