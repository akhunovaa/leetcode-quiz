package easy;

import enumm.ClassD;
import enumm.ClassF;

import java.util.*;

/*
    Input: root = [1,2,3], targetSum = 5
    Output: false
    Explanation: There two root-to-leaf paths in the tree:
    (1 --> 2): The sum is 3.
    (1 --> 3): The sum is 4.
    There is no root-to-leaf path with sum = 5.
 */
/*
    5,4,8,11,null,13,4,7,2,null,null,null,1
 */
public class PathSum {

    public static final void main(String[] args) {

        ClassD classX = new ClassF();
        ((ClassF)classX).main(new String[] {});
        classX.main(new String[] {});
//
//       int a = 5;
//       int b = 5;
//
//        System.out.println(a == b);
//
//        Integer c = 10;
//        Integer d = 10;
//
//        System.out.println(c == d);
//
//        Integer x = 128;
//        Integer y = 128;
//
//        System.out.println(x == y);

//
//        // starting time
//        start = System.currentTimeMillis();
//
//        runLinkedList();
//
//        // ending time
//        end = System.currentTimeMillis();
//
//        System.out.println("Counting runLinkedList to 10000000 takes " + (end - start) + "ms");
//
//        PathSum pathSum = new PathSum();
//        Thread first = new Thread(() -> {
//            // starting time
//            long start = System.currentTimeMillis();
//
//            pathSum.runArrayList();
//
//            // ending time
//            long end = System.currentTimeMillis();
//
//            System.out.println("Counting runArrayList to 10000000 takes " + (end - start) + "ms");
//        });
//
//        Thread second = new Thread(() -> {
//            // starting time
//            long start = System.currentTimeMillis();
//
//            pathSum.runLinkedList();
//
//            // ending time
//            long end = System.currentTimeMillis();
//
//            System.out.println("Counting runLinkedList to 10000000 takes " + (end - start) + "ms");
//        });
//        second.start();
//        first.start();

//        Set<Number> set = new TreeSet<>(Comparator.comparingInt(Number::intValue));
//
//        set.add(5);
//        set.add(5L);
//        set.add(5.0);
//        set.add(6.0);
//
//        System.out.println(set.size());

//        byte a = 5;
//        byte b = 6;
//
//        pathSum.foo(a, b);
//        Artist artist = new RockStar();
//        artist.sing();
//        artist.dance();

    }

    public void foo(Byte a, Byte b) {
        System.out.println("Byte Byte");
    }
    public void foo(long a, short b) {
        System.out.println("long short");
    }



    public void foo(byte... args) {
        System.out.println("byte... args");
    }


    private void runArrayList() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
           list.add(i);
        }
    }

    private void runLinkedList() {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10000000; i++) {
           list.add(i);
        }
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return sum == root.val;
        }

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
