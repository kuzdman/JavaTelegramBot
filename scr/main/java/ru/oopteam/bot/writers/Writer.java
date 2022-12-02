package ru.oopteam.bot.writers;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface Writer
{
    void write(Response response);

    void onUpdateReceived(Update update);
}
