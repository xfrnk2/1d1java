import java.util.*;


public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int a = 0 ; int b; char o;
        int count = 0;

        int res = 0;

        while(sc.hasNext()) {
            if(count == 0) a = sc.nextInt();
            else a = res;
            o = sc.next().charAt(0);
            if(o == '=') break;
            b = sc.nextInt();
            res = calc(a,o,b);
            count++;

        }

        System.out.println(res);

    }

    public static int calc(int a, char o, int b) {
        switch(o) {
        case '+':
            return a + b;
        case '-':
            return a - b;
        case '*':
            return a * b;
        case '/':
            return a / b;
        }

        return -1;

    }

}
