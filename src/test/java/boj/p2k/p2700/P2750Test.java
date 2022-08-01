package boj.p2k.p2700;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class P2750Test {

	static Stream<Arguments> cases() {
		return Stream.of(
			arguments(5, new int[] {5, 2, 3, 4, 1}, "1\n2\n3\n4\n5\n")
		);
	}

	@ParameterizedTest
	@MethodSource("cases")
	void testMain(int n, int[] arr, String expected) {
		ByteArrayOutputStream newConsole = new ByteArrayOutputStream();
		System.setOut(new PrintStream(newConsole));
		P2750.solution(n, arr);
		assertEquals(newConsole.toString(), expected);
	}

}
