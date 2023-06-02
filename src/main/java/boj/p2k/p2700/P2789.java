package boj.p2k.p2700;


import java.util.*;
 

public class P2789 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
 
        char[] arr = "CAMBRIDGE".toCharArray();
 
        for (int j = 0; j < arr.length; j++) {
            if (str.indexOf(arr[j]) > -1) {
                str = str.replaceAll(String.valueOf(arr[j]), "");
            }
        }
 
        System.out.println(str);
    }
}
 
