import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Loader  implements Runnable {
    int regionCode;
    Loader(int regionCode){
        this.regionCode = regionCode;
    }

        @Override
        public void run() {
            long start = System.currentTimeMillis();

            FileOutputStream writer = null;

            try {
                writer = new FileOutputStream("res/numbers_"+regionCode+".txt");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            char letters[] = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};

            StringBuilder bilder = new StringBuilder();
            for (int number = 1; number < 1000; number++) {
                for (char firstLetter : letters) {
                    for (char secondLetter : letters) {
                        for (char thirdLetter : letters) {
                            bilder.append(firstLetter);
                            bilder.append(padNumber(number,3));
                            bilder.append(secondLetter);
                            bilder.append(thirdLetter);
                            bilder.append(padNumber(regionCode,2));
                            bilder.append("\n");

                            if (bilder.length() > 1024){

                                try {
                                    writer.write(bilder.toString().getBytes());
                                    writer.write('\n');
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                bilder = new StringBuilder();

                            }


                        }
                    }
                }
            }
            try {
                writer.write(bilder.toString().getBytes());
                writer.write('\n');
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


            System.out.println((System.currentTimeMillis() - start) + " ms");
        }
    private static String padNumber(int number, int numberLength) {
        StringBuilder bilder = new StringBuilder();
        bilder.append(number);

        int padSize = numberLength - bilder.length();

      //  System.out.println(padSize + "Это padSize");

        for (int i = 0; i < padSize; i++) {
            bilder.insert(0,'0');

        }

        return bilder.toString();
    }



}
