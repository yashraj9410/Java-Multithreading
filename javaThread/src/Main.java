

class MyThread extends Thread {
    public void run() {
        for(int i = 0; i < 8; i++) {
            System.out.println(i + "Hello");
        }
    }
}
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        // multi threading in java
        // java has a thread class that can be exteded
        // also runnble interface that can be implemented by any ither class
        MyThread t1 = new MyThread();
        t1.start();

        for(int i = 0; i < 2; i++){
            System.out.println("Main" + i);
        }

        t1.join();

    }
}