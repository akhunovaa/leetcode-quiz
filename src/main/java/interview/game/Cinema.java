package interview.game;

/**
 * <b>Кинотеатр</b>
 * <p></p>
 * X мальчиков и Y девочек пошли в кинотеатр и купили билеты на подряд идущие места в одном ряду.
 * <p></p>
 * Напишите программу, которая выдаст, как нужно сесть мальчикам и девочкам, чтобы рядом с каждым
 * мальчиком сидела хотя бы одна девочка, а рядом с каждой девочкой — хотя бы один мальчик.
 * <p></p>
 * На вход подаются два числа — кол-во мальчиков X и кол-во девочек Y.
 * В ответе выведите какую-нибудь строку, в которой будет ровно X символов <b>“B”</b> (обозначающих мальчиков)
 * и Y символов <b>“G”</b> (обозначающих девочек), удовлетворяющую условию задачи. Пробелы между символами выводить не нужно.
 * Если рассадить мальчиков и девочек согласно условию задачи невозможно, выведите строку <b>“Нет решения”</b>.
 */
public class Cinema {

    public static void main(String[] args) {
        int girlsCount = 6;
        int boysCount = 8;
        String answer = orderCinemaSeats(girlsCount, boysCount);
        System.out.println("Answer: " + answer);
    }

    // необходимо соизмерить кол-во девочек на кол-во мальчиков
    // т.е. при большем кол-ве девочек, на каждого мальчика по две девочки
    // 8 девочек и 6 мальчиков = каждой девочке по одному мальчику, а двум оставшимся девочкам достанется по два мальчика
    // ( 1 мальчик слева | 1 девочка | 1 мальчик справа)
    private static String orderCinemaSeats(int girlsCount, int boysCount) {
        String answer = "Нет решения";
        StringBuilder sb = new StringBuilder();

        if (girlsCount <= 0 || boysCount <= 0) {
            return answer;
        }
        if (girlsCount > 2 * boysCount || boysCount > 2 * girlsCount) {
            return answer;
        }
        int delta = 0;

        if (boysCount >= girlsCount) {
            delta = boysCount - girlsCount;
            for (int i = 0; i < delta; i++) {
                sb.append("BGB");
            }
            for (int i = 0; i < girlsCount - delta; i++) {
                sb.append("GB");
            }
        } else {
            delta = girlsCount - boysCount;
            for (int i = 0; i < delta; i++) {
                sb.append("GBG");
            }
            for (int i = 0; i < boysCount - delta; i++) {
                sb.append("GB");
            }
        }
        return sb.toString();
    }


}
