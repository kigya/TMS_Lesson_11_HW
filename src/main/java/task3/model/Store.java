package task3.model;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.Random;

/**
 * Склад товаров, которые производит производитель
 * Одновременно на складе может быть не более 3х товаров
 */
public class Store {
    private final LinkedList<Integer> list = new LinkedList<>();
    private Random rand;

    {
        try {
            this.rand = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public synchronized void product() {
        while (list.size() >= 10) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }

        }
        list.add(rand.nextInt(100));
        System.out.println("Adding one item!");
        System.out.println("Storage: " + list.toString());

        notifyAll();
    }

    public synchronized void consume() {
        while (list.isEmpty()) {
            try {
                wait(rand.nextInt(10));
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
        list.removeFirst();
        System.out.println("Removing one item!");
        System.out.println("Storage: " + list.toString());
        notifyAll();
    }
}
