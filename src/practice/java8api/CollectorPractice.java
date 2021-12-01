package practice.java8api;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorPractice {
	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 3);

		// Old school
		for (Integer i : list)
			System.out.println(i);

		// "Modern"
		list.forEach(System.out::println);
	}
}
