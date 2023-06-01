package main.java;

import java.util.*;

public class Bank {
    Map<String, Account> accounts;
    int allSum = 0;
    private static  Set<String>  blockAccountList = Collections.synchronizedSet(new HashSet<>());



    private final Random random = new Random();

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum)
        throws InterruptedException {


        blockAccountList.forEach(s->{

            if(s == fromAccountNum | s == toAccountNum){
                System.out.println("Транзакция невозможна, счёт заблокирован");
                return;
            }

        });


        Thread.sleep(1000);

        boolean legalTranslation = random.nextBoolean();

        if (legalTranslation == false){
            blockAccountList.add(fromAccountNum);
            blockAccountList.add(toAccountNum);


        }

        return legalTranslation;
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами. Если сумма транзакции > 50000,
     * то после совершения транзакции, она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка счетов (как – на ваше
     * усмотрение)
     */

    public synchronized void  transfer (String fromAccountNum, String toAccountNum, long amount,Map<String, Account>accounts) {
        Account accountFrom = accounts.get(fromAccountNum);
        Account accountTo = accounts.get(toAccountNum);

        if(accountFrom.getMoney() < amount){

            System.out.println("Сумма перевода превышает быланс, в транзакции отказано");
            return;
        }

        if(amount > 5000){
            boolean chek = false;
            try {
                chek = isFraud(fromAccountNum,toAccountNum);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(chek == false){
                System.out.println("В транзакции отказано");
                return;

            }
        }

        accountFrom.setMoney(accountFrom.getMoney()-amount);
        accountTo.setMoney(accountTo.getMoney()+amount);

    }



    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public  long getBalance(String accountNum) {
        return accounts.get(accountNum).getMoney();
    }

    public  long getSumAllAccounts() {

        accounts.forEach((k,a) ->{
            allSum+= a.getMoney();
        });

        return  allSum;

    }






}
