package ru.oopteam.bot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.oopteam.bot.tgbot.Bot;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {

        InitializationManager.initialize("ru.oopteam.bot");

        Properties properties = new Properties();

        try {
            URL resource = Main.class.getResource("/config.properties");
            properties.load(new FileInputStream(new File(resource.toURI())));
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new Bot(properties.getProperty("botName"), properties.getProperty("token")));
        } catch (IOException | URISyntaxException | TelegramApiException e) {
            throw new RuntimeException(e);
        } catch (NullPointerException e) {
            System.err.println("Файл конфигураций не найден");
            throw new RuntimeException(e);
        }
    }
}
