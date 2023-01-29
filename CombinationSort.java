// Combination Sort

import java.util.*;

public class CombinationSort {

    public static void main(String[] args) {
        String[] list = {"d34", "g54", "d12", "b87", "g1", "c65", "g40", "g5", "d77"};

        // Sort the list in ascending order with respect to the first character
        Arrays.sort(list, (a, b) -> a.charAt(0) - b.charAt(0));

        // Create a map to store strings starting with the same character
        Map<Character, List<String>> map = new HashMap<>();
        for (String s : list) {
            char c = s.charAt(0);
            if (!map.containsKey(c)) {
                map.put(c, new ArrayList<>());
            }
            map.get(c).add(s);
        }

        // Sort the strings starting with the same character in descending order with respect to the number
        for (List<String> subList : map.values()) {
            Collections.sort(subList, (a, b) -> Integer.parseInt(b.substring(1)) - Integer.parseInt(a.substring(1)));
        }

        // Flatten the map into a single list
        List<String> L1 = new ArrayList<>();
        for (List<String> subList : map.values()) {
            L1.addAll(subList);
        }

        // Print L1
        System.out.println("L1: " + Arrays.toString(L1.toArray()));
        
        // Print L2
        Collections.reverse(L1);
        System.out.println("L2: " + Arrays.toString(L1.toArray()));
    }
}

//Time complexity O(log n)
//Space complexity O(n)