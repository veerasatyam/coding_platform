import java.util.HashSet;

static int distinct(int arr[]) {
    HashSet<Integer> s = new HashSet<>();
    for(int  a : arr) s.add(a);
    return s.size();
}