package calculator.model;

import calculator.constant.ErrorMessage;

public class PositiveNumber {

    private final int number;

    public PositiveNumber(String numberString) {
        int parsedNumber = parseAndValidateNumber(numberString);
        validateSign(parsedNumber);
        this.number = parsedNumber;
    }

    private int parseAndValidateNumber(String numberString) {
        long longValue;
        try {
            longValue = Long.parseLong(numberString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_A_NUMBER.getMessage(numberString));
        }

        if (longValue > Integer.MAX_VALUE || longValue < Integer.MIN_VALUE) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_INTEGER_RANGE.getMessage(numberString));
        }

        return (int) longValue;
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
