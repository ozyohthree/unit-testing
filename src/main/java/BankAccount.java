public class BankAccount {

    private double balance;
    private double minimumBalance;
    private boolean isActive = true;
    private String accountHolderName;

    public BankAccount(double balance, double minimumBalance){
        this.balance = balance;
        this.minimumBalance = minimumBalance;
    }

    public double getBalance() {
        return balance;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double withdraw (double amount){
        if (balance - amount > minimumBalance) {
            balance -= amount;
            return balance;
        } else {
            throw new RuntimeException();
        }

    }

    public double deposit(double amount) {
        return balance += amount;
    }

}
