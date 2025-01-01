import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//  can't find the error 
public class P2036C {
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }

        int t = s.nextInt();
        while (t-- > 0) {
            String str = s.next();
            char[] a = str.toCharArray();
            int q = s.nextInt();
            final String sub = "1100";
            
            while (q-- > 0) {
                int i = s.nextInt() - 1;
                char v = s.next().charAt(0);

                if (i >= 0 && i < str.length()) {
                    a[i] = v;
                    
                    boolean found = false;
                    for (int j = Math.max(i - 3, 0); j <= Math.min(i + 3, a.length - 4); j++) {
                        String window = new String(a, j, 4);
                        if (window.equals(sub)) {
                            found = true;
                            break;
                        }
                    }
                    
                    if (found)  System.out.println("YES");
                    else  System.out.println("NO");

                } else  System.out.println("NO");
            }
        }
        s.close();
    }
}
// for(int j = Math.max(i-3,0);j<=Math.min(i+3,str.len-1);i++)
// {
//String window = new String(a,j,4);
//if(window.equals(sub)){
// found = true;
//break;
//}
//}
