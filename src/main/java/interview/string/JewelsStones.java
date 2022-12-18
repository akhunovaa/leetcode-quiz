package interview.string;

public class JewelsStones {

    public static void main(String[] args) {
        String jewels = "aA", stones = "aAAbbbb";
        int answer = numJewelsInStones(jewels, stones);
        System.out.println("Answer: " + answer);
    }


    static int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        for (char c : stones.toCharArray()) {
            if (jewels.indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }


}
