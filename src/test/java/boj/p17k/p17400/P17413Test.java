package boj.p17k.p17400;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class P17413Test {

	static Stream<Arguments> cases() {
		return Stream.of(
			arguments("baekjoon online judge", "noojkeab enilno egduj"),
			arguments("<problem>17413<is hardest>problem ever<end>", "<problem>31471<is hardest>melborp reve<end>")
		);
	}

	@ParameterizedTest
	@MethodSource("cases")
	void testMain(String str, String expected) {
		ByteArrayOutputStream newConsole = new ByteArrayOutputStream();
		System.setOut(new PrintStream(newConsole));
		P17413.solution(str);
		assertEquals(newConsole.toString(), expected);
	}

}
