package boj.p2k.p2900;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P2912 {
    static int N, C, M;
    static int[] dw;

    static ArrayList<Integer>[] color;
    static Node[] tree;


    static class Node {
        int color, cnt;

        public Node(int color, int cnt) {
            this.color = color;
            this.cnt = cnt;
        }
    }

    public static int lowerBound(int target, int c) {
        if (c == 0) return 0;
        int l = 0, r = color[c].size();

        while (l < r) {
            int mid = (l + r) / 2;
            if (color[c].get(mid) < target) {
                l = mid + 1;
            } else r = mid;
        }
        return r;
    }

    public static int upperBound(int target, int c) {
        if (c == 0) return 0;
        int l = 0, r = color[c].size();

        while (l < r) {
            int mid = (l + r) / 2;
            if (color[c].get(mid) <= target) {
                l = mid + 1;
            } else r = mid;
        }
        return r;
    }

    public static Node init(int l, int r, int node) {
        if (l == r) return tree[node] = new Node(dw[l], 1);
        int mid = (l + r) / 2;
        Node left = init(l, mid, node * 2);
        Node right = init(mid + 1, r, node * 2 + 1);

        int lc = upperBound(r, left.color) - lowerBound(l, left.color);

        if (left.color == right.color) {
            return tree[node] = new Node(left.color, lc);
        }
        int rc = upperBound(r, right.color) - lowerBound(l, right.color);

        if (rc > lc) {
            return tree[node] = new Node(right.color, rc);
        }
        if (lc > rc) {
            return tree[node] = new Node(left.color, lc);
        }
        return tree[node] = new Node(0, 0);
    }

    public static Node query(int l, int r, int start, int end, int node) {
        if (end < l || r < start) return new Node(0, 0);
        if (start <= l && r <= end) return tree[node];

        int mid = (l + r) / 2;
        Node left = query(l, mid, start, end, node * 2);
        Node right = query(mid + 1, r, start, end, node * 2 + 1);

        int lc = upperBound(end, left.color) - lowerBound(start, left.color);
        if (left.color == right.color) {
            return new Node(left.color, lc);
        }
        int rc = upperBound(end, right.color) - lowerBound(start, right.color);
        if (rc > lc) {
            return new Node(right.color, rc);
        }
        if (lc > rc) {
            return new Node(left.color, lc);
        }
        return new Node(0, 0);


    }


    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(in.readLine());
        dw = new int[N + 1];
        tree = new Node[N * 4];
        for (int i = 1; i <= N; i++) {
            dw[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(in.readLine());
        color = new ArrayList[C + 1];
        for (int i = 0; i <= C; i++) {
            color[i] = new ArrayList<Integer>();
        }


        for (int j = 1; j <= N; j++) {
            color[dw[j]].add(j);
        }

        init(1, N, 1);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Node res = query(1, N, a, b, 1);
            sb.append(res.cnt > (b - a + 1) / 2 ? "yes " + res.color : "no").append("\n");

        }
        System.out.println(sb);

    }
}
