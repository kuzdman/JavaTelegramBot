package ru.oopteam.bot.tgbot;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.oopteam.bot.readers.Request;
import ru.oopteam.bot.writers.Response;

public class Converter {

    public Request convertUpdateToRequest(Update update) {
        String message = update.getMessage().getText();
        Long userID = update.getMessage().getFrom().getId();
        return new Request(message, userID);
    }

    public BotApiMethod<?> convertResponseToMethod(Response response) {
        return SendMessage.builder()
                .chatId(response.getUserID().toString())
                .text(response.getAnswer())
                .build();
    }

}
