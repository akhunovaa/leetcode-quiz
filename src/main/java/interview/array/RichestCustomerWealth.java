package interview.array;

public class RichestCustomerWealth {

    public static void main(String[] args) {
        int[][] input = {{1,5}, {7,3},{3,5}};
        int answer = maximumWealth(input);
        System.out.println("Answer: " + answer);
    }

    public static int maximumWealth(int[][] accounts) {
        int wealth = 0;
        for(int i = 0; i < accounts.length; i++) {
            int maximumWealth = 0;
            for(int j = 0; j < accounts[i].length; j++) {
                maximumWealth += accounts[i][j];
            }
            if(maximumWealth > wealth) {
                wealth = maximumWealth;
            }
        }
        return wealth;
    }
}
