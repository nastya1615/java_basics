public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("Milk", 40,2,20);
        basket.add("Water", 40,7,15);

        System.out.println(basket.getTotalWeight());

       /*basket.print("Milk");
        *Arithmetic arithmetic = new Arithmetic(5,10);
        *System.out.println(arithmetic.sum());
        *System.out.println(arithmetic.multiplication());
        *System.out.println(arithmetic.maxNum());
        *System.out.println(arithmetic.minNum());*/
    }
}
