package winasia.eventbus.objectmessage;

import io.vertx.core.buffer.Buffer;
import io.vertx.core.eventbus.MessageCodec;
import io.vertx.core.json.JsonObject;

/**
 * Created by WinAsia on 2017/3/29.
 */
public class CustomMessageCodec implements MessageCodec<MessageEntity, MessageEntity> {
    @Override
    public void encodeToWire(Buffer buffer, MessageEntity messageEntity) {
        JsonObject json = new JsonObject();
        json.put("name", messageEntity.getName());
        json.put("pwd", messageEntity.getPwd());
        String jsonStr = json.encode();

        int len = jsonStr.getBytes().length;
        buffer.appendInt(len);
        buffer.appendString(jsonStr);
    }

    @Override
    public MessageEntity decodeFromWire(int pos, Buffer buffer) {
        int _pos = pos;
        int length = buffer.getInt(_pos);
        String jsonStr = buffer.getString(_pos, length);
        JsonObject json = new JsonObject(jsonStr);
        String name = json.getString("name");
        String pwd = json.getString("pwd");
        MessageEntity me = new MessageEntity();
        me.setName(name);
        me.setPwd(pwd);
        return me;
    }

    @Override
    public MessageEntity transform(MessageEntity messageEntity) {
        return messageEntity;
    }

    @Override
    public String name() {
        return this.getClass().getSimpleName();
    }

    @Override
    public byte systemCodecID() {
        return -1;
    }
}
