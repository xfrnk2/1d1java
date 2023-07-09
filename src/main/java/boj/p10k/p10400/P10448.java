package boj.p10k.p10400;


import java.io.*;
import java.util.*;


public class P10448 {

    public static void main(String[] args) throws Exception {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            boolean flag = false;
         
            while(t-- > 0){
                int v = sc.nextInt();
              
                for(int i=1; i<=44; i++) {
                    for(int j=1; j<=44; j++) {
                        for(int k=1; k<=44; k++) {
                            if ((i*(i+1)/2) + (j*(j+1)/2) + (k*(k+1)/2) == v) {
                                flag = true;
                                break;
                            }
                        }
                        if(flag) break;
                    }
                    if(flag) break;
                }
                System.out.println(flag ? 1 : 0);
                flag = false;
            }
    }
}
