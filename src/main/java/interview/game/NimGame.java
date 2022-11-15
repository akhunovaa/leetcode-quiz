package interview.game;

/**
 * <b>Nim Game</b>
 * <p></p>
 * You are playing the following Nim Game with your friend:
 * Initially, there is a heap of stones on the table.
 * You and your friend will alternate taking turns, and you go first.
 * On each turn, the person whose turn it is will remove 1 to 3 stones from the heap.
 * The one who removes the last stone is the winner.
 * Given n, the number of stones in the heap, return true if you can win the game assuming both you and your friend
 * play optimally, otherwise return false.
 * <p></p>
 * <b>Example 1:</b>
 * <b>Input:</b> n = 4
 * <b>Output:</b> false
 * <b>Explanation:</b> These are the possible outcomes:
 * 1. You remove 1 stone. Your friend removes 3 stones, including the last stone. Your friend wins.
 * 2. You remove 2 stones. Your friend removes 2 stones, including the last stone. Your friend wins.
 * 3. You remove 3 stones. Your friend removes the last stone. Your friend wins.
 * In all outcomes, your friend wins.
 * <p></p>
 * <b>Example 2:</b>
 * <b>Input:</b> n = 1
 * <b>Output:</b> true
 * <p></p>
 * <b>Example 3:</b>
 * <b>Input:</b> n = 2
 * <b>Output:</b> true
 */
public class NimGame {

    public static void main(String[] args) {
        int input = 5;
        boolean answer = canWinNim(input);
        System.out.println("Answer: " + answer);
    }

    // Time Complexity: O(1)
    // Space Complexity: O(1)
    // побеждаем в игре в случае если камней в куче не делится на 4, если делится - однозначная победа
    // n = 4, 8, 12, 16, …
    public static boolean canWinNim(int n) {
        return (n % 4 != 0);
    }
}
