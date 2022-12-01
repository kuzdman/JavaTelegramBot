package ru.oopteam.bot;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;


public class Prop {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
/**
        First Step(creating config.properties);
        properties.setProperty("token","test");
        System.out.println(properties.getProperty("token"));
        FileOutputStream out = new FileOutputStream("config.properties");
        properties.store(out,"tg token");
**/
        FileInputStream in = new FileInputStream("scr/main/resources/config.properties");
        properties.load(in);
        System.out.println(properties.getProperty("token"));
        
    }
}