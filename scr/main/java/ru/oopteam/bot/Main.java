package ru.oopteam.bot;

import ru.oopteam.bot.readers.*;
import ru.oopteam.bot.writers.*;
import ru.oopteam.bot.handlers.*;

public class Main{
    public static void main(String[] args) {
        Reader reader = new ConsoleReader();
        Handler handler = new SimpleHandler();
        Writer writer = new ConsoleWriter();

        while (true) {
            Request request = reader.read();
            Response response = handler.handle(request);
            writer.write(response);
        }

    }
}
