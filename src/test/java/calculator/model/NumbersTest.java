package calculator.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Numbers 일급 컬렉션 테스트")
class NumbersTest {

    @DisplayName("숫자 문자열 배열로 합계를 성공적으로 계산한다.")
    @Test
    void sum_WithValidNumberStrings_ShouldReturnCorrectSum() {
        // given
        String[] input = {"1", "2", "3"};

        // when
        Numbers numbers = new Numbers(input);
        int result = numbers.sum();

        // then
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("배열이 빈 문자열이어도 정상적으로 합계를 계산한다.")
    @Test
    void sum_WithEmptyString_ShouldIgnoreAndSum() {
        // given
        String[] input = {""};

        // when
        Numbers numbers = new Numbers(input);
        int result = numbers.sum();

        // then
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("배열에 빈 문자열이 포함되어도 정상적으로 합계를 계산한다.")
    @Test
    void sum_WithEmptyStrings_ShouldIgnoreAndSum() {
        // given
        String[] input = {"1", "", "2", " ", "3"};

        // when
        Numbers numbers = new Numbers(input);
        int result = numbers.sum();

        // then
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("배열에 null 값이 포함되어도 예외 없이 정상적으로 합계를 계산한다.")
    @Test
    void sum_WithNulls_ShouldIgnoreAndSum() {
        // given
        String[] input = {"1", null, "2", null, "3"};

        // when
        Numbers numbers = new Numbers(input);
        int result = numbers.sum();

        // then
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("배열에 음수가 하나 포함된 경우 IllegalArgumentException을 던진다.")
    @Test
    void create_WithOneNegativeNumber_ShouldThrowException() {
        // given
        String[] input = {"1", "-2", "3"};
        String expectedMessage = "음수는 입력할 수 없습니다: " + String.join(", ", "-2");

        // when & then
        assertThatThrownBy(() -> new Numbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedMessage);
    }

    @DisplayName("배열에 음수가 여러 개 포함된 경우, 예외 메시지에 모든 음수가 포함되는지 테스트한다.")
    @Test
    void create_WithMultipleNegativeNumbers_ShouldThrowExceptionWithAllNegatives() {
        // given
        String[] input = {"-1", "2", "-3"};
        String expectedMessage = "음수는 입력할 수 없습니다: " + String.join(", ", "-1", "-3");

        // when & then
        assertThatThrownBy(() -> new Numbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedMessage);
    }
}