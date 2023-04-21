

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JsonParse {

    protected String getFile(File dataFile){

        StringBuilder builder =new StringBuilder();

        try {
            List<String> lines = Files.readAllLines(Paths.get(dataFile.toString()));
            lines.forEach(line->builder.append(line));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String line = builder.toString();


        return line;


    }



    public List<DepthOfStation> parseFile(File dataFile){

        String jsonLine = getFile(dataFile);

        List<DepthOfStation> depthOfStationList = new ArrayList<>();

        JSONParser parser = new JSONParser();
        try {


            JSONArray jsonArray = (JSONArray) parser.parse(jsonLine);

            jsonArray.forEach(jsonObject -> {

                JSONObject stationJSONObject = (JSONObject) jsonObject;

                String  station_name = (String) stationJSONObject.get("station_name");
                String  depth = (String) stationJSONObject.get("depth");

                DepthOfStation depthOfStation = new DepthOfStation(station_name,depth);

                depthOfStationList.add(depthOfStation);



            });







        } catch (ParseException e) {
            e.printStackTrace();
        }

        return depthOfStationList;

    }



}
