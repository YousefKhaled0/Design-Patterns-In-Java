package command;

public class Account {

    private int balance;

    public void process(Command c) {
    }

    public void deposit(int a) {
        balance += a;
    }

    public boolean withdraw(int a) {
        if (balance - a < 0) return false;
        balance -= a;
        return true;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }
}
