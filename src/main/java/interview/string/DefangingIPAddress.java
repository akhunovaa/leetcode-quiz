package interview.string;

public class DefangingIPAddress {

    public static void main(String[] args) {
        String s = "1.1.1.1";
//        String answer = defangIPaddr(s);
//        System.out.println("Answer: " + answer);
        int answer = finalValueAfterOperations(new String[]{"--X","X++","X++"});
        System.out.println("Answer: " + answer);
    }

    static String defangIPaddr(String address) {
        char[] charArray = new char[address.length() + (2 * 3)];
        for (int i = 0, y = 0; i < address.length(); i++, y++) {
            char current = address.charAt(i);
            if (current == '.') {
                System.out.println("current: " + i);
                charArray[y++] = '[';
                charArray[y++] = current;
                charArray[y] = ']';
            } else {
                charArray[y] = current;
            }
        }
        return String.valueOf(charArray);
    }

    public static int finalValueAfterOperations(String[] operations) {
        final int PLUS = 43;
        final int MINUS = 45;
        int total = 0;
        for(int i = 0; i < operations.length; i++) {
            if(operations[i].charAt(0) == PLUS) {
                ++total;
            } else if(operations[i].charAt(0) == MINUS) {
                --total;
            } else if(operations[i].charAt(1) == PLUS) {
                total++;
            } else {
                total--;
            }
        }
        return total;
    }

}
