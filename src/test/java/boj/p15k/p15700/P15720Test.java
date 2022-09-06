package boj.p15k.p15700;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class P15720Test {

	static Stream<Arguments> cases() {
		return Stream.of(
			arguments(3, 3, 2, "2000 3000 2500", "800 1300 1000", "500 1000", "12100\n11170")
		);
	}

	@ParameterizedTest
	@MethodSource("cases")
	void testMain(int b, int c, int d, String burger, String side, String beverage, String expected) {
		ByteArrayOutputStream newConsole = new ByteArrayOutputStream();
		System.setOut(new PrintStream(newConsole));
		P15720.solve(b, c, d, burger, side, beverage);
		assertEquals(newConsole.toString(), expected);
	}

}
