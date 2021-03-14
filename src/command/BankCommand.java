package command;

public class BankCommand implements Command {

    private Account account;

    public enum Action {
        DEPOSIT, WITHDRAW
    }

    public Action action;
    public int amount;
    public boolean success;

    public BankCommand(Action action, int amount, Account account) {
        this.action = action;
        this.amount = amount;
        this.account = account;
    }

    @Override
    public void execute() {
        switch (action) {
            case DEPOSIT:
                account.deposit(amount);
                success = true;
                break;
            case WITHDRAW:
                success = account.withdraw(amount);
                break;
        }
    }

    @Override
    public void undo() {
        if (!success) return;
        switch (action) {
            case DEPOSIT:
                account.withdraw(amount);
                break;
            case WITHDRAW:
                account.deposit(amount);
                break;
        }
    }

    public static void main(String[] args) {
        Account account = new Account();
        System.out.println(account);

        BankCommand d = new BankCommand(Action.DEPOSIT, 100, account);
        d.execute();
        System.out.println(account);
        BankCommand w = new BankCommand(Action.WITHDRAW, 1000, account);
        w.execute();
        System.out.println(account);
        BankCommand w2 = new BankCommand(Action.WITHDRAW, 10, account);
        w2.execute();
        System.out.println(account);


        w2.undo();
        System.out.println(account + " After Undo.");

    }

}
