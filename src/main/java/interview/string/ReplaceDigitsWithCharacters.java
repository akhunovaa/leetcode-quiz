package interview.string;

public class ReplaceDigitsWithCharacters {

    public static void main(String[] args) {
        String s = "a1b2c3d4e";
        String answer = replaceDigits(s);
        System.out.println("Answer: " + answer);
    }


    static String replaceDigits(String s) {
        char[] result = new char[s.length()];

        result[0] = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                result[i] = s.charAt(i);
                i++;
                if (i == s.length()) break;
            }
            int shift = Character.getNumericValue(s.charAt(i));
            char replace = (char) (s.charAt(i - 1) + shift);
            result[i] = replace;
        }

        return String.valueOf(result);
    }

    public String reversePrefix(String word, char ch) {
        char[] chArr = word.toCharArray();

        int i = 0, len = chArr.length;
        while (i < len && chArr[i] != ch) i++;
        if (i >= len) return word;
        for (int j = 0; j < i; j++, i--) {
            char temp = chArr[j];
            chArr[j] = chArr[i];
            chArr[i] = temp;
        }
        return String.valueOf(chArr);
    }
}
