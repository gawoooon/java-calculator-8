package calculator.model;

import calculator.constant.ErrorMessage;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Numbers {
    private final List<PositiveNumber> numbers;

    public Numbers(String[] numberStrings) {
        List<String> negativeStrings = findNegativeStrings(numberStrings);
        if (!negativeStrings.isEmpty()) {
            throw new IllegalArgumentException(
                    ErrorMessage.NEGATIVE_NUMBER.getMessage(String.join(", ", negativeStrings)));
        }

        this.numbers = Arrays.stream(numberStrings)
                .filter(Objects::nonNull)
                .filter(s -> !s.trim().isEmpty())
                .map(PositiveNumber::new)
                .collect(Collectors.toList());
    }

    private List<String> findNegativeStrings(String[] numberStrings) {
        return Arrays.stream(numberStrings)
                .filter(Objects::nonNull)
                .filter(s -> s.startsWith("-"))
                .collect(Collectors.toList());
    }

    public int sum() {
        return numbers.stream()
                .mapToInt(PositiveNumber::getNumber)
                .sum();
    }
}
