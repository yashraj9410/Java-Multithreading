package threadPractice;

public class ATM {
    public synchronized   void checkBalance(String name, int amount){
        System.out.println(name + " your amount is : " + amount);
        try{
            Thread.sleep(1000);
        } catch (Exception e){
            System.out.println("exception Occured");
        }
        System.out.println("Balance Fetched");
    }

    public synchronized   void withdraw(String Name , int amount){
        System.out.println(Name + " is withdrawing amount : " + amount);
        try{
            Thread.sleep(1000);
        } catch (Exception e){
            System.out.println("exception Occured");
        }
    }

    public static void main(String[] args){
        ATM atm = new ATM();
        Customer c1 = new Customer(atm, "Yash", 200);
        Customer c2 = new Customer(atm, "Raju", 300000);

        c1.start();
        c2.start();


    }
}


class Customer extends Thread {
    ATM atm;
    String name;
    int amount;

    Customer(ATM atm, String name , int amount){
        this.atm = atm;
        this.name = name;
        this.amount  = amount;
    }
    void useAtm(){
        atm.checkBalance(name, amount);
        atm.withdraw(name, amount);
    }

    public synchronized void run(){
        useAtm();
    }
}
