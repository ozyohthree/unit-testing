

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountNestedTest {

    @Test
    @DisplayName("Withdraw 300 successfully")
    public void testWithdrawal(){
        BankAccount bankAccount = new BankAccount(500, -100);
        bankAccount.withdraw(300);
        assertEquals(200, bankAccount.getBalance());
    }


    @Test
    @DisplayName("Deposit 500 successfully")
    public void testDeposit(){
        BankAccount bankAccount = new BankAccount(400,0);
        bankAccount.deposit(500);
        assertEquals(900, bankAccount.getBalance());
    }

    @Nested
    @DisplayName("Test when Balance Zero")
    class WhenBalanceEqualsZero {

        @Test
        @DisplayName("Withdrawing below minimum balance: exception")
        public void testWithdrawalMinimumBalanceIs0(){
            BankAccount bankAccount = new BankAccount(0,0);
            assertThrows(RuntimeException.class, () -> bankAccount.withdraw(500));
        }

        @Test
        @DisplayName("Withdrawing and getting negative balance")
        public void testWithdrawMinimumBalanceNegative1000(){
            BankAccount bankAccount = new BankAccount(0,-1000);
            bankAccount.withdraw(500);
            assertEquals(-500, bankAccount.getBalance());
        }
    }

}
