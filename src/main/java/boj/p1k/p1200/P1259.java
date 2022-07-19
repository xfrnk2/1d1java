import java.util.*;
import java.io.*;



class P1259 {

  private static Boolean palindrome(String input) {
    int n = input.length();
    String[] array = input.split("");
    
    Stack<String> stack = new Stack<>();
    for(String str : array) {
        stack.push(str);
    }
    
    for (int i = 0; i < n; i ++) {
      if (!stack.pop().equals(array[i])) {
        return false;
      }
    }
    return true;
  }

  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while (true) {
      String input = br.readLine();
      if (input.equals("0")) {
        break;
      }
      if (palindrome(input)) {
        System.out.println("yes");
      } else {
        System.out.println("no");
      }
      
    }
  }
}