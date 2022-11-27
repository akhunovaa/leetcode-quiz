package interview.array;

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
        //int[] input = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] input = {1, 2, 1};
        // int[] input = {1, 1};
        double answer = mySqrt(25);
//        double x = Math.sqrt(25);
        System.out.println("Answer: " + answer);
    }

    public static float mySqrt(float x) {
        float xhalf = 0.5f * x;
        int i = Float.floatToIntBits(x);
        i = 0x5f3759df - (i >> 1);
        x = Float.intBitsToFloat(i);
        x *= (1.5f - xhalf * x * x);
        return x;
    }

    public static int mySqrt(int x) {
        double xhalf = 0.5d * x;
        long i = Double.doubleToLongBits(x);
        i = 0x5fe6ec85e7de30daL - (i >> 1);
        double ans = Double.longBitsToDouble(i);
        ans *= (1.5d - xhalf * ans * ans);
        return (int) ans;
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
