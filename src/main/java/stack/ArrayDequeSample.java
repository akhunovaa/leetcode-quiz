package stack;

import java.util.ArrayDeque;

public class ArrayDequeSample {

    public static void main(String[] args) {


        ArrayDeque<String> states = new ArrayDeque<>();
        // стандартное добавление элементов
        states.add("Russia");
        states.add("Germany");
        states.addFirst("France"); // добавляем элемент в самое начало
        states.push("Great Britain"); // добавляем элемент в самое начало
        states.addLast("Spain"); // добавляем элемент в конец коллекции
        states.add("Italy");

        // получаем первый элемент без удаления
        String sFirst = states.getFirst();
        System.out.println(sFirst);

        // получаем последний элемент без удаления
        String sLast = states.getLast();
        System.out.println(sLast);

        System.out.printf("Queue size: %d \n", states.size());  // 6

        // перебор коллекции
        while (states.peek() != null) {
            // извлечение c начала
            System.out.println(states.pop());
        }

        // очередь из объектов Person
        ArrayDeque<Person> people = new ArrayDeque<>();
        people.addFirst(new Person("Tom"));
        people.addLast(new Person("Nick"));

        // перебор без извлечения
        for (Person p : people) {
            System.out.println(p.getName());
        }
    }

    static class Person {

        private final String name;

        public Person(String value) {

            name = value;
        }

        String getName() {
            return name;
        }
    }

}
