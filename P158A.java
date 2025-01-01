import java.util.Scanner;
//submitted
public class P158A 
{

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = s.nextInt();
        }
        int main_Score = scores[k - 1];
        int advancingCount = 0;
        for (int score : scores) {
            if (score >= main_Score && score > 0) {
                advancingCount++;
            }
        }
        System.out.println(advancingCount);

        s.close();
    }
}
