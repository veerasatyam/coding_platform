import java.util.Scanner;
//submitted
public class P59A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int upperCaseCount = 0;
        int lowerCaseCount = 0;
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) {
                lowerCaseCount++;
            } else if (Character.isUpperCase(c)) {
                upperCaseCount++;
            }
        }
        CaseConverter converter = new CaseConverter();
        converter.convertCase(s, lowerCaseCount, upperCaseCount);
        
        sc.close();
    }
}

class CaseConverter {
    void convertCase(String s, int lowerCount, int upperCount) {
        if (upperCount > lowerCount) {
            System.out.println(s.toUpperCase());
        } else {
            System.out.println(s.toLowerCase());
        }
    }
}
