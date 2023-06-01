package main.java;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Account account1 = new Account(120565,"11111111");
        Account account2 = new Account(10565,"22222222");

        Account account3 = new Account(120565,"33333");
        Account account4 = new Account(10565,"444444");

        Account account5 = new Account(120565,"555555");
        Account account6 = new Account(10565,"666666");



        Map<String, Account> accounts = new HashMap<>();

        accounts.put("11111111",account1);
        accounts.put("22222222",account2);
        accounts.put("33333",account3);
        accounts.put("444444",account4);
        accounts.put("555555",account5);
        accounts.put("666666",account6);



        Thread myThready = new Thread(new Runnable()
        {
            public void run() //Этот метод будет выполняться в побочном потоке
            {
                Bank bank = new Bank();
                bank.transfer(account1.getAccNumber(),account2.getAccNumber(),19000,accounts);
                bank.getBalance(account1.getAccNumber());
                bank.getBalance(account2.getAccNumber());
            }
        });
        myThready.start();
        myThready.join();

        Thread myThready1 = new Thread(new Runnable()
        {
            public void run() //Этот метод будет выполняться в побочном потоке
            {
                Bank bank = new Bank();
                bank.transfer(account2.getAccNumber(),account1.getAccNumber(),6000,accounts);
            }
        });
        myThready1.start();	//Запуск потока
        myThready1.join();

        Thread myThready2 = new Thread(new Runnable()
        {
            public void run() //Этот метод будет выполняться в побочном потоке
            {
                Bank bank = new Bank();
                bank.transfer(account3.getAccNumber(),account4.getAccNumber(),6000,accounts);
            }
        });
        myThready2.start();	//Запуск потока
        myThready2.join();

        Thread myThready3 = new Thread(new Runnable()
        {
            public void run() //Этот метод будет выполняться в побочном потоке
            {
                Bank bank = new Bank();
                bank.transfer(account3.getAccNumber(),account4.getAccNumber(),6000,accounts);
            }
        });
        myThready3.start();	//Запуск потока









    }
}
