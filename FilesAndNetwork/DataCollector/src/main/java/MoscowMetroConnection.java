public class MoscowMetroConnection {

    String name;
    Boolean connection;


    public MoscowMetroConnection(String name, boolean connection ){

        this.name = name;
        this.connection = connection;


    }

    public String getName() {
        return name;
    }

    public Boolean getConnection() {
        return connection;
    }


    @Override
    public String toString() {
        return "MoscowMetroConnection{" +
                "name='" + name + '\'' +
                ", connection=" + connection +
                '}';
    }
}


