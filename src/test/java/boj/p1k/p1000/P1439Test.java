package boj.p1k.p1000;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import boj.p1k.p1400.P1439;

class P1439Test {

	static Stream<Arguments> cases() {
		return Stream.of(
			arguments("11001100110011000001", "4")
		);
	}

	@ParameterizedTest
	@MethodSource("cases")
	void testMain(String str, String expected) {
		ByteArrayOutputStream newConsole = new ByteArrayOutputStream();
		System.setOut(new PrintStream(newConsole));
		P1439.solution(str);
		assertEquals(newConsole.toString(), expected);
	}

}

