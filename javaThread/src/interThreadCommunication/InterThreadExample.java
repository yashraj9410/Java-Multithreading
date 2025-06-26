package interThreadCommunication;

// demonstrating a single producer thread , consumer thread example
// this is the twp thread communication properly with notify and wait that are semaphores in java

class MyData {
    int value;
    Boolean flag = true; // if true producers turn else consumers turn

    public synchronized void setValue(int x){

        // handle race condition in case of mulitple consumers
        while(flag!= true)
            try{wait();} catch(Exception e){};

        this.value = x;
        notify();
        flag = false;

    }

    public synchronized void getValue(){

        // wait if its consumers turn
        while( flag != false)
            try {wait();} catch (Exception e){};

        int temp = this.value;
        flag = true;             // for producer
        System.out.println(temp);
        notify();                // notify the other thread
    }
}

class Producer extends Thread {
    MyData d;

    Producer(MyData d){
        this.d = d;
    }

    public void run(){
        int i = 0;
        while(true) {
            d.setValue(i++);
        }
    }
}

class Consumer extends Thread {

    MyData d;

    Consumer(MyData d) {
        this.d = d;
    }

    public void run(){
        while(true)
            d.getValue();
    }
}

public class InterThreadExample {
    public static void main(String args[]){
        MyData d = new MyData();
        Producer p = new Producer(d);
        Consumer c = new Consumer(d);

        p.start();
        c.start();
    }
}
