import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("BankAccountAssertionsTest class")
public class BankAccountAssertionsAndOrderTest {


    @Order(3)
    @Test
    @DisplayName("Withdraw 300 successfully")
    public void testWithdrawal(){
        BankAccount bankAccount = new BankAccount(500,-1000);
        bankAccount.withdraw(300);
        assertEquals(200, bankAccount.getBalance());
    }

    @Order(5)
    @Test
    @DisplayName("Deposit 500 successfully")
    public void testDeposit(){
        BankAccount bankAccount = new BankAccount(500,-1000);
        bankAccount.deposit(500);
        assertEquals(1000, bankAccount.getBalance());
    }

    @Order(6)
    @Test
    @DisplayName("Overdraft less than Minimum balance allowed works")
    public void testOverDraft() {
        BankAccount bankAccount = new BankAccount(500,-1000);
        bankAccount.withdraw((800));
        assertNotEquals(0,bankAccount.getBalance());
    }

    @Order(1)
    @Test
    @DisplayName("Test activation account after creation")
    public void testActive(){
        BankAccount bankAccount = new BankAccount(500,-1000);
        assertTrue((bankAccount.isActive()));
    }

    @Order(2)
    @Test
    @DisplayName("Test Account Holder Name on creation")
    public void testAccountHolderName(){
        BankAccount bankAccount = new BankAccount(500,-1000);
        bankAccount.setAccountHolderName("John Doe");
        assertNotNull(bankAccount.getAccountHolderName());
    }

    @Order(4)
    @Test
    @DisplayName("Withdrawal below minimum Allowed balance throws Exception")
    public void testWithdrawalBelowMinimumThrowsRuntimeException(){
        BankAccount bankAccount = new BankAccount(500,-1000);
        assertThrows(RuntimeException.class, () -> bankAccount.withdraw(1800));
    }


}
