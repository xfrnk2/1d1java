package boj.p12k.p12600;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P12605 {
    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());

        Stack<String> stack = new Stack<>();


        for(int i=0;i<t;i++) {
            String input = in.readLine();
            String[] arr = input.split(" ");
            for (int j = 0; j < arr.length; j++) {
                stack.push(arr[j]);
            }


            System.out.print("Case #"+(i+1)+": ");
            while(!stack.isEmpty()){
                System.out.print(stack.pop());
                System.out.print(" ");
                if(stack.isEmpty()) System.out.println();
            }
        }
    }
}
