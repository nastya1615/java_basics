

public class Main {

    public static void main(String[] args) {
        for (int regionCode = 0; regionCode<90;regionCode++){
            Loader load = new Loader(regionCode);
            new Thread(load).start();
        }

    }
}
