package ru.oopteam.bot.readers;

import java.util.Scanner;

public class ConsoleReader implements Reader {

    @Override
    public Request read() {

        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        return new Request(message);
    }
}
