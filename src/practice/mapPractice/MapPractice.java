package practice.mapPractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MapPractice {
	public static void main(String[] args) {
		//
		// // 맵 순회
		//
		// // 첫 번째, Iterator를 통해 접근하기
		//
		// Map<String, String> map = new HashMap<>();
		//
		// Iterator<String> keys = map.keySet().iterator();
		// while (keys.hasNext()) {
		// 	String key = keys.next();
		// 	map.get(key);
		// }
		// // 두 번째, entrySet으로 접근하기. Map은 하나의 원소로 Key-Value 묶음을 가지기 때문에 원소란 표현 대신 Entry라고 표현합니다.
		//
		// Map<String, String> map = new HashMap<>();
		//
		// for (Map.Entry<String, String> entry : map.entrySet()) {
		// 	String key = entry.getKey();
		// 	String value = entry.getValue();
		// }
		// // 세 번째, 두 번째 방법이랑 비슷한데 entrySet이 아니라 keySet을 이용해 접근하기.
		//
		// Map<String, String> map = new HashMap<>();
		//
		// for (String key : map.keySet()) {
		// 	map.get(key);
		// }


		HashMap<String, Integer> map = new HashMap<>();
		map.put("A", 65);
		map.put("C", 67);
		map.put("E", 90);
		map.put("D", 68);
		map.put("B", 66);
		map.put("Z", 1);

		List<String> keySet = new ArrayList<>(map.keySet());

		System.out.println("==Key 값 기준으로 오름차순 정렬==");
		List<String> keys = new ArrayList<>(map.keySet());
		Collections.sort(keys);
		for (String key : keys) {
			System.out.println(String.format("Key : %s, Value : %s", key, map.get(key)));
		}

		keys.sort(Collections.reverseOrder());
		System.out.println("==Key 값 기준으로 내림차순 정렬==");
		for (String key : keys) {
			System.out.println(String.format("Key : %s, Value : %s", key, map.get(key)));
		}
	}
	}

