package interview;

/**
 * <b>Pow(x, n)</b>
 * <p/>
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 */
public class Power {

    public static void main(String[] args) {
        double x = 2.00000;
        int n = -2;
        double answer = myPow(x, n);
        System.out.println("Answer: " + answer);
    }

    public static double myPow(double x, int n) {
        long nm = n;
        if (n < 0) {
            nm = -nm;
            x = 1 / x;
        }
        return pow(x, nm);
    }

    static double pow(double x, long n) {
        if (n == 0)
            return 1;

        if (n % 2 == 0)
            return pow(x * x, n / 2);
        else
            return x * pow(x, n - 1);
    }

}
