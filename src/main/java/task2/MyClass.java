package task2;

import org.jetbrains.annotations.NotNull;

public class MyClass {

    public static synchronized void printThreadName(@NotNull Thread thread) {
        System.out.println("Name: " + thread.getName());
        System.out.println("Time: " + java.time.LocalTime.now());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
