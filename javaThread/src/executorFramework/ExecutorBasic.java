package executorFramework;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// basic of executor framework
public class ExecutorBasic {
    public static void main(String[] args){
        // making pool of two threads using executors service
        int n = 2;
        ExecutorService es = Executors.newFixedThreadPool(2);
        for(int i = 1; i<=10; i+=2){
            int finalI = i;
            es.submit(
                    () -> {
                        System.out.println(n*finalI);
                        System.out.println(n * (finalI + 1));
                    }
            );
        }
        try{es.wait(1000);}catch(Exception e){};
        es.shutdown();
    }
}
