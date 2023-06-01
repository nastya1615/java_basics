import junit.framework.TestCase;
import main.java.Account;
import main.java.Bank;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class BankTests extends TestCase {

    Account account1;
    Account account2;
    Account account3;
    Account account4;
    Map<String, Account> accounts;

    private ByteArrayOutputStream output = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }


    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }


    @Override
    protected void setUp() throws Exception {
         account1 = new Account(120565,"11111111");
         account2 = new Account(10565,"22222222");


        accounts = new HashMap<>();

        accounts.put("11111111",account1);
        accounts.put("22222222",account2);



    }

    public void testBalanceChangeCheck(){
        Thread myThready = new Thread(new Runnable()
        {
            public void run() //Этот метод будет выполняться в побочном потоке
            {
                Bank bank = new Bank();
                bank.transfer(account1.getAccNumber(),account2.getAccNumber(),3000,accounts);

            }
        });
        myThready.start();
        try {
            myThready.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        long actual = account1.getMoney();
        long expected = 117565;
        long actual1 = account2.getMoney();
        long expected1 = 13565;
        assertEquals(actual,expected);
        assertEquals(actual1,expected1);


    }

    public void testCheckingBalanceNotEnough(){

        Thread myThready = new Thread(new Runnable()
        {
            public void run() //Этот метод будет выполняться в побочном потоке
            {
                Bank bank = new Bank();
                bank.transfer(account1.getAccNumber(),account2.getAccNumber(),300000,accounts);
                Assert.assertEquals("Сумма перевода превышает быланс, в транзакции отказано", output.toString());
            }
        });
        myThready.start();


    }
}
