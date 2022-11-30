package ru.oopteam.bot.readers;

import java.util.Scanner;

public class ConsoleReader implements Reader {
    final Scanner scanner = new Scanner(System.in);

    @Override
    public Request read() {
        String message = scanner.nextLine();
        return new Request(message);
    }
}
