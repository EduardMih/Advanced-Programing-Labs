package pooling;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args)
    {
        /*Runnable r1 = new Request();
        Runnable r2 = new Request();
        Runnable r3 = new Request();


         */
        ExecutorService pool = Executors.newFixedThreadPool(20);

    /*
        pool.execute(r1);
        pool.execute(r2);
        pool.execute(r3);

        pool.shutdown();

     */

        List<Runnable> runnableList = new ArrayList<>();

        for(int i = 0; i < 1000000; i++)
        {
            runnableList.add(new Request(i));
        }

        for(Runnable runnable : runnableList)
        {
            pool.execute(runnable);
        }

        pool.shutdown();

    }

}
