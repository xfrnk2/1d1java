package boj.p1k.p1800;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1854 {
    static int n, m, k;
    static PriorityQueue<Integer>[] pqArr;
    static ArrayList<Node>[] graph;


    static class Node {
        int to, cost;

        Node (int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "to=" + to +
                    ", cost=" + cost +
                    '}';
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        pqArr = new PriorityQueue[n + 1];
        graph = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            pqArr[i] = new PriorityQueue<Integer>(Collections.reverseOrder());
            graph[i] = new ArrayList<>();
        }
        pqArr[1].add(0);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(in.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, c));
        }
        dijkstra();


    }


    public static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {

            public int compare(Node n1, Node n2) {
                return n1.cost - n2.cost;
            }
        });
        pq.add(new Node(1, 0));


        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            for (Node next: graph[cur.to]) {
                int costSum = cur.cost + next.cost;
                if (pqArr[next.to].size() >= k &&
                        pqArr[next.to].peek() <= costSum) {
                    continue;
                }
                if (pqArr[next.to].size() == k) pqArr[next.to].poll();

                pqArr[next.to].add(costSum);
                pq.add(new Node(next.to, costSum));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n+1; i++) {

            sb.append((pqArr[i].size() < k ? -1 : pqArr[i].poll()) + "\n");
        }
        System.out.println(sb.toString());

    }
}


