package boj.p2k.p2500;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class P2559Test {

	static Stream<Arguments> cases() {
		return Stream.of(
			arguments(10, 5, new int[] {3, -2, -4, -9, 0, 3, 7, 13, 8, -3},
				"31")
		);
	}

	@ParameterizedTest
	@MethodSource("cases")
	void testMain(int n, int k, int[] arr, String expected) {
		ByteArrayOutputStream newConsole = new ByteArrayOutputStream();
		System.setOut(new PrintStream(newConsole));
		P2559.solution(n, k, arr);
		assertEquals(newConsole.toString(), expected);
	}

}
