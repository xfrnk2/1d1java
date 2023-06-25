package boj.p1k.p1700;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1707 {
    static int N, U, V;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            U = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());
            graph = new ArrayList[U + 1];
            for (int j = 0; j < U + 1; j++) {
                graph[j] = new ArrayList<>();
            }

            for (int j = 0; j < V; j++) {
                st = new StringTokenizer(in.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                graph[from].add(to);
                graph[to].add(from);
            }

            sb.append(check() ? "YES" : "NO").append("\n");

        }
        System.out.println(sb);
    }

    private static boolean check() {
        int[] rec = new int[U + 1];
        Arrays.fill(rec, -1);
        for (int i = 1; i < U + 1; i++) {
            Queue<Integer> q = new LinkedList<>();
            if (rec[i] == -1) {
                rec[i] = 0;
                q.add(i);
            }
            while (!q.isEmpty()) {
                int cur = q.poll();
                for (Integer nxt:
                     graph[cur]) {

                    if (rec[nxt] == -1) {
                        rec[nxt] = rec[cur] ^ 1;
                        q.add(nxt);
                        continue;
                    }

                    if (rec[cur] == rec[nxt]) {
                        return false;
                    }


                }


            }


        }
        return true;
    }
}
