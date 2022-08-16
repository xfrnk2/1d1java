package boj.p16k.p16600;


import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


class P16637Test {

	static Stream<Arguments> cases() {
		return Stream.of(
			arguments("7", "8*3+5+2", "66"),
			arguments("19", "1*2+3*4*5-6*7*8*9*9", "426384")
		);
	}

	@ParameterizedTest
	@MethodSource("cases")
	void testMain(String n, String expression, String expected) {
		ByteArrayOutputStream newConsole = new ByteArrayOutputStream();
		System.setOut(new PrintStream(newConsole));
		P16637.solution(n, expression);
		assertEquals(newConsole.toString(), expected);
	}

}
