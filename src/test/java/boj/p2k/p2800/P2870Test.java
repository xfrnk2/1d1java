package boj.p2k.p2800;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class P2870Test {

	static Stream<Arguments> cases() {
		return Stream.of(
			arguments(4, new String[] {"43silos0", "zita002", "le2sim", "231233"}, "0\n2\n2\n43\n231233\n")
		);
	}

	@ParameterizedTest
	@MethodSource("cases")
	void testMain(int n, String[] arr, String expected) {
		ByteArrayOutputStream newConsole = new ByteArrayOutputStream();
		System.setOut(new PrintStream(newConsole));
		P2870.solution(n, arr);
		assertEquals(newConsole.toString(), expected);
	}

}
