package ru.oopteam.bot.tgbot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.oopteam.bot.handlers.Handler;
import ru.oopteam.bot.handlers.SimpleHandler;
import ru.oopteam.bot.readers.Request;
import ru.oopteam.bot.writers.Response;
import ru.oopteam.bot.writers.Writer;


public class Bot extends TelegramLongPollingBot implements Writer {

    private final String botName;
    private final String token;
    private final SimpleHandler handler;
    private final Converter converter;

    public Bot(String botName, String token) {
        this.botName = botName;
        this.token = token;
        handler = new SimpleHandler();
        converter = new Converter();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Request request = converter.convertUpdateToRequest(update);
            Response response = handler.handle(request);
            write(response);
        }
    }


    @Override
    public String getBotUsername() {
        return this.botName;
    }

    @Override
    public String getBotToken() {
        return this.token;
    }

    @Override
    public void write(Response response) {
        BotApiMethod<?> sm = converter.convertResponseToMethod(response);
        try {
            execute(sm);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
