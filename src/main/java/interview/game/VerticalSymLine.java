package interview.game;

import java.util.*;

public class VerticalSymLine {

    public static void main(String[] args) {
        int length = 3;
        Point[] p = new Point[length];
        p[0] = new Point(0, 0);
        p[1] = new Point(1, 1);
        p[2] = new Point(-1, 1);

        boolean answer = hasVerticalSymLine(3, p);
        System.out.println("Answer: " + answer);

        length = 4;
        p = new Point[length];

        p[0] = new Point(1, 1);
        p[1] = new Point(2, 2);
        p[2] = new Point(1, 2);
        p[3] = new Point(2, 3);

        answer = hasVerticalSymLine(4, p);
        System.out.println("Answer: " + answer);
    }

    static boolean hasVerticalSymLine(Point[] points) {
        int length = points.length;

        if (length == 0) {
            return true;
        }
        int sumX = 0;

        for (int i = 0; i < length; i++) {
            sumX += points[i].x * 2;
        }

        if (sumX % length != 0) {
            return false;
        }

        int possibleAxis = sumX / length;

        Map<Integer, List<Integer>> yAxisToX = new HashMap<>();

        for (int i = 0; i < length; i++) {
            List<Integer> arList = new ArrayList<>();
            arList.add(2 * points[i].x - possibleAxis);
            yAxisToX.put(points[i].y, arList);
        }
        for (Integer integer : yAxisToX.keySet()) {
            return check(yAxisToX.get(integer));
        }
        return true;
    }


    static boolean check(final List<Integer> arList) {
        if (arList.size() == 1) {
            return arList.get(0) == 0;
        }
        for (int i = 0; i <= arList.size() / 2; i++) {
            if (arList.get(i) + arList.get(arList.size() - 1 - i) != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Вариант решения 1.
     * за линейное время. Использует память O(n)
     */
    static boolean hasVerticalSymLine(int n, Point[] p) {

        // за линейное время пройти массив и найти максимум и минимум по x
        int minX = p[0].x;
        int maxX = p[0].x;

        Set<Point> points = new HashSet<>(p.length);
        for (int i = 0; i < p.length; i++) {
            if (minX > p[i].x) {
                minX = p[i].x;
            }
            if (maxX < p[i].x) {
                maxX = p[i].x;
            }
            points.add(p[i]);
        }

        // предполагаемая координата X вертикальной прямой
        int avgDoubled = (minX + maxX) / 2;

        // перебираем все левые точки, исключая из поиска саму середину (p.length / 2 - 1)
        // и смотрим есть ли на нее пара справа от графика
        for (int i = 0; i < p.length / 2 - 1; i++) {
            Point rightPair = new Point(avgDoubled + p[i].x, p[i].y);
            if (p[i].x <= avgDoubled && !points.contains(rightPair)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Вариант решения 2.
     * Сложность O(n^2).
     * Дополнительно память не трубует. Работает медленно.
     */
    static boolean hasVerticalSymLineBig(int n, Point[] p) {

        // за линейное время пройтись и найти максимум и минимум по x
        int minX = p[0].x;
        int maxX = p[0].x;

        for (int i = 0; i < p.length; i++) {
            if (minX > p[i].x) minX = p[i].x;
            if (maxX < p[i].x) maxX = p[i].x;
        }

        // предполагаемая координата X вертикальной прямой, умноженная на два
        int avgDoubled = (minX + maxX) / 2;

        // перебираем все точки левее прямой и ищем пару
        // оценка квадратична
        for (int i = 0; i < p.length; i++) {
            if (p[i].x * 2 <= avgDoubled) {
                boolean pairExists = false;
                for (int j = 0; j < p.length; j++)
                    if (i != j && p[i].y == p[j].y
                            && avgDoubled - p[i].x == p[j].x) { // правая точка = x + (координата прямой - x) * 2
                        pairExists = true;
                        break;
                    }
                if (!pairExists) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Вариант решения 3.
     * Если в процессе добавления точек их можно было сразу сортировать по координате x.
     * Тогда одна операция добавления занимала бы время O(log(n)) вместо константного
     * Или перед вызовом функции проверки отсортировать список с помощью merge sort за n*log(n)
     * тогда сама функция будет работать за линейное время.
     * Предполагаю, что могу читать файл в два потока с конца и с начала.
     * Для этого алгоритма координата x должна быть уникальна,
     * или структура допускать хранение для координаты х списка y и этот список помещается в память одной машины.
     */
    static boolean hasVerticalSymLinePresorted(int n, Point[] p) {

        // предполагаемая координата X вертикальной прямой, умноженная на два
        int avgDoubled = (p[0].x + p[p.length - 1].x) / 2;
        for (int i = 0; i < p.length / 2; i++) {
            Point left = p[i];
            Point right = p[p.length - i - 1];
            if (left.y != right.y) {
                return false;
            }
            if (left.x + avgDoubled - left.x * 2 != right.x) {
                return false;
            }
        }
        return true;
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            return y == point.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}
