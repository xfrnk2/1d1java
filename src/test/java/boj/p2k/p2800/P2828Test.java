package boj.p2k.p2800;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class P2828Test {

	static Stream<Arguments> cases() {
		return Stream.of(
			arguments(5, 1, 3, new int[] {1,5,3}, "6")
		);
	}

	@ParameterizedTest
	@MethodSource("cases")
	void testMain(int n, int[] arr, String expected) {
		ByteArrayOutputStream newConsole = new ByteArrayOutputStream();
		System.setOut(new PrintStream(newConsole));
		P2828.solution(n, arr);
		assertEquals(newConsole.toString(), expected);
	}

}
