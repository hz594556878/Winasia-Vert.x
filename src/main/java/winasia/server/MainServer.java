package winasia.server;

import io.vertx.core.*;

import winasia.util.Runner;


/*
 * Created by WinAsia on 2017/3/27.
 */
public class MainServer extends AbstractVerticle {

    public static void main(String[] args) {
        Runner.runExample();
    }

    @Override
    public void start() throws Exception {
        Future<Integer> future = Future.future();
        WorkerExecutor executor = vertx.createSharedWorkerExecutor("work");
        executor.executeBlocking(f ->{
            f.complete(999);
        }, future.completer());

        /*
        vertx.executeBlocking(handler -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            handler.complete(999);
        }, future.completer());
        */
        Future<Integer> f = future.map(i -> {
            return i + 1;
        });
        System.out.println(f.result());
    }
}
