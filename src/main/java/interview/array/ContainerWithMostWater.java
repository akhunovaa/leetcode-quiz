package interview.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Container With Most Water
 * <p/>
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 * Notice that you may not slant the container.
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] input = {1, 8, 6, 2, 5, 4, 8, 3, 7};
//        int[] input = {1, 2, 1};
        // int[] input = {1, 1};
        long time = System.nanoTime();
        // double answer =  1 / mySqrt(2);
        double answer =  Math.sqrt(500);
        long end = System.nanoTime() - time;
//        double x = Math.sqrt(25);
        System.out.println("Time: " + end);
        System.out.println("Answer: " + answer);
        System.out.println("=================================");
        time = System.nanoTime();
        answer =  1 / mySqrtFloat(500);
        end = System.nanoTime() - time;
        System.out.println("Time: " + end);
        System.out.println("Answer: " + answer);
//         Time: 25325 25242            18514
//         Answer: 1.4145671129226685   1.414579489411209
//
//          Time: 14728
//         Answer: 1.4142135623730951
//        mapTest();
    }

    private static void mapTest() {
        class Key {
            private String key;
            public Key(String key){
                this.key = key;
            }
            public void set(String key){
                this.key = key;
            }
        }

        Map<Key, String> map = new HashMap<>();
        Key key = new Key("a");
        map.put(key, "xxx");
        key.set("b");
        System.out.println(map.get(key)); // что будет
    }


    public static float mySqrtFloat(float x) {
        float xhalf = 0.5f * x;
        int i = Float.floatToIntBits(x);
        i = 0x5f3759df - (i >> 1);
        x = Float.intBitsToFloat(i);
        x *= (1.5f - xhalf * x * x);
        return x;
    }

    public static double mySqrt(int x) {
        double xhalf = 0.5d * x;
        long i = Double.doubleToLongBits(x);
        i = 0x5fe6ec85e7de30daL - (i >> 1);
        double ans = Double.longBitsToDouble(i);
        ans *= (1.5d - xhalf * ans * ans);
        return ans;
    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            int w = right - left;
            int h = Math.min(height[left], height[right]);
            int area = h * w;
            max = Math.max(max, area);
            if (height[left] < height[right]) {
                left++;
            } else if (height[left] > height[right]) {
                right--;
            } else {
                left++;
                right--;
            }
        }
        return max;
    }
}
