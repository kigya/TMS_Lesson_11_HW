/**
 * 3. Задан LinkedList, представляющий собой хранилище целых чисел.
 * Метод produce бесконечно добавляет в этот список случайные числа, однако максимальное количество,
 * которое он может добавить равно 10.
 * Метод consume бесконечно считывает числа с какой-то случайной задержкой (от 0 до 10 мс).
 * Сделать так, чтобы метод produce добавлял числа только тогда, когда не превышен лимит,
 * а метод consume забирал их только тогда, когда в списке что-нибудь есть.
 * При этом методы должны корректно работать в многопоточной среде.
 * Использовать метод removeFirst у LinkedList для получения элемента.
 * Создать и запустить два различных потока, один из которых вызывает produce, а другой - consume.
 * Продемонстрировать корректность работы хранилища с помощью вывода сообщений в консоль о добавлении,
 * получении и текущем размере хранилища на этапах добавления и получения
 */

package task3;

import task3.model.Consumer;
import task3.model.Producer;
import task3.model.Store;

public class Runner {

    public static void main(String[] args) {
        Store store = new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);
        new Thread(producer).start();
        new Thread(consumer).start();
    }

}
