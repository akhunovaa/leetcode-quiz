package interview.two;

public class Question {

    /**
     * Что выведется на экран?
     */
    public static void main(String[] args) {
       byte byteVariable = 10;
        execute(byteVariable, byteVariable);
    }

    static void execute(byte... args) {
        System.out.println("#1 method has been executed!");
    }

    static void execute(long longParameter, short shortParameter) {
        System.out.println("#2 method has been executed!");
    }

    static void execute(Byte firstByteParameter, Byte secondByteParameter) {
        System.out.println("#3 method has been executed!");
    }

    /*
       #2 method has been executed!
       потому что метод принимающий массив аргументов byte... args всегда посдледний в приоритете
     */
}
