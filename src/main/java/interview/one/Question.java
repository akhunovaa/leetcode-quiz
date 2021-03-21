package interview.one;

public class Question {

    /**
     * Какие сравнения напечатают false?
     */
    public static void main(String[] args) {
        String java = "java";
        StringBuilder stringBuilder = new StringBuilder("java");
        StringBuilder stringBuilderTwo = new StringBuilder("java");

        //System.out.println(java == stringBuilder);        //#1
        System.out.println(java.equals(stringBuilder));   //#2
        System.out.println(stringBuilder.equals(stringBuilderTwo));//#3


        /*
        Правильный ответ #2 и #3
        у StringBuilder не переопределен метод equals

        У #1 выведет, так как данное сравнение будет всегда false. Так как проверяеи  ссылаются ли ссылки на одни и те же объекты HEAP.
        Но надо учесть что #1 String java = "java"; имеет ссылку на пул строк, а #2 имеет ссылк на HEAP регион в памяти JAVA.
        Данное сравнение недопустимо.
        java: incomparable types: java.lang.String and java.lang.StringBuilder

        */
    }
}
