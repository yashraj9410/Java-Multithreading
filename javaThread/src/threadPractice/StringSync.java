package threadPractice;

class MyData {
    // same resource method for both threads
    public synchronized void display(String str){
        for (char c : str.toCharArray()) {
            System.out.print(c);
        }
    }
}

class MyThread1 extends Thread{
    MyData data1 ;

    public MyThread1(MyData myData) {
        this.data1 = myData;
    }

    public void run(){
        data1.display("Hello World");
    }
}

class MyThread2 extends Thread{
    MyData data2;
    public MyThread2(MyData d){
        this.data2 = d;
    }
    public void run(){
        data2.display("Thread 2");
    }
}

public class StringSync {
    public static void main(String[] args){
        // here we are sharing differnt resource hence threads will run independently
//        MyThread1 t1 = new MyThread1(new MyData());
//        MyThread2 t2 = new MyThread2(new MyData());

        MyData data = new MyData();
        MyThread1 t1 =new MyThread1(data);
        MyThread2 t2 = new MyThread2(data);
        t1.start();
        t2.start();
    }
}
