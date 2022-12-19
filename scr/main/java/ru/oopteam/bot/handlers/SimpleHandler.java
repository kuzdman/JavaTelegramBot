package ru.oopteam.bot.handlers;

import ru.oopteam.bot.readers.Request;
import ru.oopteam.bot.writers.Response;

public class SimpleHandler implements Handler {

    public Response handle(Request request) {
        if (request.getUserID() == null) {
            String requestText = request.getMessage();
            return new Response(requestText);
        }
        return new Response(request.getMessage(), request.getUserID());
    }
}
