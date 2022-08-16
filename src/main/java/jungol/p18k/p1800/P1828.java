package jungol.p18k.p1800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class P1828 {

	public static class Material implements Comparable<Material> {
		int lowestTemp, highestTemp;

		public Material(int lowestTemp, int highestTemp) {
			this.lowestTemp = lowestTemp;
			this.highestTemp = highestTemp;
		}

		public int compareTo(Material m) {
			int difference = this.highestTemp - m.highestTemp;
			return difference == 0 ? this.lowestTemp - m.lowestTemp : difference;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Material> materials = new ArrayList<>(N);
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			materials.add(new Material(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		Collections.sort(materials);

		int refrigeratorCount = 1;
		Material first = materials.get(0);
		int refrigeratorLowestTemp = first.highestTemp;
		int refrigeratorHighestTemp = first.highestTemp;

		for (int i = 1; i < N; i++) {
			Material cur = materials.get(i);
			int curLowestTemp = cur.lowestTemp;
			int curHighestTemp = cur.highestTemp;

			if (refrigeratorHighestTemp < curLowestTemp) {
				refrigeratorCount++;
				refrigeratorLowestTemp = curLowestTemp;
				refrigeratorHighestTemp = curHighestTemp;
			}

		}
		System.out.print(refrigeratorCount);
	}

}
