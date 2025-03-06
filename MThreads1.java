class Bank {
    int Balance = 1000;

    public synchronized void amountWithdraw(int Wamount, String Name) {
        if (Wamount <= Balance) {
            System.out.println("\n-------------------------------------------\n");
            System.out.println(Name + " is withdrawing the amount: " + Wamount+" "+Thread.currentThread().getName() );
            Balance = Balance - Wamount;
            System.out.println("Balance amount: " + Balance);
            System.out.println("\n*******************************************\n");
        } else {
            // System.out.println("\n-------------------------------------------\n");
            System.out.println("Withdrawing by "+ Name+ " is failed due to insufficient funds\n"+"Account Balance: "+Balance+" "+Thread.currentThread().getName() );
            System.out.println("\n-------------------------------------------\n");
        }
    }
}

class WithdrawAmount implements Runnable {
    private Bank account;
    private int WithdrawAmount;
    private String Name;

    public WithdrawAmount(Bank account, int Amount,String Name) {
        this.account = account;
        this.WithdrawAmount = Amount;
        this.Name=Name;
    }

    public void run() {
        account.amountWithdraw(WithdrawAmount, Name);
    }

}

public class MThreads1 {
    public static void main(String[] args) {
        Bank sharedAccount = new Bank(); // One bank account shared between both threads

        Thread t1 = new Thread(new WithdrawAmount(sharedAccount, 700, "Alice"));
        Thread t2 = new Thread(new WithdrawAmount(sharedAccount, 500, "Bob"));

        t1.start();
        t2.start();
    }
}
