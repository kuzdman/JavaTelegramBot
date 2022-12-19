package ru.oopteam.bot.handlers;

import ru.oopteam.bot.readers.Request;
import ru.oopteam.bot.writers.Response;

import java.util.HashMap;
import java.util.Objects;

import static ru.oopteam.bot.parsing.GettingCurrency.getCurrency;

public class SimpleHandler implements Handler {

    public Response handle(Request request) {
        if (request.getUserID() == null) {
            String requestText = request.getMessage();
            return new Response(requestText);
        }

        StringBuilder message = new StringBuilder(request.getMessage());

        try {
            HashMap<String, String> currencyDictionary = getCurrency();
            assert currencyDictionary != null;

            if (Objects.equals(message.toString(), "all")) {
                message = new StringBuilder();
                for (HashMap.Entry<String, String> item : currencyDictionary.entrySet()){
                    message.append(item.getKey());
                    message.append("  ");
                    message.append(item.getValue());
                    message.append(" \n");
                }
            } else {
                message = new StringBuilder(currencyDictionary.getOrDefault(request.getMessage(), "Не удалось получить заданную валюту"));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return new Response(message.toString(),request.getUserID());
    }
}
