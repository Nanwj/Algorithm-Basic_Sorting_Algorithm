import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Multi_Map_Try {

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
//        System.out.println(map.put(4, "qwe"));
//        System.out.println(map.put(4, "abc"));

        Set<Integer> set = new HashSet();
        set.add(5);
        System.out.println(set.add(5));
    }
}
