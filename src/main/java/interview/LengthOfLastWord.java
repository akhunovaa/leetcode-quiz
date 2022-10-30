package interview;

public class LengthOfLastWord {

    public static void main(String[] args) {
        String input = "   fly me   to   the moon  "; // "   fly me   to   the moon  "  "luffy is still joyboy"
        // String input  = "luffy is still joyboy"; // "   fly me   to   the moon  "  "luffy is still joyboy"
        int answer = lengthOfLastWord(input);
        System.out.println("Answer: " + answer);
    }

    public static int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        String trim = s.trim();
        int answer = 0;
        for (int i = 0; i < trim.length(); i++) {
            char c = trim.charAt(i);
            if (c != ' ') {
                answer++;
            } else {
                answer = 0;
            }
        }
        return answer;
    }
}
