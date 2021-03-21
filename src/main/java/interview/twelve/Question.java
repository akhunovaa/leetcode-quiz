package interview.twelve;

public class Question implements I1, I2{

    /**
     * Что необходимо прописать в сигнатуре метода copy? Выберите нцжные варианты:
     * #1 IOException
     * #2 IllegalArgumentException
     * #3 FileNotFoundException
     * #4 InterruptedException
     * #5 Можно убрать throws полностью
     */
    public static void main(String[] args){

    }

    @Override
    public void copy() // ? {
    {
        System.out.println("IOException IllegalArgumentException FileNotFoundException InterruptedException");
    }


    /*
    Правильный ответы:
        #2 IllegalArgumentException
        #3 FileNotFoundException
        #4 InterruptedException
        #5 Можно убрать throws полностью

        'copy()' в 'interview.twelve.Question' конфликтует с 'copy()' в 'interview.twelve.I1'
        Переопределенный метод не выбрасывает 'java.lang.InterruptedException'

        'copy()' в 'interview.twelve.Question' конфликтует с 'copy()' в 'interview.twelve.I2'
        Переопределенный метод не выбрасывает 'java.lang.IOException'


     */

}
