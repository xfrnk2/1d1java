package boj.p10k.p10800;


import java.util.*;

public class P10811 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int[] arr = new int[a];

        for (int i = 0; i < a; i++) {
            arr[i] = i+1;
        }

        for (int i = 0; i < b; i++) {
            int c = sc.nextInt();
            int d = sc.nextInt();

            ArrayList<Integer> list = new ArrayList<>();

            for (int j = c-1; j < d; j++) {
                list.add(arr[j]);
            }

            int e = 0;

            for (int j = d-1; j >= c-1; j--) {
                arr[j] = list.get(e);
                e++;
            }
        }


        for (int i = 0; i < a; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
