//Swapping min max

import java.util.*;

public class MinMax {
    public static int minMax(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int maxA = a[a.length - 1];
        int maxB = b[b.length - 1];
        int secondMaxA = a[a.length - 2];
        int secondMaxB = b[b.length - 2];
        return Math.max(maxA * maxB, maxA * secondMaxB);
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 6, 5, 1, 2};
        int[] b = new int[]{3, 4, 3, 2, 2, 5};
        System.out.println(minMax(a, b));
    }
}

//Time complexity O(log n)
//Space complexity O(n)