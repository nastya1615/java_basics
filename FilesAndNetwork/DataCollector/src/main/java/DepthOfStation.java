public class DepthOfStation {

    String  station_name;
    String  depth;

    public DepthOfStation(String station_name,String depth){

        this.station_name = station_name;
        this.depth = depth;
    }


    public String getDepth() {
        return depth;
    }

    public String getStation_name() {
        return station_name;
    }

    @Override
    public String toString() {
        return "DepthOfStation{" +
                "station_name='" + station_name + '\'' +
                ", depth='" + depth + '\'' +
                '}';
    }
}
