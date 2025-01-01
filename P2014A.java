import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P2014A {
    public static void main(String[] args) {
         Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        int t = s.nextInt();
        while(t-->0)
        {
            int n = s.nextInt();
            int k = s.nextInt();
            int[] a = new int[n];
            int hp=0;
            int gold=0,i;
            for(i=0;i<n;i++)
            {
                a[i]=s.nextInt();
                if(a[i]>=k)
                {
                    gold = gold + a[i];
                }
                if(a[i]==0)
                {
                    if(gold>0)
                    {
                        hp++;
                        gold--;
                    }
                }
            }
            System.out.println(hp);
        }
    }
}
