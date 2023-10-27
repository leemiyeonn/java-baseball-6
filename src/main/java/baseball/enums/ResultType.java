package baseball.enums;

public enum ResultType {
    NOTHING("낫싱"),
    BALL("%d볼"),
    STRIKE("%d스트라이크"),
    BALL_AND_STRIKE("%d볼 %스트라이크");

    private final String value;

    ResultType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
