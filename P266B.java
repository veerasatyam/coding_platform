import java.util.Scanner;
//submitted
public class P266B {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt(); 
        int t = s.nextInt();
        s.nextLine();
        char[] queue = s.nextLine().toCharArray(); 
        
        for (int i = 0; i < t; i++) {
            for (int j = 0; j <queue.length-1; j++) {
                if (queue[j] == 'B' && queue[j + 1] == 'G') {
                    char ch = queue[j];
                    queue[j] = queue[j + 1];
                    queue[j + 1] = ch;
                    j++;
                }
            }
        }
        System.out.println( new String(queue));
        s.close();
    }
}
