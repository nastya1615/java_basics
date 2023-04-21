import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVParse  {

    public List <DataOfStation> parceCSV(File pathFile){

        List<DataOfStation> dataOfStationsList = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(Paths.get(pathFile.toString()));

            lines.forEach(line->{

                String [] fragment = line.split(",");

                if(fragment.length !=2){

                    System.out.println("Wrong line + "+line);
                }

                else{

                    DataOfStation dataOfStation = new DataOfStation(fragment[0],fragment[1]);
                    dataOfStationsList.add(dataOfStation);

                }

                
            });



        } catch (IOException e) {
            e.printStackTrace();
        }


        return dataOfStationsList;
    }




}
