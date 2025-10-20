package calculator.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("사용자 정의 StringParser 테스트")
public class StringParserTest {

    @DisplayName("기본 구분자(쉼표, 콜론)로 문자열을 올바르게 분리한다.")
    @Test
    void parse_WithDefaultDelimiters_ShouldReturnSplitArray() {
        // given
        String input = "1,2:3";

        // when
        String[] result = StringParser.parse(input);

        // then
        assertThat(result).containsExactly("1", "2", "3");
    }

    @DisplayName("커스텀 구분자로 숫자 부분만 올바르게 분리한다.")
    @Test
    void parse_WithCustomDelimiter_ShouldSplitNumbersPart() {
        // given
        String input = "//;\\n1;2;3";

        // when
        String[] result = StringParser.parse(input);

        // then
        assertThat(result).containsExactly("1", "2", "3");
    }

    @DisplayName("커스텀 구분자로 숫자 부분과 공백을 함께 올바르게 분리한다.")
    @Test
    void parse_WithCustomDelimiter_ShouldSplitNumbersPartWithBlank() {
        // given
        String input = "//;\\n1; 2; 3 ";

        // when
        String[] result = StringParser.parse(input);

        // then
        assertThat(result).containsExactly("1", " 2", " 3 ");
    }

    @DisplayName("입력 문자열이 비어있을 경우, 0을 포함한 배열을 반환한다")
    @Test
    void parse_WithEmptyString_ShouldReturnArrayWithEmptyString() {
        // given
        String input = "";

        // when
        String[] result = StringParser.parse(input);

        // then
        assertThat(result).containsExactly("");
    }
}
