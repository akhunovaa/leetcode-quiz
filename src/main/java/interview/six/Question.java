package interview.six;

public class Question {

    /**
     * Результат вызова метода work()?
     * 1# StackOverflowError
     * 2# NullPointerException
     * 3# Зависнет
     * 4# Успешное завершение метода
     */
    public static void main(String[] args) {
        Question question = new Question();
        question.work();
    }

    private void work() {
        try {
            work();
        } finally {
            work();
        }
    }

    /*
      Правильный ответ это #3 Зависнет, так как только при выбрасываниии ошибки StackOverflowError и будет исполняться блок finally

     если добавить обработку catch (Exception exception):
         try {
            work();
        } catch (Exception exception) {
            exception.printStackTrace();
        } {
            work();
        }

        как раз и увидим Exception in thread "main" java.lang.StackOverflowError
     */
}
