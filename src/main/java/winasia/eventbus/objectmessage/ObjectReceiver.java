package winasia.eventbus.objectmessage;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;
import winasia.staticresource.StaticData;

/**
 * Created by WinAsia on 2017/3/29.
 */
public class ObjectReceiver extends AbstractVerticle {

    @Override
    public void start() throws Exception {
        EventBus eb = getVertx().eventBus();
        eb.consumer(StaticData.OBJECTADDRESS, message -> {
            MessageEntity entity = (MessageEntity)message.body();
            System.out.println("接收到内容：" + entity);
        });
    }
}
