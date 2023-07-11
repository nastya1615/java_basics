

public class Main {

    public static void main(String[] args) {
        int numTheard  = 9;

        for (int theard = 0; theard <= numTheard; theard++){
            int startNumber = theard*100;
            int endNumber = startNumber+100;
            Loader load = new Loader(199,theard,startNumber,endNumber);

            Thread th = new Thread(load);
            th.start();
            try {
                th.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }




    }
}
