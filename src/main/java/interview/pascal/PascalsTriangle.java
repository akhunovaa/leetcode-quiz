package interview.pascal;

import java.util.ArrayList;
import java.util.List;


public class PascalsTriangle {

    public static void main(String[] args) {
        PascalsTriangle pascal = new PascalsTriangle();
        List<List<Integer>> triangle = pascal.generate(10);
        System.out.println(triangle);
    }

// Time Complexity: O(n^2)
// Space Complexity: O(n^2)
// columnNumber = previous_number_in_row * (row–column) / column
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> trinagle = new ArrayList<>(numRows);
        if (numRows <= 0) {
            return trinagle;
        }
        for (int i = 1; i <= numRows; i++) {
            int columnNumber = 1;
            List<Integer> row = new ArrayList<>(i);
            for (int j = 1; j <= i; j++) {
                row.add(columnNumber);
                columnNumber = columnNumber * (i - j) / j; // column = 1 * (3 - 1) / 1
            }
            trinagle.add(row);
        }
        return trinagle;
    }
}
