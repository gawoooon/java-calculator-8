package calculator.model;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("StringCalculator 통합 테스트")
public class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @DisplayName("null 또는 빈 문자열을 입력하면 0을 반환한다.")
    @Test
    void add_WithNullOrEmptyString_ShouldReturnZero() {
        // when
        int nullResult = calculator.add(null);
        int emptyResult = calculator.add("");
        int blankResult = calculator.add("   ");

        // then
        assertThat(nullResult).isZero();
        assertThat(emptyResult).isZero();
        assertThat(blankResult).isZero();
    }

    @DisplayName("숫자 하나만 있는 문자열을 입력하면 해당 숫자를 반환한다.")
    @Test
    void add_WithSingleNumber_ShouldReturnTheNumber() {
        // when
        int result = calculator.add("5");

        // then
        assertThat(result).isEqualTo(5);
    }

    @DisplayName("기본 구분자(쉼표, 콜론)로 분리된 숫자들의 합을 반환한다.")
    @Test
    void add_WithDefaultDelimiters_ShouldReturnSum() {
        // when
        int result = calculator.add("1,2:3");

        // then
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("커스텀 구분자로 분리된 숫자들의 합을 반환한다.")
    @Test
    void add_WithCustomDelimiter_ShouldReturnSum() {
        // when
        int result = calculator.add("//;\\n1;2;3");

        // then
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("음수가 포함된 문자열을 입력하면 예외를 던진다.")
    @Test
    void add_WithNegativeNumber_ShouldThrowException() {
        // given
        String input = "1,-2,3";

        // when & then
        assertThatThrownBy(() -> calculator.add(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
