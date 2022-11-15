package interview.game;

/**
 * <b>First Bad Version</b>
 * <p></p>
 * You are a product manager and currently leading a team to develop a new product.
 * Unfortunately, the latest version of your product fails the quality check.
 * Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * <p></p>
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one,
 * which causes all the following ones to be bad.
 * <p></p>
 * You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function
 * to find the first bad version. You should minimize the number of calls to the API.
 */
public class FirstBadVersion {

    public static void main(String[] args) {
        int target = 6;
        int answer = firstBadVersion(target);
        System.out.println("Answer: " + answer);
    }

    public static int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private static boolean isBadVersion(int mid) {
        return mid > 0;
    }


}
