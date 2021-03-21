package interview.nine;


import java.util.Set;
import java.util.TreeSet;

public class Question {

    /**
     * Какой будет вывод?
     * #1 1
     * #2 2
     * #3 3
     * #4 ClassCastException
     * #5 Ошибка компиляции
     */
    public static void main(String[] args){
        Set<Number> set = new TreeSet<Number>();
        set.add(1);
        set.add(1L);
        set.add(1.0);

        System.out.println(set.size());
    }

    /*
    Правильный ответ #4 ClassCastException
    Для TreeSet сработает компаратор и при java.lang.Long.compareTo(Long.java:65) выбросится ClassCastException
    class java.lang.Integer cannot be cast to class java.lang.Long
    Потому что это дерево и ему необходимо отсортироваться
     */

}
