import java.util.Scanner;
//submitted
public class P344A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String[] magnets = new String[n];
        for (int i = 0; i < n; i++) {
            magnets[i] = s.next();
        }
        int group_magnets = 1;
        for (int i = 1; i < n; i++) 
        {
            if ((magnets[i].equals(magnets[i - 1]))==false) 
            {
                group_magnets++;
            }
        }
        System.out.println(group_magnets);
        
        s.close();
    }
}

