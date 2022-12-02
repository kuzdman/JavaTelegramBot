package ru.oopteam.bot.tgbot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.oopteam.bot.writers.Response;
import ru.oopteam.bot.writers.Writer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Bot extends TelegramLongPollingBot implements Writer {
    @Override
    public void onUpdateReceived(Update update) {
        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
            message.setChatId(update.getMessage().getChatId().toString());
            message.setText(update.getMessage().getText());

            try {
                execute(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "CryptoTracker";
    }

    @Override
    public String getBotToken() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("scr/main/resources/config.properties"));
            return properties.getProperty("token");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void write(Response response) {

    }
}
