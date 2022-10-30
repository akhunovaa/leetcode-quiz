package interview;

public class ValidPalindrome {

    public static void main(String[] args) {
        // String input =  "A man, a plan, a canal: Panama"; // "race a car"
        String input =  "race a car";
        boolean answer = isPalindrome(input);
        System.out.println("Answer: " + answer);
    }

    public static boolean isPalindrome(String s) {
        char[] characters = new char[s.length()];
        char[] sc = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isAlphabetic(c) || Character.isDigit(c)) {
                characters[characters.length - 1 - i] = c;
                sc[i] = c;
            } else {
                characters[characters.length - 1 - i] = ' ';
                sc[i] = ' ';
            }
        }
        String reversed = new String(characters).trim().replaceAll(" ", "");
        String check = new String(sc).trim().replaceAll(" ", "");
        return check.equalsIgnoreCase(reversed);
    }
}
