import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

@DisplayName("BankAccountAssumptionsTest class")
public class BankAccountAssumptionsTest {

    @Test
    @DisplayName("Withdraw 300 successfully")
    public void testWithdrawal(){
        BankAccount bankAccount = new BankAccount(500,-1000);
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

    @Test
    @DisplayName("Overdraft works")
    public void testOverDraft() {
        BankAccount bankAccount = new BankAccount(500, -1000);
        bankAccount.withdraw((800));

        assertNotEquals(0,bankAccount.getBalance());
    }

    @Test
    @DisplayName("Test activation account after creation")
    public void testActive(){
        BankAccount bankAccount = new BankAccount(500, 0);
        assumingThat(bankAccount != null, () -> assertTrue((bankAccount.isActive())));

    }

    @Test
    @DisplayName("Test Account Holder Name on creation")
    public void testAccountHolderName(){
        BankAccount bankAccount = new BankAccount(500,-100);
        bankAccount.setAccountHolderName("John Doe");

        assertNotNull(bankAccount.getAccountHolderName());
    }

    @Test
    @DisplayName("Should not below minimum")
    public void testNoWithdrawalBelowMinimum(){
        BankAccount bankAccount = new BankAccount(500, -200);
        assertThrows(RuntimeException.class, () -> bankAccount.withdraw(800));
    }

    
}
