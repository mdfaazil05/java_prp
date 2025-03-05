class BankAccount {
    private int balance = 100;

    public synchronized void withdraw(String name, int amount) {
        if (balance >= amount) {
            System.out.println("\n\n----------------------------------------");
            System.out.println(name + " is withdrawing $" + amount);
            balance -= amount;
            System.out.println(name + " withdrawal successful. Balance left: $" + balance);
            System.out.println("----------------------------------------\n\n");
        } else {
            System.out.println(name + " attempted to withdraw $" + amount + " but insufficient funds.\n\n");
        }
    }
}

public class MultiThreadingSample {    
    public static void main(String[] args){
        BankAccount account = new BankAccount();

        Runnable task1 = () -> account.withdraw("Alice", 70);
        Runnable task2 = () -> account.withdraw("Bob", 50);

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);

        t1.start();
        t2.start();
    }
}
