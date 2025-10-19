package calculator.model;

import calculator.constant.ErrorMessage;

public class PositiveNumber {

    private final int number;

    public PositiveNumber(String numberString) {
        int parsedNumber = parseNumber(numberString);
        validateSign(parsedNumber);
        this.number = parsedNumber;
    }

    private int parseNumber(String numberString) {
        try {
            return Integer.parseInt(numberString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_A_NUMBER.getMessage(numberString));
        }
    }

    private void validateSign(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_NUMBER.getMessage(number));
        }
    }

    public int getNumber() {
        return this.number;
    }
}
