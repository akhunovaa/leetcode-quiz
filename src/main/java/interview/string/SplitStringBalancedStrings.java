package interview.string;

public class SplitStringBalancedStrings {

    public static void main(String[] args) {
        String s = "RLRRLLRLRL";
        int answer = balancedStringSplit(s);
        System.out.println("Answer: " + answer);
    }

    // idea add -1 for R and +1 for L to the curr
    // increment count whenever it becomes 0 as it indicates end of the balanced substring
    static int balancedStringSplit(String s) {
        int count = 0, curr = 0;
        for(char ch : s.toCharArray()){
            if(ch == 'R')
                curr--;
            else
                curr++;
            if(curr == 0)
                ++count;
        }
        return count;
    }
}
