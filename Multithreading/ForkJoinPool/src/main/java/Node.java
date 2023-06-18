import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Node {

    CopyOnWriteArrayList<Node> children  = new CopyOnWriteArrayList<>();

    String url;

    public Node(String url) {
        this.url = url;

    }

    public void addChild(Node child){
        children.forEach(e ->{

        });
        children.add(child);

    }

    public CopyOnWriteArrayList<Node> getChildren(){
        return children;
    }

    public  String getUrl(){
        return url;
    }

}
