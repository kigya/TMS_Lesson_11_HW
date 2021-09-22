package task2;

public class MyRunnable extends Thread{

    @Override
    public void run() {
        MyClass.printThreadName(this);
    }

}
