package boj.p10k.p10900;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class P10971Test {

	static Stream<Arguments> cases() {
		return Stream.of(
			arguments(4, new int[][] {new int[] {0, 10, 15, 20}, new int[] {5, 0, 9, 10},
				new int[] {6, 13, 0, 12}, new int[] {8, 8, 9, 0}}, "35")
		);
	}

	@ParameterizedTest
	@MethodSource("cases")
	void testMain(int n, int[][] matrix, String expected) {
		ByteArrayOutputStream newConsole = new ByteArrayOutputStream();
		System.setOut(new PrintStream(newConsole));

		P10971.solution(n, matrix);
		assertEquals(newConsole.toString(), expected);
	}

}
