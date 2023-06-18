import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.RecursiveAction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Thread.sleep;

public class MadeSiteMap extends RecursiveAction {

   // CopyOnWriteArrayList<String> mapSite  = new CopyOnWriteArrayList<>();
    Node node;

    public MadeSiteMap(Node node) {
        this.node = node;

    }

    @Override
    protected void compute() {
        try {

           // mapSite.add(node.getUrl());


            sleep(500);
            Document document = Jsoup.connect(node.getUrl()).ignoreHttpErrors(true).get();

            Elements links = document.select("a");

            links.forEach(link -> {

                String urlOnThePage = link.absUrl("href");

                if (!urlOnThePage.equals(node.getUrl())){
                    if (ChakUrl(urlOnThePage, node.getUrl())) {

                        //System.out.println(urlOnThePage);
                        node.addChild(new Node(urlOnThePage));
                    }
                }


            });

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        List<MadeSiteMap> taskList = new ArrayList<>();
        node.getChildren().forEach(child -> {
            MadeSiteMap task = new MadeSiteMap(child);
            task.fork();
            taskList.add(task);
        });
        taskList.forEach(task -> {

            task.join();
        });

    }

    private static boolean ChakUrl(String urlChek, String url) {
        Pattern pattern = Pattern.compile("^" + url);
        Matcher matcher = pattern.matcher(urlChek);

        return matcher.find();


    }
}
