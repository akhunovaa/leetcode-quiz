package interview.array;

import java.util.Arrays;

public class HundredDoors {

    public static void main(String[] args) {
        boolean[] doors = new boolean[101];
        int answer = countOfOpenedDoors(doors);
        System.out.println("Answer: " + answer);
    }

    private static int countOfOpenedDoors(boolean[] doors) {
        int answer = 0;
        for (int i = 1; i <= 100; i++) {
            System.out.println("Проход №" + i);
            walkOverDoors(doors, i);
            System.out.println(Arrays.toString(doors));
        }

        for (boolean door : doors) {
            if (door) {
                answer++;
            }
        }
        return answer;
    }

    private static void walkOverDoors(boolean[] doorsCount, int idx) {
        for (int i = 0; i < doorsCount.length; i++) {
            doorsCount[i] = i % idx == 0;
        }
    }

}
