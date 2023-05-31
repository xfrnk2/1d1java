package boj.p2k.p2800;


import java.util.*;
 
public class P2858 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int r = s.nextInt();
        int b = s.nextInt();
        
        int l, w;
        
        for(l = 1 ; ; l++) {
            
            if(b % l == 0) {
                w = b / l;
 
                if(l*2 + w*2 + 4 == r) {
                    System.out.println((w+2) + " " + (l+2));
                    break;
                }
            }
        }
    }
}
