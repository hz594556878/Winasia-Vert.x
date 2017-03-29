package winasia.util;

import io.vertx.core.Vertx;
import winasia.eventbus.Receiver;
import winasia.server.MainServer;

import java.util.function.Consumer;

/**
 * Created by WinAsia on 2017/3/28.
 */
public class Runner {

    public static void runExample(){
        Consumer<Vertx> runner = vertx1 -> {
            try {
                vertx1.deployVerticle(MainServer.class.getName());
                vertx1.deployVerticle(Receiver.class.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
        Vertx vertx = Vertx.vertx();
        runner.accept(vertx);
    }
}
