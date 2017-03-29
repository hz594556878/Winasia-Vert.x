import java.util.LinkedList;

/**
 * Created by WinAsia on 2017/3/28.
 */
// 生产者-消费者-仓储模式 （仓储）
public class Storage {
    //设置最大的容量为100
    private static int MAXSIZE = 100;
    //设置存储载体为LinkedList
    private LinkedList<Product> list = new LinkedList<Product>();

    //生产num个产品
    public void procudt(int num, Firm firm) {
        synchronized (list) {
            //试试if和while的区别
            while (list.size() >= MAXSIZE) {
                System.out.println("库存充足，暂时不必生产");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < num; i++) {
                Product product = new Product();
                product.setProducer(firm.getName());
                product.setContent("第" + i + "个产品");
                list.add(product);
                System.out.println(product.toString());
            }
            System.out.printf("已生产产品%d个，总库存为：%d\n", num, list.size());
            list.notifyAll();
        }
    }

    public void consumer(int num, Customer customer) {
        Product product = null;
        synchronized (list) {
            //试试if和while的区别
            while (list.size() <= 0) {
                System.out.printf("【库存不足，需要生产】****【当前库存为：%d】\n", list.size());
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < num; i++) {
                if (list.size() > 0) {
                    product = list.remove();
                    System.out.println("【" + customer.getName() + "消费了产品】" + "****【当前库存为：" + list.size() + "】");
                }
            }
            list.notifyAll();
        }
    }

    public int getStock() {
        return list.size();
    }
}
