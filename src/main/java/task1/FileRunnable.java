package task1;

import org.jetbrains.annotations.NotNull;
import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FileRunnable implements Runnable {

    Thread thread;
    private Random rand;

    {
        try {
            this.rand = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public FileRunnable() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        printToFile(createArrayWithRandomNumbers());
    }

    private @NotNull List<Integer> createArrayWithRandomNumbers() {

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayList.add(this.rand.nextInt(50));
        }
        return arrayList;
    }

    private void printToFile(@NotNull List<Integer> list) {
        try {
            String path = "C:\\Users\\Lenovo\\Documents\\JAVADev\\TMS_Lesson_11_HW\\src\\main\\java\\task1\\output.txt";
            System.out.println("File has been created successfully");
            try (FileWriter fw = new FileWriter(path, true)) {
                for (Integer item : list) {
                    fw.write(item.toString() + " ");
                }
                fw.write("\n");
            }
        } catch (IOException e) {
            System.out.println("Exception Occurred: ");
            e.printStackTrace();
        }
    }
}
