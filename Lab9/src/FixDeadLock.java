import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FixDeadLock {

    private class Account {
        private final Lock lock = new ReentrantLock();
        double balance;
        int id;

        public Account(int id, double balance) {
            this.balance = balance;
            this.id = id;
        }

        void withdraw(double amount) {
            this.balance -= amount;
        }

        void deposit(double amount) {
            balance += amount;
        }
    }

    private class Transfer {

        void transfer(Account fromAccount, Account toAccount, double amount) {
            /*
             * synchronized (fromAccount) { synchronized (toAccount) {
             * fromAccount.withdraw(amount); toAccount.deposit(amount); } }
             */

            if (impendingTransaction(fromAccount, toAccount)) {
                try {
                    System.out.format("Transaction Begins from:%d to:%d\n",
                            fromAccount.id, toAccount.id);
                    fromAccount.withdraw(amount);
                    toAccount.deposit(amount);
                } finally {
                    fromAccount.lock.unlock();
                    toAccount.lock.unlock();
                }

            } else {
                System.out.println("Unable to begin transaction");
            }

        }

        boolean impendingTransaction(Account fromAccount, Account toAccount) {

            Boolean fromAccountLock = false;
            Boolean toAccountLock = false;

            try {
                fromAccountLock = fromAccount.lock.tryLock();
                toAccountLock = toAccount.lock.tryLock();
            } finally {
                if (!(fromAccountLock && toAccountLock)) {
                    if (fromAccountLock) {
                        fromAccount.lock.unlock();
                    }
                    if (toAccountLock) {
                        toAccount.lock.unlock();
                    }
                }
            }

            return fromAccountLock && toAccountLock;
        }

    }

    private class WrapperTransfer implements Runnable {
        private Account fromAccount;
        private Account toAccount;
        private double amount;

        public WrapperTransfer(Account fromAccount, Account toAccount, double amount) {
            this.fromAccount = fromAccount;
            this.toAccount = toAccount;
            this.amount = amount;
        }

        public void run() {
            Random random = new Random();
            try {
                int n = random.nextInt(1000);
                int TIME = 1000 + n; // 1 second + random delay to prevent livelock
                Thread.sleep(TIME);
            } catch (InterruptedException e) {
            }
            new Transfer().transfer(fromAccount, toAccount, amount);
        }

    }

    public void initiateDeadLockTransfer() {
        Account from = new Account(1, 1000);
        Account to = new Account(2, 300);
        System.out.println("From balance:"+from.balance + "To balance:" + to.balance);
        Thread thread1 = new Thread(new WrapperTransfer(from, to, 200));
        thread1.start();
        Thread thread2 =  new Thread(new WrapperTransfer(to, from, 300));
       // while(thread1.isAlive());
        System.out.println("From balance:"+from.balance + "To balance:" + to.balance);
        thread2.start();
        while(thread2.isAlive());
        System.out.println("From balance:"+from.balance + "To balance:" + to.balance);
    }
}