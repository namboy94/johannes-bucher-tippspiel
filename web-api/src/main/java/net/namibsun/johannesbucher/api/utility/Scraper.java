package net.namibsun.johannesbucher.api.utility;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Map;

public class Scraper {

    public static String[] getCurrentTable(Map<String, String> cookies) {
        Document ranks = null;
        try {
            ranks = Jsoup.connect("https://tippspiel.johannes-bucher.de/rank.php").cookies(cookies).get();
        } catch (IOException e) {
            return null;
        }

        //System.out.println(ranks.toString());
        Elements elements = ranks.select("tr");
        Elements profileElements = new Elements();

        for (Element element : elements) {
            if (element.toString().contains("profile.php")) {
                profileElements.add(element);
            }
        }
        for (Element element : profileElements) {

            String[] userTableData = element.toString().split("<td");

            String position = userTableData[2].split("<b>")[1].split("</b>")[0];
            String previousPosition = userTableData[3].split("\\(")[1].split("\\)")[0];

            String username = userTableData[4]
                    .split("<a href=\"profile\\.php\\?")[1]
                    .split("\">")[1]
                    .split("</a>")[0];

            String points = userTableData[5].split(">", 2)[1].split("</td>")[0];
            String averagePoints = userTableData[6].split(">", 2)[1].split("</td>")[0];
            String amountOfBets = userTableData[7].split(">", 2)[1].split("</td>")[0];

            System.out.println(position + " " + previousPosition + " " + username + " " + points);
            System.out.println(averagePoints + " " + amountOfBets);
        }

        return null;

    }
}
