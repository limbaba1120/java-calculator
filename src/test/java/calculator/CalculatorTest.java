package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import stringStudy.calculator.Calculator;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CalculatorTest {

    @DisplayName("쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열의 숫자의 합")
    @ParameterizedTest
    @MethodSource("formulaAndResult")
    public void separatorSumTest(String formula, int expectedResult) {
        int actualResult = Calculator.add(formula);
        assertEquals(expectedResult, actualResult);
    }

    private static Stream<Arguments> formulaAndResult() {
        return Stream.of(
                arguments("1,2", 3),
                arguments("1,2,3", 6),
                arguments("1,2:3", 6),
                arguments("//;\n1;2;3", 6)
        );
    }

    @DisplayName("문자열 계산기에 숫자 이외의 값을 전달할 경우 RuntimeException 발생")
    @ParameterizedTest
    @MethodSource("nonNumberRuntimeException")
    public void separatorNonNumberExceptionTest(String formula) {
        assertThatThrownBy(
                () -> {
                    int result = Calculator.add(formula);
                }
        ).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("숫자 이외의 값은 전달 못한다.");
    }

    private static Stream<Arguments> nonNumberRuntimeException() {
        return Stream.of(
                arguments(""),
                arguments("x;x")
        );
    }


    @DisplayName("문자열 계산기에 숫자 이외의 음수의 값을 전달할 경우 RuntimeException 발생")
    @ParameterizedTest
    @MethodSource("negativeNumberRuntimeException")
    public void separatorNegativeNumberExceptionTest(String formula) {
        assertThatThrownBy(
                () -> {
                    int result = Calculator.add(formula);
                }
        ).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("0 또는 음수를 전달할 수 없습니다.");
    }

    private static Stream<Arguments> negativeNumberRuntimeException() {
        return Stream.of(
                arguments("-5"),
                arguments("-1,-2"),
                arguments("-3,4,5")
        );
    }
}
