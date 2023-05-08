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

                        ResultSet resultSet1 = statement1.executeQuery("SELECT pl.course_name, MONTH(pl.subscription_date ) FROM PurchaseList pl WHERE pl.course_name = \""+course_name+"\" ORDER BY MONTH(pl.subscription_date )");
                        ArrayList<Integer> salesCounterByTime = new ArrayList<>();

                        while (resultSet1.next()){

                            
                            String subscriptionDate = resultSet1.getString("MONTH(pl.subscription_date )");

                            salesCounterByTime.add(Integer.parseInt(subscriptionDate));


                        }

                        int numberOfmonths = salesCounterByTime.stream().max(Integer::compare).get();
                        int numberOfsales = salesCounterByTime.size();
                        double averagNumberOfPurchases = ((double) numberOfsales / (double)numberOfmonths);

                        System.out.println(course_name + " — " + averagNumberOfPurchases);



                    }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
