import java.util.Scanner;

public class RobinHood {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();  // Number of test cases
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();  // Total population
            int[] a = new int[n];  // Wealth of each person
            
            long totalWealth = 0;  // Sum of all wealth
            int maxWealth = 0;     // Maximum wealth in the town
            
            for (int j = 0; j < n; j++) {
                a[j] = sc.nextInt();
                totalWealth += a[j];
                maxWealth = Math.max(maxWealth, a[j]);
            }
            
            // If there's only one person, Robin Hood can't appear
            if (n == 1) {
                result.append("-1\n");
                continue;
            }
            
            // Calculate total wealth needed to make more than half of the population unhappy
            long requiredWealth = (n - 1L) * maxWealth;
            
            if (totalWealth < requiredWealth) {
                // Calculate how much gold needs to be added
                result.append(requiredWealth - totalWealth).append("\n");
            } else {
                // No additional gold is required, Robin Hood will already appear
                result.append("0\n");
            }
        }
        
        // Output the result
        System.out.println(result.toString());
        
        sc.close();
    }
}
//2014c robin hood in town