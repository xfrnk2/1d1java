package boj.p2k.p2000;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import boj.p2k.P2000.P2003;

class P2003Test {

	static Stream<Arguments> cases() {
		return Stream.of(
			arguments(4, 2, new int[] {1, 1, 1, 1}, "3"),
			arguments(10, 5, new int[] {1, 2, 3, 4, 2, 5, 3, 1, 1, 2}, "3")
		);
	}

	@ParameterizedTest
	@MethodSource("cases")
	void testMain(int m, int n, int[] numbers, String expected) {
		ByteArrayOutputStream newConsole = new ByteArrayOutputStream();
		System.setOut(new PrintStream(newConsole));
		P2003.solution(m, n, numbers);
		assertEquals(newConsole.toString(), expected);
	}

}
