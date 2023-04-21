public class MoscowMetroStations {

    String num;
    String name;



    public MoscowMetroStations(String num,String name){

        this.num = num;
        this.name = name;


    }

    public String getName() {
        return name;
    }

    public String getNum() {
        return num;
    }

    @Override
    public String toString() {
        return "MoscowMetroStations{" +
                "num='" + num + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
