/**
 * Created by WinAsia on 2017/3/28.
 */
public class Product {
    private String producer;
    private String content;

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "生产商为：" + getProducer() + "生产的内容是：" + getContent();
    }
}
