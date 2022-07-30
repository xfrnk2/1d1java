package boj.p2k.p2200;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class P2240Test {

	static Stream<Arguments> cases() {
		return Stream.of(
			arguments(7, 2, new int[] {2, 1, 1, 2, 2, 1, 1}, "6")
		);
	}

	@ParameterizedTest
	@MethodSource("cases")
	void testMain(int n, int m, int[] arr, String expected) {
		ByteArrayOutputStream newConsole = new ByteArrayOutputStream();
		System.setOut(new PrintStream(newConsole));
		P2240.solution(n, m, arr);
		assertEquals(newConsole.toString(), expected);
	}

}
