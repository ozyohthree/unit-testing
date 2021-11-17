import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;


//use class level timeout annotation for all tests
//@Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountTimeoutTest {

    @Test
    @DisplayName("Test @Timeout annotation to control execution time")
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    public void testDepositTimeoutAssertion(BankAccount bankAccount){
        try{
            Thread.sleep(100);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
        bankAccount.deposit(300);
        assertEquals(300, bankAccount.getBalance());

    }

    @Test
    @DisplayName("Test assertTimeout to control execution time")
    public void testDepositTimeoutAnnotation(BankAccount bankAccount){
        try{
            Thread.sleep(100);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
        bankAccount.deposit(300);
        assertTimeout(Duration.ofMillis(500), ()-> {
            Thread.sleep(100);
        });

    }
}
