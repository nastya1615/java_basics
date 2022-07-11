import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        /*Elevator elevator = new Elevator(-3, 26);
        while (true) {
            System.out.print("Введите номер этажа: ");
            int floor = new Scanner(System.in).nextInt();
            elevator.move(floor);
        }*/

        Cargo cargo = new Cargo(10, "Маяковского 16",true, "GTR45DF3FGE",false,new Dimensions(7.56,3.12,8.19));

        System.out.println(cargo.getDeliveryAddress()+ "\n" + cargo.getDimensions().volume() + "\n" + cargo.getRegistrationNumber() +"\n" + cargo.getWeight()+"\n" +cargo.getAllowedToFlip() + "\n" +cargo.getFragile());

        System.out.println( cargo.setDeliveryAddress("Тукаево 34").getDimensions().volume());








    }





}
