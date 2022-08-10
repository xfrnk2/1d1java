package boj.p2k.p2400;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class P2468Test {

	static Stream<Arguments> cases() {
		return Stream.of(
			arguments(5, new int[][] {
					{6, 8, 2, 6, 2},
					{3, 2, 3, 4, 6},
					{6, 7, 3, 3, 2},
					{7, 2, 5, 3, 6},
					{8, 9, 5, 2, 7}
				},
				"5")
		);
	}

	@ParameterizedTest
	@MethodSource("cases")
	void testMain(int n, int[][] area, String expected) {
		ByteArrayOutputStream newConsole = new ByteArrayOutputStream();
		System.setOut(new PrintStream(newConsole));
		P2468.solution(n, area);
		assertEquals(newConsole.toString(), expected);
	}

}
