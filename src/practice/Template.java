package practice;
import java.util.HashSet;
import java.util.Set;


public class Template {
    public static void main(String[] args) {
        Set<Character> hs = new HashSet<Character>();
        hs.add('h');
        hs.add('5');
        hs.add('6');
        hs.remove('h');
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

        int foo = Integer.parseInt("5");
//        int intValue1 = 1;
//        int intValue2 = 2;
        System.out.println(foo);


        short a = 10;
        Object b = a;
        Short c = 10;
        int d = 10;

        System.out.println(Short.class.isInstance(a)); // true
        System.out.println(b instanceof Short); // true
        System.out.println(c instanceof Short); // true
        Boolean isValid = d == 110;
        System.out.println(isValid);
        System.out.println((double)d/4);

    }
}
