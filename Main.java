import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        sc.nextLine(); // skip the word "shuffled"
        String[] shuffled = new String[n];
        for (int i = 0; i < n; i++) {
            shuffled[i] = sc.nextLine();
        }

        sc.nextLine(); // skip the word "original"
        String[] original = new String[n];
        for (int i = 0; i < n; i++) {
            original[i] = sc.nextLine();
        }

        System.out.println(minCutInsertOperations(n, shuffled, original));
        sc.close();
    }

    private static int minCutInsertOperations(int n, String[] shuffled, String[] original) {
        // Map each instruction in the original list to its index
        Map<String, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(original[i], i);
        }

        // Convert shuffled list to their original order indices
        int[] order = new int[n];
        for (int i = 0; i < n; i++) {
            order[i] = indexMap.get(shuffled[i]);
        }

        // Count contiguous increasing segments
        int segments = 1;
        for (int i = 1; i < n; i++) {
            if (order[i] != order[i - 1] + 1) {
                segments++;
            }
        }

        // Each cut-and-insert merges two segments
        return segments - 1;
    }
}
