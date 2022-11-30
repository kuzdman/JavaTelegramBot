package ru.oopteam.bot.handlers;

import ru.oopteam.bot.readers.Request;
import ru.oopteam.bot.writers.Response;

public class SimpleHandler implements Handler {
    @Override
    public Response handle(Request request) {
        return new Response(request.getMessage());
    }
}
