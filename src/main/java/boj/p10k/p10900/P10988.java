package boj.p10k.p10900;


import java.util.*;
 
class P10988 {
  public static void main(String[] args) throws Exception {
      Scanner sc = new Scanner(System.in);
      String a = sc.next();
      int mid = (a.length()/2);
      int res = 1;
      for(int i = 0; i < mid; i++) {
          if(a.charAt(i) != a.charAt(a.length() - 1 - i)) {
              res = 0;
              }         
          }
      System.out.println(res);
      }
}
