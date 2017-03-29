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
        EventBus eventBus = vertx.eventBus();
        Future<Integer> future = Future.future();
    }
}
