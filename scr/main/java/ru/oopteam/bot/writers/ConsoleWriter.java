package ru.oopteam.bot.writers;

import ru.oopteam.bot.writers.*;

public class ConsoleWriter implements Writer
{

    @Override
    public void write(Response response) {
        System.out.println(response.getMessage());
    }
}
