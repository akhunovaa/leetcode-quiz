package calculator.core;

import java.util.HashMap;
import java.util.InputMismatchException;

public class RomanNumber extends Number {

    private final static HashMap<String, Integer> romanToIntegerMap = new HashMap<>();

    static {
        romanToIntegerMap.put("I", 1);
        romanToIntegerMap.put("II", 2);
        romanToIntegerMap.put("III", 3);
        romanToIntegerMap.put("IV", 4);
        romanToIntegerMap.put("V", 5);
        romanToIntegerMap.put("VI", 6);
        romanToIntegerMap.put("VII", 7);
        romanToIntegerMap.put("VIII", 8);
        romanToIntegerMap.put("IX", 9);
        romanToIntegerMap.put("X", 10);
        romanToIntegerMap.put("XI", 11);
        romanToIntegerMap.put("XII", 12);
        romanToIntegerMap.put("XIII", 13);
        romanToIntegerMap.put("XIV", 14);
        romanToIntegerMap.put("XV", 15);
        romanToIntegerMap.put("XVI", 16);
        romanToIntegerMap.put("XVII", 17);
        romanToIntegerMap.put("XVIII", 18);
        romanToIntegerMap.put("XIX", 19);
        romanToIntegerMap.put("XX", 20);
        romanToIntegerMap.put("XXI", 21);
        romanToIntegerMap.put("XXII", 22);
        romanToIntegerMap.put("XXIII", 23);
        romanToIntegerMap.put("XXIV", 24);
        romanToIntegerMap.put("XXV", 25);
        romanToIntegerMap.put("XXVI", 26);
        romanToIntegerMap.put("XXVII", 27);
        romanToIntegerMap.put("XXVIII", 28);
        romanToIntegerMap.put("XXIX", 29);
        romanToIntegerMap.put("XXX", 30);
        romanToIntegerMap.put("XXXI", 31);
        romanToIntegerMap.put("XXXII", 32);
        romanToIntegerMap.put("XXXIII", 33);
        romanToIntegerMap.put("XXXIV", 34);
        romanToIntegerMap.put("XXXV", 35);
        romanToIntegerMap.put("XXXVI", 36);
        romanToIntegerMap.put("XXXVII", 37);
        romanToIntegerMap.put("XXXVIII", 38);
        romanToIntegerMap.put("XXXIX", 39);
        romanToIntegerMap.put("XL", 40);
        romanToIntegerMap.put("XLI", 41);
        romanToIntegerMap.put("XLII", 42);
        romanToIntegerMap.put("XLIII", 43);
        romanToIntegerMap.put("XLIV", 44);
        romanToIntegerMap.put("XLV", 45);
        romanToIntegerMap.put("XLVI", 46);
        romanToIntegerMap.put("XLVII", 47);
        romanToIntegerMap.put("XLVIII", 48);
        romanToIntegerMap.put("XLIX", 49);
        romanToIntegerMap.put("L", 50);
        romanToIntegerMap.put("LI", 51);
        romanToIntegerMap.put("LII", 52);
        romanToIntegerMap.put("LIII", 53);
        romanToIntegerMap.put("LIV", 54);
        romanToIntegerMap.put("LV", 55);
        romanToIntegerMap.put("LVI", 56);
        romanToIntegerMap.put("LVII", 57);
        romanToIntegerMap.put("LVIII", 58);
        romanToIntegerMap.put("LIX", 59);
        romanToIntegerMap.put("LX", 60);
        romanToIntegerMap.put("LXI", 61);
        romanToIntegerMap.put("LXII", 62);
        romanToIntegerMap.put("LXIII", 63);
        romanToIntegerMap.put("LXIV", 64);
        romanToIntegerMap.put("LXV", 65);
        romanToIntegerMap.put("LXVI", 66);
        romanToIntegerMap.put("LXVII", 67);
        romanToIntegerMap.put("LXVIII", 68);
        romanToIntegerMap.put("LXIX", 69);
        romanToIntegerMap.put("LXX", 70);
        romanToIntegerMap.put("LXXI", 71);
        romanToIntegerMap.put("LXXII", 72);
        romanToIntegerMap.put("LXXIII", 73);
        romanToIntegerMap.put("LXXIV", 74);
        romanToIntegerMap.put("LXXV", 75);
        romanToIntegerMap.put("LXXVI", 76);
        romanToIntegerMap.put("LXXVII", 77);
        romanToIntegerMap.put("LXXVIII", 78);
        romanToIntegerMap.put("LXXIX", 79);
        romanToIntegerMap.put("LXXX", 80);
        romanToIntegerMap.put("LXXXI", 81);
        romanToIntegerMap.put("LXXXII", 82);
        romanToIntegerMap.put("LXXXIII", 83);
        romanToIntegerMap.put("LXXXIV", 84);
        romanToIntegerMap.put("LXXXV", 85);
        romanToIntegerMap.put("LXXXVI", 86);
        romanToIntegerMap.put("LXXXVII", 87);
        romanToIntegerMap.put("LXXXVIII", 88);
        romanToIntegerMap.put("LXXXIX", 89);
        romanToIntegerMap.put("XC", 90);
        romanToIntegerMap.put("XCI", 91);
        romanToIntegerMap.put("XCII", 92);
        romanToIntegerMap.put("XCIII", 93);
        romanToIntegerMap.put("XCIV", 94);
        romanToIntegerMap.put("XCV", 95);
        romanToIntegerMap.put("XCVI", 96);
        romanToIntegerMap.put("XCVII", 97);
        romanToIntegerMap.put("XCVIII", 98);
        romanToIntegerMap.put("XCIX", 99);
        romanToIntegerMap.put("C", 100);
    }

    public RomanNumber(String number) {
        super(number);
    }

    @Override
    public int getIntValue() {
        return romanToIntegerMap.get(number);
    }

    @Override
    public String getStringValue() {
        for(String key: romanToIntegerMap.keySet()) {
            if(romanToIntegerMap.get(key) == Integer.parseInt(number)) {
                return key;
            }
        }
        throw new InputMismatchException("Число находится в не рамках римского числа для данного калькулятора: " + number);
    }

    public static boolean isRomanNumber(String number) {
        return romanToIntegerMap.containsKey(number.toUpperCase());
    }

}
