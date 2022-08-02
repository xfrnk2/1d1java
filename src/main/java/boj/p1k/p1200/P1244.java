package boj.p1k.p1200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Switches {
	int[] container;

	Switches(int[] container) {
		this.container = container;

	}

	public void turnOnAndOff(int idx) {
		this.container[idx] ^= 1;
	}

	public int getNodeStatus(int idx) {
		return this.container[idx];
	}

	public int getSize() {
		return container.length;
	}
}

abstract class Person {
	int sex, number;

	Person(int sex, int number) {
		this.sex = sex;
		this.number = number;
	}

	abstract void work(Switches switches);
}

class Man extends Person {

	Man(int sex, int number) {
		super(sex, number);
	}

	private boolean checkIsMultiples(int number) {
		return number % this.number == 0;
	}

	@Override
	void work(Switches switches) {
		for (int i = 0; i < switches.container.length; i++) {
			if (checkIsMultiples(i + 1)) {
				switches.turnOnAndOff(i);
			}
		}
	}
}

class Woman extends Person {

	Woman(int sex, int number) {
		super(sex, number);
	}

	private boolean checkIsValidSwitchRange(int left, int right, int maxSize) {
		return 0 <= left && right < maxSize;
	}

	@Override
	void work(Switches switches) {
		int left = this.number - 1, right = this.number - 1, maxSize = switches.getSize();
		while (checkIsValidSwitchRange(--left, ++right, maxSize)
			&& switches.getNodeStatus(left) == switches.getNodeStatus(right)) {
			switches.turnOnAndOff(left);
			switches.turnOnAndOff(right);
		}
		switches.turnOnAndOff(this.number - 1);
	}
}

class P1244 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[] switches = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			switches[i] = Integer.parseInt(st.nextToken());
		}

		int p = Integer.parseInt(br.readLine());

		List<Person> people = new ArrayList<>(8);

		for (int i = 0; i < p; i++) {
			st = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st.nextToken());
			int number = Integer.parseInt(st.nextToken());
			Person person = sex == 1 ? new Man(sex, number) : new Woman(sex, number);
			people.add(person);
		}

		solution(n, new Switches(switches), p, people);

	}

	public static void solution(int n, Switches switches, int p, List<Person> people) {
		for (Person person : people) {
			person.work(switches);
		}
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < switches.getSize(); i++) {
			sb.append(switches.container[i]).append(" ");
			if ((i + 1) % 20 == 0) sb.append("\n");
		}
		System.out.print(sb);
	}
}
