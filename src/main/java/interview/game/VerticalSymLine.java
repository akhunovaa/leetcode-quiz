package interview.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VerticalSymLine {

    public static void main(String[] args) {
        int length = 3;
        Point[] p = new Point[length];
        p[0] = new Point(0, 0);
        p[1] = new Point(1, 1);
        p[2] = new Point(-1, 1);

        boolean answer = hasVerticalSymLine(p);
        System.out.println("Answer: " + answer);

        length = 4;
        p = new Point[length];

        p[0] = new Point(1, 1);
        p[1] = new Point(2, 2);
        p[2] = new Point(1, 2);
        p[3] = new Point(2, 3);

        answer = hasVerticalSymLine(p);
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

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
