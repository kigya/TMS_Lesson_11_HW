package task4;

import java.util.Scanner;

public class ConsoleRunnable implements Runnable {

    Thread thread;

    public ConsoleRunnable() {
        thread = new Thread(this);
        thread.start();
    }

    private static void printSleepState() {
        int number;
        do {
            number = inputIntPositiveField();
            if (number != -1) {
                try {
                    Thread.sleep(number * 1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
                System.out.println("I slept for " + number + " seconds");
            }
        } while (number != -1);
        System.out.println("Done!");
    }

    public static int inputIntPositiveField() {
        int number;
        Scanner scanner = new Scanner(System.in);
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("That not a number! Try again");
                scanner.next();
            }
            number = scanner.nextInt();
        } while (number < -1);
        return number;
    }

    @Override
    public void run() {
        printSleepState();
    }
}
