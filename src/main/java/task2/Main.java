/**
 * 2. Создать класс с синхронизированным методом, который выводит на экран имя текущего потока,
 * текущее время и вызывает sleep на 5 секунд. Запустить 10 потоков, которые вызывают этот метод от созданного объекта.
 */

package task2;

public class Main {
    public static void main(String[] args) {
        MyClass object = new MyClass();
        for (int i = 0; i < 5; i++) {
            object.printThreadName(new MyRunnable());
        }
    }
}
