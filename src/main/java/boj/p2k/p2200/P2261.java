package boj.p2k.p2200;


import java.io.*;
import java.util.*;

public class P2261 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static Point[] points;

    static class Point implements Comparable<Point> {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Point p) {
            if (this.x == p.x)
                return this.y - p.y;
            return this.x - p.x;
        }
    }

    static long closestPair(int l, int r) {
        if (l == r)
            return Long.MAX_VALUE;
        int mid = (l + r) / 2;
        long d = Math.min(closestPair(l, mid), closestPair(mid + 1, r));
        List<Point> list = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            int dx = points[i].x - points[mid].x;
            if (dx * dx < d)
                list.add(points[i]);
        }
        Collections.sort(list, (p1, p2) -> p1.y - p2.y);
        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            Point p1 = list.get(i);
            for (int j = i + 1; j < size; j++) {
                Point p2 = list.get(j);
                int dy = p2.y - p1.y;
                if (dy * dy >= d)
                    break;
                long dist = (long)(p1.x - p2.x) * (p1.x - p2.x) + (long)dy * dy;
                d = Math.min(d, dist);
            }
        }
        return d;
    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        points = new Point[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[i] = new Point(x, y);
        }
        Arrays.sort(points);
        System.out.println(closestPair(0, n - 1));
    }
}
