package ru.oopteam.bot.handlers;

import ru.oopteam.bot.readers.Request;
import ru.oopteam.bot.writers.Response;

import java.util.HashMap;

import static ru.oopteam.bot.parsing.GettingCurrency.getCurrency;

public class SimpleHandler implements Handler {

    public Response handle(Request request) {
        if (request.getUserID() == null) {
            String requestText = request.getMessage();
            System.out.println("QWerty");
            return new Response(requestText);

        }
        String message = request.getMessage();
        try {
            HashMap<String, String> currencyDictionary = getCurrency();
            assert currencyDictionary != null;
            message = currencyDictionary.get(request.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return new Response(message,request.getUserID());
    }
}
