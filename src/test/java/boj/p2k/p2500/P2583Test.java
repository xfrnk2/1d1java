package boj.p2k.p2500;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class P2583Test {

	static Stream<Arguments> cases() {
		return Stream.of(
			arguments(5, 7, 3, new int[][] {new int[] {0, 2, 4, 4}, new int[] {1, 1, 2, 5}, new int[] {4, 0, 6, 2}},
				"3\n1 7 13")
		);
	}

	@ParameterizedTest
	@MethodSource("cases")
	void testMain(int m, int n, int k, int[][] arr, String expected) {
		ByteArrayOutputStream newConsole = new ByteArrayOutputStream();
		System.setOut(new PrintStream(newConsole));
		P2583.solution(m, n, k, arr);
		assertEquals(newConsole.toString(), expected);
	}

}
