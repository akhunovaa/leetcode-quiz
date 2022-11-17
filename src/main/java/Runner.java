import interview.matrix.Matrix;
import interview.matrix.Matrix4f;

import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;
import java.nio.*;

public class Runner {

    private static int INC_DATA = 0;

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {

//        Field f = ClassLoader.class.getDeclaredField("classes");
//        f.setAccessible(true);
//
//        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//        Vector<Class> classes =  (Vector<Class>) f.get(classLoader);
//        System.out.println(classes);
        Solution solituion = new Solution();

        int[] input = {0, 1, 0, 3, 12};
        solituion.moveZeroes(input);
        System.out.println("Move zeros: " + Arrays.toString(input));
        // 123456789
        // 987654321
        // 498828660196
        // 840477629533
        // int answer = solituion.searchInsert(new int[]{0, 1, 2, 3, 4, 5, 7, 8, 9}, 6);
        // int answer = solituion.searchInsert(new int[]{1, 3, 5, 6}, 0);
//        int answer = solituion.searchInsert(new int[]{1, 3}, 1);
//        System.out.println(answer);
//        int[] ansxwer = solituion.heapSort(new int[]{});
//        doRecursiveMethod();
//        Runner runner = new Runner();
//        runner.doRecursiveVirtualMethod();
        //int  answer = solituion.singleNumber(new int[]{1, 1, 2, 2, 5, 7, 7, 9, 9});
//        int  answer = solituion.doMethod();

        Runner runner = new Runner();
//        System.out.println(runner.checkRecord("PPALLP")); // PPALLL
//        System.out.println(runner.checkRecord("PPALLL")); // PPALLP
//        System.out.println(runner.checkRecord("LALL")); // PPALLP
//        System.out.println(runner.checkRecord("LPLPLPLPLPL")); // PPALLP
//        System.out.println(runner.checkRecord("LALL"));
//        System.out.println(runner.divide(10, 3));
//        runner.divide(10, 3);


//        int r = 4;
//        int t = 7;


//        System.out.println("r:" + r);
//        System.out.println("t:" + t);

//        r = r ^ t;
//        t = t ^ r;
//        r = r ^ t;
//        System.out.println("r:" + r);
//        System.out.println("t:" + t);

//        Matrix matrixOne = new Matrix4f();
//        System.out.println(matrixOne);
//
//        Matrix matrixTwo = new Matrix4f();
//        matrixTwo.mul(
//                2f, 2f, 2f, 2f,
//                2f, 2f, 2f, 2f,
//                2f, 2f, 2f, 2f,
//                2f, 2f, 2f, 2f);
//        System.out.println(matrixTwo);
//
//        Matrix matrixThree = new Matrix4f();
//        matrixThree.mul(matrixTwo);
//        System.out.println(matrixThree);

        int[] inputData = new int[]{73,74,75,71,69,72,76,73};
        int[] temperatures = solituion.dailyTemperatures(inputData);
        System.out.println(Arrays.toString(temperatures));

    }

    public static final void doRecursiveMethod() {
        System.out.println(INC_DATA++);
        doRecursiveMethod(); //9320 9366 9341
    }

    public void printClassLoaders() throws ClassNotFoundException {

        System.out.println("Classloader of this class:"
                + Runner.class.getClassLoader());

        System.out.println("Classloader of Object:"
                + Object.class.getClassLoader());

        System.out.println("Classloader of ArrayList:"
                + ArrayList.class.getClassLoader());
        System.out.println("Classloader of ArrayList:"
                + ClassLoader.class.getClassLoader());
    }

    void doRecursiveVirtualMethod() {
        System.out.println(INC_DATA++); // 9209
        this.doRecursiveVirtualMethod();
    }

    public boolean checkRecord2(String s) {
        char[] charArray = s.toCharArray();
        int absentCount = 0;
        int lateCount = 0;
        for (char c : charArray) {
            if (c == 'A') {
                absentCount++;
                if (lateCount <= 2) {
                    lateCount = 0;
                }
            } else if (c == 'L') {
                lateCount++;
            } else if (c == 'P') {
                if (lateCount >= 3) {
                    return false;
                }
                lateCount = 0;
            }

        }
        return absentCount < 2 && lateCount < 3;
    }

    public boolean checkRecord(String s) {
        int countA = 0;
        int countL = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'L') {
                countL++;
                if (countL >= 3)
                    return false;
            } else {
                if (ch == 'A') {
                    countA++;
                    if (countA >= 2)
                        return false;
                }
                countL = 0;
            }
        }
        return true;
    }

    public int divide(int dividend, int divisor) {
//        Пограничные случаи
//        Если 2^31-1, вернуть 2^31-1
        if ((dividend == Integer.MIN_VALUE && divisor == -1)
                || (dividend == Integer.MAX_VALUE && divisor == 1)) {
            return Integer.MAX_VALUE;
        }


        boolean isPositive = dividend < 0 == divisor < 0;

        // If dividend and divisor have different symbols, the result is -ve


        // In order to not have to deal with numbers with different sings, lets convert
        // both divisor and dividend to integers

        dividend = dividend < 0 ? dividend : -1 * dividend;
        divisor = divisor < 0 ? divisor : -1 * divisor;

        // Each time we do a left shift of a number, it is same as doubling it
        // Similarly, a right shift equates to shrinking that number by half.
        // The logic is
        // step1: for i in range(31,0):
        // step2:      is divisor * 2^i >= dividend? (Remmeber, both number are -ve)
        // step3:      Yes: dividend = dividend - divisor * 2^i
        // step4:     No: continue checking

        // One problem with that logic is the possibility of integer overflow in step 2.
        // Example:
        //  For the sake of simplicity, lets assume:
        //      int is a 8 bit signed integer (i.e. int holds values between 2^7-1 & -2^7 (i.e. 127 and -128)),
        //      Also assume, divisor = 3, dividend = 127
        //  Now, in step 2, 3 * 2 ^ 7 is 474 which greater than 127.
        // So, we need to find the highest power of 2 that can prevent overflow instead of iterating from 31

        int highestPower = findHighestPower(divisor, dividend);

        int numMultiply = 0;
        for (int i = highestPower; i >= 0; i--) {

            if ((divisor << i) >= dividend) {
                dividend = dividend - (divisor << i);
                numMultiply += (1 << i);
            }

        }

        if (isPositive) {
            return numMultiply;
        }
        return -1 * numMultiply;
    }

    int findHighestPower(int divisor, int dividend) {

        // In order to find the highest power, keep doubling the dividend
        // as long as it is greater than half of divisor (Remember, both numbers are -ve).
        // Because if you double after that, it is going to be less than divisor

        int halfDividend = dividend >> 1;
        int highestPower = 0;
        while (divisor >= halfDividend) {
            highestPower++;
            divisor = divisor << 1;
        }
        return highestPower;

    }

}
