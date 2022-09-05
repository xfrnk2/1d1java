package boj.p16k.p16900;


import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


class P16946Test {

	static Stream<Arguments> cases() {
		return Stream.of(
			arguments(3, 3, new char[][] {{'1', '0', '1'}, {'0', '1', '0'}, {'1', '0', '1'}}, "303\n050\n303\n")
		);
	}

	@ParameterizedTest
	@MethodSource("cases")
	void testMain(int n, int m, char[][] map, String expected) {
		ByteArrayOutputStream newConsole = new ByteArrayOutputStream();
		System.setOut(new PrintStream(newConsole));
		P16946.solve(n, m, map);
		assertEquals(newConsole.toString(), expected);
	}

}
