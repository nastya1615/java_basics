import java.sql.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3307/skillbox";
        String user = "root";
        String pass = "7sU=hWd8";

        try {
            Connection connection = DriverManager.getConnection(url,user,pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select course_name from purchaselist group by course_name");

            Statement statement1 = connection.createStatement();


                    while (resultSet.next()){
                        String course_name = resultSet.getString("course_name");

                        ResultSet resultSet1 = statement1.executeQuery("SELECT pl.course_name,count(pl.subscription_date)/(MONTH(max(pl.subscription_date)) - MONTH(min(pl.subscription_date)) +1 )FROM PurchaseList pl WHERE pl.course_name = \""+course_name+"\"  group by pl.course_name");



                       while (resultSet1.next()){

                           System.out.println(resultSet1.getString("pl.course_name")+" - "+ resultSet1.getString("count(pl.subscription_date)/(MONTH(max(pl.subscription_date)) - MONTH(min(pl.subscription_date)) +1 )"));

                        }
                       

                    }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
