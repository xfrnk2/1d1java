package boj.p2k.p2100;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import boj.p2k.P2100.P2110;

class P2110Test {

	static Stream<Arguments> cases() {
		return Stream.of(
			arguments(5, 3, new int[] {1, 2, 8, 4, 9}, "3")
		);
	}

	@ParameterizedTest
	@MethodSource("cases")
	void testMain(int n, int m, int[] numbers, String expected) {
		ByteArrayOutputStream newConsole = new ByteArrayOutputStream();
		System.setOut(new PrintStream(newConsole));
		P2110.solution(n, m, numbers);
		assertEquals(newConsole.toString(), expected);
	}

}
