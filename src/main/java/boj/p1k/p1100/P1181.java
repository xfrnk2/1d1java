import java.io.*;
import java.util.*;



class P1181 {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int n = Integer.parseInt(sc.nextLine());
    String[] inputStrArray = new String[n];
    for (int i = 0; i < n; i ++) {
        inputStrArray[i] = sc.nextLine();
    }

    
    
    String[] strArray = Arrays.stream(inputStrArray).distinct().toArray(String[]::new);
    Arrays.sort(strArray);
    Arrays.sort(strArray, (String s1, String s2) -> s1.length() - s2.length());

    for(String elem : strArray) {
      System.out.println(elem);
    }

    
  }
}