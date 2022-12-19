package ru.oopteam.bot.parsing;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;


public class GettingCurrency{

    private static String urlToMarket = "https://www.binance.com/ru/markets";
    private static String currenciesConfig = "css-ovtrou";
    private static String cryptoNamesConfig = "css-1x8dg53";

    public static void initialize() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("/market.properties"));
        urlToMarket = properties.getProperty("urlToMarket");
        currenciesConfig = properties.getProperty("currencies");
        cryptoNamesConfig = properties.getProperty("cryptoNames");
    }

    public static HashMap<String, String> getCurrency()  {

        try {

            var doc = Jsoup.connect(urlToMarket).get();
            var currencies = doc.getElementsByClass(currenciesConfig);
            var cryptoNames = doc.getElementsByClass(cryptoNamesConfig);

            List<String> cryptoName = cryptoNames.stream()
                    .map(Element::text)
                    .toList();

            //Adding Crypto Names to list
            List<String> currency = currencies.stream()
                    .map(Element::text)
                    .toList();

            //Adding Crypto Currency to list
            HashMap<String, String> currencyDictionary = new HashMap<>();
            for (int i = 0; i < cryptoName.size(); i++){
                currencyDictionary.put(cryptoName.get(i), currency.get(i));
            }

            return currencyDictionary;

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}