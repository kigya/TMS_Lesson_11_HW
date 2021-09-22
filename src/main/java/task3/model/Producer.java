package task3.model;

/**
 * Производитель, который производит товары
 */
public class Producer implements Runnable{
    private final Store store;

    public Producer(Store store){
        this.store=store;
    }

    @Override
    public void run() {
        for (int i = 1; i < 10; i++) {
            store.product();
        }
    }
}
