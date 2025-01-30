import java.util.*;

public class T {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String url = s.nextLine();
        s.close();

        String query = url.split("\\?")[1];
        String[] params = query.split("&");
        
        Map<String, String> paramMap = new HashMap<>();
        
        for (String param : params) {
            String[] keyValue = param.split("=");
            paramMap.put(keyValue[0], keyValue[1]);
        }
        
        System.out.println("username: " + paramMap.get("username"));
        System.out.println("pwd: " + paramMap.get("pwd"));
        System.out.println("profile: " + paramMap.get("profile"));
        System.out.println("role: " + paramMap.get("role"));
        System.out.println("key: " + paramMap.get("key"));
    }
}
