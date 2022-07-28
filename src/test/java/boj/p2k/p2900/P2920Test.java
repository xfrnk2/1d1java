package boj.p2k.p2900;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


class P2920Test {

	static Stream<Arguments> cases() {
		return Stream.of(
			arguments(new Integer[] {1, 2, 3, 4, 5, 6, 7, 8}, "ascending"),
			arguments(new Integer[] {8, 7, 6, 5, 4, 3, 2, 1}, "descending"),
			arguments(new Integer[] {1, 2, 3, 4, 5, 7, 6, 8}, "mixed")
		);
	}

	@ParameterizedTest
	@MethodSource("cases")
	void testMain(Integer[] arr, String expected) {
		ByteArrayOutputStream newConsole = new ByteArrayOutputStream();
		System.setOut(new PrintStream(newConsole));
		P2920.main(arr);
		assertEquals(newConsole.toString(), expected);
	}

}
