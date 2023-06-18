import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.Selector;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {

    public static void main(String[] args) throws IOException{

        Node node = new Node("https://lenta.ru/");
        MadeSiteMap map = new MadeSiteMap(node);


        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(map);
        String result = createSitemapString(node, 0);
        System.out.println(result);

        try(FileWriter writer = new FileWriter("C:\\Users\\ivanovaan\\IdeaProjects\\file.txt", false))
        {
            // запись всей строки

            writer.write(result);
            // запись по символам
            writer.append('\n');
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

    }
    public static String createSitemapString(Node node, int depth) {
        String tabs = String.join("", Collections.nCopies(depth, "\t"));
        StringBuilder result = new StringBuilder(tabs + node.getUrl());
        node.getChildren().forEach(child -> {
            result.append("\n").append(createSitemapString(child, depth + 1));
        });
        return result.toString();
    }

}
