/**
 * Created by WinAsia on 2017/3/28.
 */
// 生产者
public class Firm implements Runnable {
    private String name;
    private Storage storage = null;

    private int num;

    public Firm(int num, Storage storage) {
        this.num = num;
        this.storage = storage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void firmProduct(int num) {
        storage.procudt(num, this);
    }

    @Override
    public void run() {
        firmProduct(num);
    }
}
