package interview.elleven;

public class Question {

    /**
     * Какой будет вывод?
     * #1 Завершится без ошибок
     * #2 NullPointerException
     * #3 ExceptionInitializerError
     * #4 NoClassDefFoundError
     */
    public static void main(String[] args){
        try {
            Test test = new Test();
        } catch (Throwable exception) {
            Test test = new Test();
        }
    }
    /*
     Правильный ответ #4 NoClassDefFoundError так если в блоке static случился NPE, то JVM не грузит данный класс

    Exception in thread "main" java.lang.NoClassDefFoundError: Could not initialize class interview.elleven.Test
	at interview.elleven.Question.main(Question.java:16)
     */

}
