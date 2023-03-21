package boj.p11k.p11000;


import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P11000 {

	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(in.readLine());
		StringTokenizer st;

		Point[] arr = new Point[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			arr[i] = new Point(Integer.valueOf(st.nextToken()), Integer.valueOf(st.nextToken()));
		}

		Arrays.sort(arr, new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				// TODO Auto-generated method stub
				int p = o1.x - o2.x;
				if (p == 0) {
					return o1.y - o2.y;
				}
				return p;
			}

		});

		PriorityQueue<Integer> pq = new PriorityQueue<>(

		);

		pq.add(arr[0].y);

		for (int j = 1; j < N; j++) {
			if (pq.peek() > arr[j].x) {
				pq.add(arr[j].y);
			} else {
				pq.poll();
				pq.add(arr[j].y);
			}

		}
		System.out.println(pq.size());

	}

}
