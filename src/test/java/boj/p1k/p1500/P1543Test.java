
package boj.p1k.p1500;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class P1543Test {

	static Stream<Arguments> cases() {
		return Stream.of(

			arguments("ababababa", "ababa", "1")
		);
	}

	@ParameterizedTest
	@MethodSource("cases")
	void testMain(String str, String target, String expected) {
		ByteArrayOutputStream newConsole = new ByteArrayOutputStream();
		System.setOut(new PrintStream(newConsole));
		P1543.solution(str, target);
		assertEquals(newConsole.toString(), expected);
	}

}

