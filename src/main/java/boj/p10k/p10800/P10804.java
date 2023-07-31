import java.io.*;
import java.util.*;
 
public class P10804 {
  public static void main(String args[]) throws Exception{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
     
    int[] arr = new int[21];
    for(int i = 1; i < 21; i++) {
      arr[i] = i;
    }
    for(int i = 0; i < 10; i++) {
      StringTokenizer st = new StringTokenizer(in.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());       
      for(int j = 0, exclusive = (b - a) / 2; j <= exclusive; j++) {
        int tmp = arr[j + a];
        arr[a + j] = arr[b - j];
        arr[b - j] = tmp;
      }
    }
    for(int i = 1; i < 21; i++) {
      System.out.print(arr[i]+" ");
    }
  }
}
