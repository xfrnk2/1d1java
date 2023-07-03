package boj.p1k.p1700;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1781 {
    static int N;


    static class Node {
        int cup , d;
        public Node(int dd, int cc) {
            super();
            this.d = dd;
            this.cup = cc;
        }


    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        StringTokenizer st;

        List<Node> li = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            int dd = Integer.parseInt(st.nextToken());
            int cc = Integer.parseInt(st.nextToken());
            li.add(new Node(dd, cc));
        }
        Collections.sort(li, new Comparator<Node>() {

            @Override
            public int compare(Node o1, Node o2) {

                int p = o1.d - o2.d;
                if (p == 0) {
                    return o2.cup - o1.cup;
                }
                return p;
            }


        });

        int ans = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            if (li.get(i).d > pq.size()) {
                pq.add(li.get(i).cup);
                ans += li.get(i).cup;
                continue;
            }
            if (li.get(i).d == pq.size()) {
                if (pq.peek() < li.get(i).cup) {
                    ans -= pq.poll();
                    pq.add(li.get(i).cup);
                    ans += li.get(i).cup;
                }
            }
        }


        System.out.println(ans);
    }

}
