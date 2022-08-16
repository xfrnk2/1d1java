package jungol.p20k.p2200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class P2247 {

	public static class Student implements Comparable<Student> {

		int stime;
		int etime;

		public Student(int stime, int etime) {

			this.stime = stime;
			this.etime = etime;
		}

		public int compareTo(Student o) {
			return stime - o.stime;
		}
	}

	public static void main (String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Student> student = new ArrayList<>(N);
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			student.add(new Student(
				Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken())
			));
		}

		// 		그리디로 선택하기 위해 회의를 시작시간을 기준으로 정렬한다.
		Collections.sort(student);

		int startTime=0, endTime = 0;
		int mx = 0;
		int mn = 0;

		for (int i = 0; i < N; i++) {
			Student cur = student.get(i);
			if (endTime < cur.stime) {
				if (mn < cur.stime - endTime) {
					mn = cur.stime - endTime;
				}
				startTime = cur.stime;
				endTime = cur.etime;

			} else {

				if (endTime < cur.etime) {
					endTime = cur.etime;
				}
				if (mx < endTime - startTime) {
					mx = endTime - startTime;
				}


			}

		}

		System.out.print(mx + " " + mn);
	}
}
