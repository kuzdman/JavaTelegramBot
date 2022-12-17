package ru.oopteam.bot.parsing;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


public class GettingCurrency{
    public static HashMap<String, String> getCurrency()  {

        try {

            var doc = Jsoup.connect("https://www.binance.com/ru/markets").get();
            var titleElements = doc.getElementsByClass("css-ovtrou");
            var titleElements2 = doc.getElementsByClass("css-1x8dg53");

            List<String> CryptoName = titleElements2.stream()
                    .map(Element::text)
                    .collect(Collectors.toList());
            //Adding Crypto Names to list
            List<String> Currency = titleElements.stream()
                    .map(Element::text)
                    .collect(Collectors.toList());
            //Adding Crypto Currency to list

            HashMap<String, String> currencyDictionary = new HashMap<>();
            for (int i = 0; i < CryptoName.size();i++){
                currencyDictionary.put(CryptoName.get(i), Currency.get(i));

            }
            return currencyDictionary;

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}