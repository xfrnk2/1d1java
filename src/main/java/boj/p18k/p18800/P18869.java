package boj.p18k.p18800;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class P18869 {
	static int N, M;
	static Set<ArrayList<Integer>> set = new LinkedHashSet();
	static Map<ArrayList<Integer>, Integer> counters = new HashMap<>(); 
	static ArrayList<Map<Integer, Integer>> maps = new ArrayList();
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		M =Integer.parseInt(st.nextToken());
		N =Integer.parseInt(st.nextToken());
		int ans = 0;
		int idx = 0;
		
		for (int i = 0; i < M; i++) {	
			st = new StringTokenizer(in.readLine());
			ArrayList<Integer> arr = new ArrayList<>();
			Map<Integer, Integer> map = new LinkedHashMap<>();
			for (int j = 0; j < N; j++) {
				int now = Integer.parseInt(st.nextToken());
				arr.add(now);	
				map.put(now, j);
			}
			Collections.sort(arr);

			if (!set.contains(arr)) {
			set.add(arr);
			maps.add(map);
			}
		}
		for (ArrayList<Integer> arr : set) {
			ArrayList<Integer> res = new ArrayList<>();
			for (Integer i : arr) res.add(maps.get(idx).get(i));
			int n = counters.getOrDefault(res, 0);
			idx ++;
			ans += n;
			counters.put(res, n + 1);
		}
		System.out.println(ans);		
	}

}

