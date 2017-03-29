package winasia.eventbus.objectmessage;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.VertxOptions;
import io.vertx.core.eventbus.EventBus;
import winasia.staticresource.StaticData;
import winasia.util.Runner;

/**
 * Created by WinAsia on 2017/3/29.
 */
public class Sender extends AbstractVerticle {

    public static void main(String[] args) {
        Runner.runExample();
    }

    @Override
    public void start() throws Exception {
        EventBus eb = getVertx().eventBus();
        eb.registerDefaultCodec(MessageEntity.class, new CustomMessageCodec());
        MessageEntity entity = new MessageEntity();
        entity.setName("zhong");
        entity.setPwd("123");
        eb.publish(StaticData.OBJECTADDRESS, entity);
    }
}
