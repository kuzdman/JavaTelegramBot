package ru.oopteam.bot.readers;

public class Request {

    private final String message;

    public Request(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
