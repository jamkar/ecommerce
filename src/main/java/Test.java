import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("efg");
        list.add("hij");
        list.add("qwe");

        for (String s : list) {
            System.out.println(s);
        }
        System.out.println();

//        for (String s : list) {
//            if (s.equals("abc")) {
//                list.remove(s);
//            }
//        }

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            if (s.equals("abc")) {
                iterator.remove();
            }
        }

        for (Iterator<String> iterator1 = list.iterator(); iterator1.hasNext();) {
            String s = iterator1.next();
            if (s.equals("efg"))
                iterator1.remove();
        }

        for (String s : list) {
            System.out.println(s);
        }
        System.out.println();

    }
}
