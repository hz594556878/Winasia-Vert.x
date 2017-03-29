package winasia.server;

import io.vertx.core.*;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.impl.EventBusImpl;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.http.WebSocket;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.templ.ThymeleafTemplateEngine;
//import winasia.service.IndexService;
//import winasia.service.PostForm;
import winasia.staticresource.StaticData;
import winasia.util.Runner;

import java.util.function.Consumer;

/**
 * Created by WinAsia on 2017/3/27.
 */
public class MainServer extends AbstractVerticle {

    public static void main(String[] args) {
        Runner.runExample();
    }

    @Override
    public void start() throws Exception {


        WorkerExecutor workerExecutor = vertx.createSharedWorkerExecutor("work");
        workerExecutor.executeBlocking(future ->{
            try {
                Thread.sleep(10000);
                future.complete("OK1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
                    try {
                        Thread.sleep(10000);
                        future.complete("Ooooo");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        Thread.sleep(10000);
                        future.complete("**-**-**");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
        },
        false
        ,res -> {
            System.out.println("完成了： " + res.result());
        });

        EventBus eb = vertx.eventBus();
        eb.consumer(StaticData.PUBLISHADDRESS, mm -> {
            System.out.println("接收到了消息：" + mm.body());
        });
        eb.publish(StaticData.PUBLISHADDRESS, "启动成功");
    }
}
