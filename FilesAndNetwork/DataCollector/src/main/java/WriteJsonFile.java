import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class WriteJsonFile {

    WebPageParsing web = new WebPageParsing();

    public void writeJsonFile1(){

        JSONObject jsonObject = new JSONObject();
        JSONObject object = new JSONObject();
        String key1 = "stantions";

        List <MoscowMetroStations > stations = web.parsHtmlGetStation();

        stations.forEach(st->{

            JSONArray array = new JSONArray();
            String[] str = st.getName().substring(2).split("\\d{0,3}[.]");

            for (String station: str) {

                array.add(station);
            }

            object.put(st.getNum(),array);
        });

        jsonObject.put(key1,object);


        String key2 = "lines";
        JSONArray jsonArray = new JSONArray();

        List<MoscowMetroLines> lines = web.parsHtmlGetLines();

        lines.forEach(line ->{

            JSONObject obj = new JSONObject();
            obj.put("number", line.getNum());
            obj.put("line",line.getName());
            jsonArray.add(obj);
        });

        jsonObject.put(key2,jsonArray);


        try {

            ObjectMapper mapper = new ObjectMapper();

            ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

            writer.writeValue(Paths.get("file.json").toFile(),jsonObject);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void writeJsonFile2(){

        JSONObject jsonObject = new JSONObject();
        JSONArray array = new JSONArray();
        String key1 = "name";
        String key2 = "line";
        String key3 = "date";
        String key4 = "depth";
        String key5 = "hasConnection";


        List<DataOfStation> dataOfStationAll = new ArrayList<>();
        CSVParse csv = new CSVParse();
        JsonParse json = new JsonParse();

        File file1 = new File("data");
        SearchFiles pathCSV = new SearchFiles();

        pathCSV.searchFilesCSV(file1).forEach(flCsv->{



            csv.parceCSV(flCsv).forEach(data ->{

                dataOfStationAll.add(data);
            });


        });


        List<DepthOfStation> depthOfStationAll = new ArrayList<>();
        SearchFiles pathJson = new SearchFiles();

        pathJson.searchFilesJSON(file1).forEach(flJson->{

            json.parseFile(flJson).forEach(depth ->{

                depthOfStationAll.add(depth);
            });


        });


        List<MoscowMetroStations> stations = web.parsHtmlGetStation();
        List<MoscowMetroLines> lines = web.parsHtmlGetLines();

        List<MoscowMetroConnection> connections = web.parsHtmlGetConnection();


        stations.forEach(e->{

            String[] station = e.getName().substring(2).split("\\d{0,3}[.]");

                    for (String st:station) {
                        JSONObject obj = new JSONObject();
                        lines.forEach(ln ->{
                            if(e.getNum().equals(ln.getNum())){

                                obj.put(key1,st);
                                obj.put(key2,ln.getName());
                            }
                        });

                        dataOfStationAll.forEach(dt ->{


                            if(st.toLowerCase(Locale.ROOT).trim().equals(dt.getName().toLowerCase(Locale.ROOT).trim())){



                                obj.put(key3,dt.getData());
                            }
                        });

                        depthOfStationAll.forEach(deppth ->{


                            if(st.toLowerCase(Locale.ROOT).trim().equals(deppth.station_name.toLowerCase(Locale.ROOT).trim())){
                                obj.put(key4,deppth.getDepth());
                            }
                        });

                        connections.forEach(connect->{

                            if(st.toLowerCase(Locale.ROOT).trim().equals(connect.getName().toLowerCase(Locale.ROOT).trim()))
                            {
                                obj.put(key5,connect.getConnection());
                            }
                        });

                        array.add(obj);
                    }
                    }


        );

        jsonObject.put("station",array);

        try {

            ObjectMapper mapper = new ObjectMapper();

            ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

            writer.writeValue(Paths.get("file2.json").toFile(),jsonObject);

        } catch (IOException e) {
            e.printStackTrace();
        }




    }



}
