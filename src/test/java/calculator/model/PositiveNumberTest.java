package calculator.model;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("PositiveNumber 객체 생성 테스트")
public class PositiveNumberTest {

    @DisplayName("유효한 숫자 문자열(0 포함 양수)로 객체를 성공적으로 생성한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "123"})
    void create_WithValidNumberString_ShouldCreateInstance(String input) {
        // given & when
        PositiveNumber positiveNumber = new PositiveNumber(input);

        // then
        assertThat(positiveNumber.getNumber()).isEqualTo(Integer.parseInt(input));
    }

    @DisplayName("음수 문자열로 객체 생성 시 IllegalArgumentException을 던진다.")
    @Test
    void create_WithNegativeNumberString_ShouldThrowException() {
        // given
        String input = "-1";
        String expectedMessage = "음수는 입력할 수 없습니다: " + input;

        // when & then
        assertThatThrownBy(() -> new PositiveNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedMessage);
    }

    @DisplayName("숫자 형식이 아닌 문자열로 객체 생성 시 IllegalArgumentException을 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", " ", "1a", "!"})
    void create_WithNonNumericString_ShouldThrowException(String input) {
        // given
        String expectedMessage = "입력된 문자열은 숫자 형식이어야 합니다: ";

        // when & then
        assertThatThrownBy(() -> new PositiveNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedMessage + input);
    }

    @DisplayName("Integer 범위를 초과하는 숫자 문자열로 객체 생성 시 IllegalArgumentException을 던진다.")
    @Test
    void create_WithIntegerOverflowString_ShouldThrowException() {
        // given
        // Integer.MAX_VALUE = 2147483647
        String input = "2147483648";
        String expectedMessage = "표현 가능한 정수 범위를 벗어났습니다: " + input;

        // when & then
        assertThatThrownBy(() -> new PositiveNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedMessage);
    }
}
