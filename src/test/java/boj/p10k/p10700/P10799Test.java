package boj.p10k.p10700;

	import static org.junit.jupiter.api.Assertions.*;
	import static org.junit.jupiter.params.provider.Arguments.*;

	import java.io.ByteArrayOutputStream;
	import java.io.PrintStream;
	import java.util.stream.Stream;

	import org.junit.jupiter.params.ParameterizedTest;
	import org.junit.jupiter.params.provider.Arguments;
	import org.junit.jupiter.params.provider.MethodSource;

class P10799Test {

	static Stream<Arguments> cases() {
		return Stream.of(
			arguments("()(((()())(())()))(())", "17")
		);
	}

	@ParameterizedTest
	@MethodSource("cases")
	void testMain(String str, String expected) {
		ByteArrayOutputStream newConsole = new ByteArrayOutputStream();
		System.setOut(new PrintStream(newConsole));
		P10799.solution(str);
		assertEquals(newConsole.toString(), expected);
	}

}
