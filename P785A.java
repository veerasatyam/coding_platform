
import java.util.HashMap;
import java.util.Scanner;

public class P785A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        HashMap<String,Integer> polyhedrons = new HashMap<>();
        polyhedrons.put("Tetrahedron", 4);
        polyhedrons.put("Cube", 6);
        polyhedrons.put("Octahedron", 8);
        polyhedrons.put("Dodecahedron", 12);
        polyhedrons.put("Icosahedron",20 );
        int n=s.nextInt();
        int total_faces=0;
        while(n-->0)
        {
         String shape =s.next();
         Integer value = polyhedrons.get(shape);
         total_faces+=value;
        }
        System.out.println(total_faces);
        s.close();

    }
}
