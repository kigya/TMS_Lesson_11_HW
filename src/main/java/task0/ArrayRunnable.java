package task0;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ArrayRunnable implements Runnable {

    Thread thread;

    private Random rand;

    {
        try {
            rand = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public ArrayRunnable() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        System.out.println(thread.getName() + ": " + getMaxFromArrayWithRandomNumbers());
    }

    private int getMaxFromArrayWithRandomNumbers() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayList.add(this.rand.nextInt(50));
        }
        return Collections.max(arrayList);
    }

}
