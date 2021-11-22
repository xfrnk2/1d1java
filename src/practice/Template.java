package practice;
import java.util.HashSet;
import java.util.Set;

public class Template {
    public static void main(String[] args) {
        Set<Character> hs = new HashSet<Character>();
        hs.add('h');
        hs.add('5');
        System.out.println(hs);
        System.out.println(hs.size());

        Set<String> Ss = new HashSet<String>();
        Ss.add("hi");
        Ss.add("hello");
        Ss.add("안녕");
        Ss.add("안녕");
        Ss.add("안녕");
        System.out.println(Ss.size());
        System.out.println(Ss);
    }
}
