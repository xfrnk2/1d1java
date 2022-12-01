package boj.p1k.p1900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class P1918 {

	static String answer = "";

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String input = in.readLine();
		cal(input);
		System.out.println(answer);

	}

	public static void cal(String input) {
		// System.out.println("incal... start" + start);

		Stack<Character> stackBeforeBracket = new Stack<>();
		Stack<Character> stack = new Stack<>();
		Map<Character, Integer> priority = new HashMap<>();
		priority.put('*', 1);
		priority.put('/', 1);
		priority.put('+', 0);
		priority.put('-', 0);
		priority.put('(', -1);
		priority.put(')', -1);

		int end = input.length();

		for (int i = 0, size = end; i < size; i++) {
			char cur = input.charAt(i);

			if (65 <= cur && cur <= 91) {
				answer += cur;
				continue;
			}
			if (cur == '(') {
				stack.add(cur);
				continue;
			}
			if (cur == ')') {
				while (stack.peek() != '(') {
					answer += stack.pop();
				}
				stack.pop();
				continue;
			}

			// 연산자라면
			while (!stack.isEmpty() && priority.get(stack.peek()) >= priority.get(cur)) {
				answer += stack.pop();
			}

			stack.add(cur);
		}

		while (!stack.isEmpty()) {
			answer += stack.pop();
		}
	}

}
