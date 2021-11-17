import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountParallelExecutionTest {

    @BeforeAll
    public static void init(){
        System.out.println("Initialize Test");
    }

    @AfterAll
    public static void tearDown(){
        System.out.println("Tear down");
    }

    @Test
    @DisplayName("Deposit 500 successfully")
    public void testDeposit(BankAccount bankAccount){

        try{
            Thread.sleep(5000);
            System.out.println("Slept 5 seconds");
        } catch(InterruptedException e){
            e.printStackTrace();
        }
        bankAccount.deposit(500);
        assertEquals(500, bankAccount.getBalance());
    }
    @Test
    @DisplayName("Deposit 600 successfully")
    public void testDeposit2(BankAccount bankAccount){

        try{
            Thread.sleep(10000);
            System.out.println("Slept 10 seconds");
        } catch(InterruptedException e){
            e.printStackTrace();
        }
        bankAccount.deposit(500);
        assertEquals(500, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Deposit 700 successfully")
    public void testDeposit3(BankAccount bankAccount){

        try{
            Thread.sleep(1000);
            System.out.println("Slept 1 seconds");
        } catch(InterruptedException e){
            e.printStackTrace();
        }
        bankAccount.deposit(500);
        assertEquals(500, bankAccount.getBalance());
    }
}
