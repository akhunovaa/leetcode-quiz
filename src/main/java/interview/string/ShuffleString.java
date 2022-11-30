package interview.string;

public class ShuffleString {

    public static void main(String[] args) {
        String s = "aiohn"; // nihao
        int[] indices = {3,1,4,2,0};
        String answer = restoreString(s, indices);
        System.out.println("Answer: " + answer);
    }

    static String restoreString(String s, int[] indices) {
        if (s.length() != indices.length) {
            return s;
        }
        char[] charArray = new char[indices.length];
        int start = 0;
        int end = indices.length - 1;
        while (start <= end) {
            charArray[indices[start]] = s.charAt(start);
            charArray[indices[end]] = s.charAt(end);
            start++;
            end--;
        }
        return String.valueOf(charArray);
    }
}
