package ru.oopteam.bot.writers;

public class Response {
    private final String message;


    public Response(String text) {
        message = text;
    }


    public String getMessage() {
        return message;
    }
}
