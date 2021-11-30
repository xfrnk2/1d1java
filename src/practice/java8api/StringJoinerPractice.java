package practice.java8api;

import java.util.StringJoiner;

public class StringJoinerPractice {
	public static void main(String[] args) {
		StringJoiner output = logic();
		System.out.println(output);
	}
	public static StringJoiner logic() {
		String[] stringList = new String[] {"a", "b", "c", "d", "e"};
		StringJoiner joiner = new StringJoiner(",", "(" , ")");
		for (String string: stringList){
			joiner.add(string);
		}
		return joiner;
	}
}
