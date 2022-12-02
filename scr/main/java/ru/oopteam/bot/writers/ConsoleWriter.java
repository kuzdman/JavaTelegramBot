package ru.oopteam.bot.writers;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.oopteam.bot.writers.*;

public class ConsoleWriter implements Writer
{

    @Override
    public void write(Response response) {
        System.out.println(response.getMessage());
    }

    @Override
    public void onUpdateReceived(Update update) {

    }
}
