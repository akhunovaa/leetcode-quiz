package interview.string;

public class DecryptStringAlphabetIntegerMapping {

    public static void main(String[] args) {
        String s = "10#11#12"; // jkab
        String answer = freqAlphabets(s);
        System.out.println("Answer: " + answer);
    }

    static String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int i = 0;
        while (i < n) {
            boolean isBig = i + 2 < n && s.charAt(i + 2) == '#';
            if (isBig) {
                char c = (char) ('a' + Integer.parseInt(s.substring(i, i + 2)) - 1);
                sb.append(c);
                i += 3;
            } else {
                char c = (char) ('a' + s.charAt(i) - '1');
                sb.append(c);
                i++;
            }
        }
        return sb.toString();
    }

}
