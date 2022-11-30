package interview.string;

public class DefangingIPAddress {

    public static void main(String[] args) {
        String s = "1.1.1.1";
        String answer = defangIPaddr(s);
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

}
