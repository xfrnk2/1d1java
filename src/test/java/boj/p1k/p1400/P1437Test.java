package boj.p1k.p1400;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class P1437Test {

	static Stream<Arguments> cases() {
		return Stream.of(
			arguments(9931, "4664")
		);
	}

	@ParameterizedTest
	@MethodSource("cases")
	void testMain(int n, String expected) {
		ByteArrayOutputStream newConsole = new ByteArrayOutputStream();
		System.setOut(new PrintStream(newConsole));
		P2231.search(n);
		assertEquals(newConsole.toString(), expected);
	}

}
