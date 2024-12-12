package lotto.common;

public enum ErrorMessage {

    INVALID_INPUT("아무것도 입력되지 않았습니다. 다시 입력해주세요."),
    INVALID_INPUT_TYPE("숫자로 입력해주세요."),
    INVALID_LOTTO_COUNT("로또 번호는 6개여야 합니다."),
    INVALID_MONEY("금액이 올바르지 않습니다. 1000원 단위의 금액을 입력해주세요.");

    private static final String HEADER = "[ERROR] ";
    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return HEADER + message;
    }
}

