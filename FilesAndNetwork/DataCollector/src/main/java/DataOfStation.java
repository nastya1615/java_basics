public class DataOfStation {
    String name;
    String data;

    public DataOfStation(String name, String data){

        this.name = name;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "DataOfStation{" +
                "name='" + name + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
