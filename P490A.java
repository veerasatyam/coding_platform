import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class P490A {
    public static void main(String[] args) {
        Scanner s = null;
        
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            s = new Scanner(System.in);
        }
        int n=s.nextInt();
        int[] a = new int[n];
        int i,t1=0,t2=0,t3=0;
        ArrayList<Integer> p = new ArrayList<>();
        ArrayList<Integer> m = new ArrayList<>();
        ArrayList<Integer> pys = new ArrayList<>();
        for(i=0;i<n;i++) 
        {
            a[i]=s.nextInt();
            if (a[i]==1) 
            {
                t1++;
                p.add(i+1);
            }
            else if(a[i]==2) 
            {
                t2++;
                m.add(i+1);
            }
            else 
            {
                t3++;
                pys.add(i+1);
            }
        }
        int No_of_teams=Math.min(t1,Math.min(t2, t3));
        System.out.println(No_of_teams);
        for(i=0;i<No_of_teams;i++)  System.out.println(p.get(i) + " " + m.get(i) + " " + pys.get(i));
        s.close();
    }
}
