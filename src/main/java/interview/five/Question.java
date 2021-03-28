package interview.five;

public class Question {

    /**
     * Какие сравнения напечатают true?
     * 1) Только #1
     * 2) Только #2
     * 3) Все
     * 4) Никакие
     */
    public static void main(String[] args) {
       Long a = 111L;
       Long b = 111L;
       Long c = 222L;
       Long d = 222L;

        System.out.println(a == b); // #1
        System.out.println(c == d); // #2

        /*
           только #1 так как при сверке в методе valueOf откидываются все что меньше или больше -127 и 128
           Long является классом оберткой  для примитива типа long. И так как они являются объектами
           тут необходимо сверить их содержимое используя метод .equals() вместо того чтобы сверить их ссылки оператором (==)

           Выглядит все вроде как в порядке, но все это обманчиво. но не с большими числами.
           У нас возникнут проблемы, если значения будут вне диапазона от -128 до 127, что даст совершенно другой и неожиданный результат:
           Это связано с тем, что Java поддерживает постоянный пул для экземпляров Long между -128 и 127.

    public static Long valueOf(long l) {
        final int offset = 128;
        if (l >= -128 && l <= 127) { // will cache
            return Long.LongCache.cache[(int)l + offset];
        }
        return new Long(l);
    }

         */
    }

}
