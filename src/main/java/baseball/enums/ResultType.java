package baseball.enums;

import static java.lang.String.format;

public enum ResultType {
    NOTHING("낫싱"),
    BALL("볼"),
    STRIKE("스트라이크"),
    BALL_AND_STRIKE(format("%d볼 %스트라이크"));

    private final String value;

    ResultType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
