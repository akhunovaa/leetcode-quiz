package interview.string;

public class SortCharactersByFrequency {

    public static void main(String[] args) {
        String input = "cccaaa"; // cccaaa => output: "aaaccc" tree => output: "eert" Aabb => output: "bbAa"
        String answer = frequencySort(input);
        System.out.println("Answer: " + answer);
    }

    static String frequencySort(String s) {
        if (s == null || s.length() < 1) return s;

        char[] arr = new char[256];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)]++;
        }

        StringBuilder sb = new StringBuilder();
        int max = -1;
        while (max != 0) {
            max = -1;
            char maxi = 0;
            for (char i = 0; i < arr.length; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                    maxi = i;
                }
            }
            for (int i = 0; i < max; i++) {
                sb.append(maxi);
            }
            arr[maxi] = 0;
        }
        return sb.toString();
    }

}
