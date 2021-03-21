package interview.ten;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"rawtypes", "unchecked"})
public class Question {

    /**
     * Какой будет вывод?
     * #1 3
     * #2 4
     * #3 Ошибка компиляции
     * #4 Runtime exception
     */
    public static void main(String[] args){
        List longs = new ArrayList<Long>();
        longs.add(1L);
        longs.add(1.0);
        longs.add(new Object());
        longs.add("I'm a LONG!!! Yeeep that is true!");

        System.out.println(longs.size());
    }

    /*
    Правильный ответ #2
    Так как на этапе кмпиляции без разницы что складывать. Но в Runtime такое не прйдет.
    А вот такое не скомпилируется, ссылаясь на то что нельзя складывать разные типы ланных:
        List<Long> longs = new ArrayList();
        longs.add(1L);
        longs.add(1.0);
        longs.add(new Object());
        longs.add("I'm a LONG!!! Yeeep that is true!");

        System.out.println(longs.size());
     */

}
