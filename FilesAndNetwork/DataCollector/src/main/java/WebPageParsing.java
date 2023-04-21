import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WebPageParsing {


    public Document getHTML() {
        try {
            return Jsoup.connect("https://skillbox-java.github.io/").get();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    public List<MoscowMetroLines> parsHtmlGetLines() {

        List<MoscowMetroLines> listLine = new ArrayList<>();

        Elements newListLine = getHTML().select("span.js-metro-line");

        newListLine.forEach(element -> {

            String numLine = element.attr("data-line");
            String nameLine = element.text();
            MoscowMetroLines line = new MoscowMetroLines(numLine, nameLine);
            listLine.add(line);

        });

        return listLine;

    }

    public List<MoscowMetroStations> parsHtmlGetStation(){

        List<MoscowMetroStations> listStation= new ArrayList<>();
        Elements newLisStation = getHTML().select("div.js-metro-stations");


           newLisStation.forEach(element ->{

/*               for (String word:element.text().substring(2).split("\\d{0,3}[.]")) {
                   listStation.add(new MoscowMetroStations(element.attr("data-line"),word));


               }*/

               listStation.add(new MoscowMetroStations(element.attr("data-line"),element.text()));

            });



        return listStation;
    }

    public List<MoscowMetroConnection> parsHtmlGetConnection(){

        List<MoscowMetroConnection> listConnection= new ArrayList<>();
        Elements newLisStation = getHTML().select("p.single-station");


        newLisStation.forEach(element ->{

            Elements conection = element.select("span.t-icon-metroln");


            if (conection.attr("title").length() ==0){

                listConnection.add(new MoscowMetroConnection(element.select("span.name").text(),false));


            }

            else {

                listConnection.add(new MoscowMetroConnection(element.select("span.name").text(),true));
            }


        });



        return listConnection;

    }


}
