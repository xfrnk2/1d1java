package boj.p2k.p2700;

import java.util.Scanner;

public class P2744 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String str = scanner.nextLine();

    char[] arr;
    arr = str.toCharArray();

    for(int i = 0; i < arr.length; i++) {
      if(65 <= arr[i] && arr[i] <= 90) {
        arr[i] = (char) (arr[i] + 32);
        continue;
      }
      if(97 <= arr[i] && arr[i] <= 122) {
        arr[i] = (char) (arr[i] - 32);
        continue;
      }
    }
    System.out.println(arr);
  }
}
