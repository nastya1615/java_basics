public class MoscowMetroLines {

    String num;
    String name;


    public MoscowMetroLines(String num,String name ){

        this.num = num;
        this.name = name;


    }

    public String getNum() {
        return num;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "MoscowMetroLines{" +
                "num='" + num + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
