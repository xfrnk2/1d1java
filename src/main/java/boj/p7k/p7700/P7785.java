package boj.p7k.p7700;


import java.util.*;
import java.io.*;


public class P7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s, " ");
            String name = st.nextToken();
            String state = st.nextToken();

            if (state.equals("enter")) {
                set.add(name);
                continue;
            }
            if (state.equals("leave")){
                set.remove(name);
            }
        }
        ArrayList<String> li = new ArrayList(set);
        Collections.sort(li);

        for (int i = li.size()-1; i >= 0; i--) {
            bw.write(li.get(i) + "\n");
        }
        bw.flush();
    }
}
