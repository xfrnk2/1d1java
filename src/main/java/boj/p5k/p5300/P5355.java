package boj.p5k.p5300;


import java.util.*;
import java.io.*;


public class P5355 {
    
    
       public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < n; i++) {
            String input = sc.nextLine();
            cal(input);
           }
        }
    
    static void cal(String str) {
        String[] arr = str.split(" ");
            float calcNum = Float.parseFloat(arr[0]); 

            for(int j = 1; j < arr.length; j++) {
                switch(arr[j]) {
                    case "@": calcNum *= 3;
                        break;
                    case "%": calcNum += 5;
                        break;
                    case "#": calcNum -= 7;
                        break;
                    default:
                        continue;
                }
            }
            System.out.println(String.format("%.2f", calcNum));
    }
}
