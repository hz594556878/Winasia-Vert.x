/**
 * Created by WinAsia on 2017/3/28.
 */
public class Customer implements Runnable {
    private String name;
    private Storage storage = null;

    private int num;

    public Customer(int num, Storage storage) {
        this.num = num;
        this.storage = storage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void customerProduct(int num) {
        System.out.println(getName() + "需要消费" + num + "个商品" + "当前库存为：" + storage.getStock());
        storage.consumer(num, this);
    }

    @Override
    public void run() {
        customerProduct(num);
    }
}
