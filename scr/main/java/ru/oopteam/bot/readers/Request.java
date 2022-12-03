package ru.oopteam.bot.readers;

public class Request {

    private final String message;
    private final Long userID;

    public Request(String message, Long userID){
        this.message = message;
        this.userID = userID;
    }

    public String getMessage(){
        return message;
    }

    public Long getUserID() {
        return this.userID;
    }
}
