package boj.p2k.p2900;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class P2979Test {

	static Stream<Arguments> cases() {
		return Stream.of(
			arguments(5, 3, 1, new int[][] {new int[] {1, 6}, new int[] {3, 5}, new int[] {2, 8}}, "33"),
			arguments(10, 8, 6, new int[][] {new int[] {15, 30}, new int[] {25, 50}, new int[] {70, 80}}, "480")

		);
	}

	@ParameterizedTest
	@MethodSource("cases")
	void testMain(int a, int b, int c, int[][] bus, String expected) {
		ByteArrayOutputStream newConsole = new ByteArrayOutputStream();
		System.setOut(new PrintStream(newConsole));
		P2979.main(a, b, c, bus);
		assertEquals(newConsole.toString(), expected);
	}

}
