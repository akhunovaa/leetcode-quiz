package interview;

import java.util.HashSet;
import java.util.Set;

/*
 * Algorithm:
 * ----------------------------------------------------------------------------------------
 * 1. Simple `backtracking` approach.
 * 2. The idea is to add characters one by one of the input string (tiles) to a temporary
 * string which is further added to a HashSet to avoid repeatation.
 * 3. While doing so the characters which are once visited should be skipped for that
 * maintain a `visited` array of size same as that of the entire string.
 * 4. In each recursion call, add the temporary strings into the HashSet.
 * 5. When the recursion call is over, the set is filled with all strings, which includes
 * the `null` as well.
 * 6. Hence return the size of the set -1. That `-1` corresponds to the `null` string.
 * ----------------------------------------------------------------------------------------
 */
public class Tiles {

    public static void main(String[] args) {
        String input = "AAABBC";// AAABBC = 188
        int answer = numTilePossibilities(input);
        System.out.println("Answer: " + answer);
    }

// Input: tiles = "AAB"
// Output: 8
// Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
    public static int numTilePossibilities(String tiles) {
        Set<String> set = new HashSet<>();
        boolean[] vis = new boolean[tiles.length()];
        permute(tiles, "", set, vis);
        return set.size() - 1;
    }

    public static void permute(String tiles, String curr, Set<String> set, boolean[] vis) {
        set.add(curr);
        for (int i = 0; i < tiles.length(); i++) {
            if (!vis[i]) {
                vis[i] = true;
                permute(tiles, curr + tiles.charAt(i), set, vis);
                vis[i] = false;
            }
        }
    }

    public static int numTilePossibilities2(String tiles) {
        int[] count = new int[26];
        for (char c : tiles.toCharArray()) {
            count[c - 'A']++;
        }
        return dfs(count);
    }

    static int  dfs(int[] arr) {
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] == 0) {
                continue;
            }
            sum++;
            arr[i]--;
            sum += dfs(arr);
            arr[i]++;
        }
        return sum;
    }
}
