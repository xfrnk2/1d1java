package boj.p15k.p15600;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class P15663Test {

	static Stream<Arguments> cases() {
		return Stream.of(
			arguments(3, 1, new Integer[] {4, 4, 2}, "")
		);
	}

	@ParameterizedTest
	@MethodSource("cases")
	void testMain(int n, int m, Integer[] numbers, String expected) {
		ByteArrayOutputStream newConsole = new ByteArrayOutputStream();
		System.setOut(new PrintStream(newConsole));
		P15663.solution(n, m, numbers);
		assertEquals(newConsole.toString(), expected);
	}

}
