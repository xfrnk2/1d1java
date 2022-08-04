package boj.p2k.p2100;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import boj.p2k.P2100.P2164;

public class P2164Test {

	static Stream<Arguments> cases() {
		return Stream.of(
			arguments(6, "4")
		);
	}

	@ParameterizedTest
	@MethodSource("cases")
	void testMain(int n, String expected) throws IOException {
		ByteArrayOutputStream newConsole = new ByteArrayOutputStream();
		System.setOut(new PrintStream(newConsole));
		P2164.solution(n);
		assertEquals(newConsole.toString(), expected);
	}

}
