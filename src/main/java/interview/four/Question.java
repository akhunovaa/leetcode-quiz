package interview.four;

public class Question {

    /**
     * Какие сравнения напечатают true?
     */
    public static void main(String[] args) {
        String s1 = "java-best";
        final String s2 = "java";
        String s3 = "-best";
        String s4 = "java-best";

        System.out.println(s1 == s4);          // #1
        System.out.println(s1 == s2 + s3);     // #2
        System.out.println(s1 == s2 + "-best");// #3

        /*
        Правильный ответ  #1 и #3 так как s2 тут является final и java при конкатенации  создаст новую переменную с новой ссылкой
         */
    }
}
