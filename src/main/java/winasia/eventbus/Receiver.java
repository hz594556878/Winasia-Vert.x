package winasia.eventbus;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;
import winasia.staticresource.StaticData;

/**
 * Created by WinAsia on 2017/3/28.
 */
public class Receiver extends AbstractVerticle {
    @Override
    public void start() throws Exception {
        EventBus eventBus = vertx.eventBus();
        eventBus.consumer(StaticData.PUBLISHADDRESS, message -> {
            System.out.println("接收到了消息： " + message.body());
        });
        vertx.setPeriodic(1000, event -> {
        eventBus.publish(StaticData.PUBLISHADDRESS, "hello event bus");
        });
    }
}
