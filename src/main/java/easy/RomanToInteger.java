package easy;

import java.util.HashMap;
import java.util.Map;

/*
    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000
*/
public class RomanToInteger {

    public static void main(String[] args) {
        String input = "LVIII";
        int answer = romanToInt2(input);
        System.out.println(answer);

    }

    public static int romanToInt2(String s) {
        int result = 0;
        Map<Character, Integer> data = new HashMap<>();
        data.put('I', 1);
        data.put('V', 5);
        data.put('X', 10);
        data.put('L', 50);
        data.put('C', 100);
        data.put('D', 500);
        data.put('M', 1000);

        char[] charArray = s.toCharArray();
        result = result + data.get(charArray[charArray.length - 1]);

        for (int i = charArray.length - 2; i >= 0; i--) { // iterate loop till 0 index
            if (data.get(charArray[i]) >= data.get(charArray[i + 1])) {
                result = result + data.get(charArray[i]); // add number if prev is greater or equal to next
            } else {
                result = result - data.get(charArray[i]); // deduct number if previous is smaller than next
            }
        }

        return result;
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> data = new HashMap<>();
        data.put('I', 1);
        data.put('V', 5);
        data.put('X', 10);
        data.put('L', 50);
        data.put('C', 100);
        data.put('D', 500);
        data.put('M', 1000);

        char prev = ' ';

        int ans = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == 'I' && prev == 'V' || s.charAt(i) == 'I' && prev == 'X') {
                ans -= 1;
            } else if (s.charAt(i) == 'X' && prev == 'L' || s.charAt(i) == 'X' && prev == 'C') {
                ans -= 10;
            } else if (s.charAt(i) == 'C' && prev == 'D' || s.charAt(i) == 'C' && prev == 'M') {
                ans -= 100;
            } else {
                ans += data.get(s.charAt(i));
            }

            prev = s.charAt(i);
        }

        return ans;

    }
}
