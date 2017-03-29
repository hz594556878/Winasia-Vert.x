import java.util.Random;

/**
 * Created by WinAsia on 2017/3/28.
 */
public class Test {
    public static void main(String[] args) {
        Storage storage = new Storage();
        Customer[] customers = new Customer[10];
        Firm[] firms = new Firm[3];
        Random random = new Random();
        for (int i = 0; i < customers.length; i++) {
            int num = random.nextInt(50);
            customers[i] = new Customer(num, storage);
            customers[i].setName((char) ('A' + i) + "");
        }
        for (int i = 0; i < firms.length; i++) {
            int num = random.nextInt(30);
            firms[i] = new Firm(num, storage);
            firms[i].setName("***" + (char) ('A' + i) + "***");
        }

        for (int i = 0; i < customers.length; i++) {
            new Thread(customers[i]).start();
        }
        for (int i = 0; i < firms.length; i++) {
            new Thread(firms[i]).start();
        }
    }
}
