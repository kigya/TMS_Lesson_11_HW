package task3.model;

/**
 * Потребитель, который будет забирать товары со склада
 */
public class Consumer implements Runnable{
    private final Store store;

    public Consumer(Store store){
        this.store=store;
    }

    @Override
    public void run() {
        for (int i = 1; i < 10; i++) {
            store.consume();
        }
    }
}
