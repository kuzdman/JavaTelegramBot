package ru.oopteam.bot.handlers;

import ru.oopteam.bot.readers.Request;
import ru.oopteam.bot.writers.Response;

public interface Handler
{
    Response handle(Request request);
}
