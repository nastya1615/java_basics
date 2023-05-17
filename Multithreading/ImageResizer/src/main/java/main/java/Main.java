package main.java;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        String srcFolder = "C:\\Users\\ivanovaan\\Desktop\\src";
        String dstFolder = "C:\\Users\\ivanovaan\\Desktop\\dst";
        int newWidth = 50;

        int availableProcessors = Runtime.getRuntime().availableProcessors()/2;

        System.out.println(availableProcessors);


        File srcDir = new File(srcFolder);


        long start = System.currentTimeMillis();

        File[] files = srcDir.listFiles();

        int share = files.length/availableProcessors;


        for(int i = 0; i < availableProcessors; i++){
            File[] file1;

            if(i!=availableProcessors-1){
                file1 = new File[share];
            System.arraycopy(files,share*i,file1,0,file1.length);}


            else {

                file1 = new File[files.length-(share*i)];
                System.arraycopy(files,share*i,file1,0,file1.length);

            }

            ImageResizer imageResizer = new ImageResizer(file1,dstFolder,newWidth,start);
            new Thread(imageResizer).start();}





        }


    }

