package calculator.constant;

public enum ErrorMessage {
    NOT_A_NUMBER("입력된 문자열은 숫자 형식이어야 합니다: "),
    NEGATIVE_NUMBER("음수는 입력할 수 없습니다: "),
    OUT_OF_INTEGER_RANGE("표현 가능한 정수 범위를 벗어났습니다: ");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage(Object value) {
        return message + value;
    }
}
