package interview.seven;

public class Question {

    /**
     * Какой будет результат?
     * 1# ArrayIndexOutOfBoundsException
     * 2# ArithmeticException
     * 3# Завершится без ошибок
     * 4# Ошибка компиляции
     */
    public static void main(String[] args) {
       int[] arr = new int[1];
       int i = 2;
       arr[--i] = 1 / --i;
    }

    /*
    Правильный ответ #2 Потому что на ноль делить нельзя
    Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 1 out of bounds for length 1
	at interview.seven.Question.main(Question.java:15)
     */
}
