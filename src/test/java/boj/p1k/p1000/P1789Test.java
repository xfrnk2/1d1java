package boj.p1k.p1000;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import boj.p1k.p1700.P1789;

class P1789Test {

	static Stream<Arguments> cases() {
		return Stream.of(

			arguments(200, "19")
		);
	}

	@ParameterizedTest
	@MethodSource("cases")
	void testMain(int n, String expected) {
		ByteArrayOutputStream newConsole = new ByteArrayOutputStream();
		System.setOut(new PrintStream(newConsole));
		P1789.solution(n);
		assertEquals(newConsole.toString(), expected);
	}

}

