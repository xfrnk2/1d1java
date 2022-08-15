
package boj.p1k.p1000;



import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import boj.p1k.p1000.P1021;

class P1021Test {

	static Stream<Arguments> cases() {
		return Stream.of(

			arguments(10, 3, new int[] {2, 9, 5}, "8"),
			arguments(32, 6, new int[] {27, 16, 30, 11, 6, 23}, "59")
		);
	}

	@ParameterizedTest
	@MethodSource("cases")
	void testMain(int m, int n, int[] numbers, String expected) {
		ByteArrayOutputStream newConsole = new ByteArrayOutputStream();
		System.setOut(new PrintStream(newConsole));
		P1021.solution(m, n, numbers);
		assertEquals(newConsole.toString(), expected);
	}

}

