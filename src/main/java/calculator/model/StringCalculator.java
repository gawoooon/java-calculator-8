package calculator.model;

import calculator.util.StringParser;

public class StringCalculator {
    public int add(String text) {
        if (text == null || text.trim().isEmpty()) {
            return 0;
        }

        String[] parsedStrings = StringParser.parse(text);
        Numbers numbers = new Numbers(parsedStrings);
        return numbers.sum();
    }
}
