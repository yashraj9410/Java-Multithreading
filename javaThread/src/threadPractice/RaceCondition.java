package threadPractice;

// demonstrating a race condition using the ATM example
// suppose we have 10000 in out ATM balance
// two threads at the same run withdrawing 8000 each will make the balance negative which should not happen
// the above statement is racing of threads to update the same shared object
// avoid using synchronised , lock

class AtmRace {
    int balance;
    AtmRace(int balance){
        this.balance = balance;
    }
    public synchronized void withdraw(int amount){
        if(this.balance < amount){
            System.out.println("In-sufficient balance");
        } else {
            balance -= amount;
            System.out.println("Withdrawed : " + amount +  " Left : " + balance);
        }
    }
}

class Cust extends  Thread{
    AtmRace atm;
    int amount;
    Cust(AtmRace at, int a){
        atm = at;
        amount = a;
    }

    public void useAtm(){
        atm.withdraw(amount);
    }

    public synchronized void run(){
        useAtm();
    }
}

public class RaceCondition {
    public static void main(String[] args){
        AtmRace atm = new AtmRace(10000);
        Cust c1 = new Cust(atm, 9000);
        Cust c2 = new Cust(atm, 2000);

        c1.start();
        c2.start();
    }

}
