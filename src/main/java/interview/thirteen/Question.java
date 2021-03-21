package interview.thirteen;

public class Question {

    /**
     * Что выведется на экран?
     * #1 1
     * #2 1staticA
     * #3 static1A
     * #4 123staticA
     * */
    public static void main(String... args) {
        System.out.print(Values.A);
    }

    /*
    Правильный ответ #4 123staticA так как в отличии от класса в Enum static отрабатывает после всего

    Сначала выведутся на экран из конструктора 123

    Values(int i) {
        System.out.print(i);
    }

    После из поля static 'static'

   static {
        System.out.print("static");
    }

    а потом 'A' в из main

     */
}
