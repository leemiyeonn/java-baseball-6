package baseball.enums;

import static baseball.domain.GameConfig.FINISH_NUMBER;
import static baseball.domain.GameConfig.MAX_SCORE;
import static baseball.domain.GameConfig.RESTART_NUMBER;
import static java.lang.String.format;

public enum MessageType {
    START("숫자 야구 게임을 시작합니다."),
    ASK_FOR_NUMBER("숫자를 입력해주세요 : "),
    END(format("%d개의 숫자를 모두 맞히셨습니다! 게임 종료", MAX_SCORE)),
    ASK_FOR_RESTART(format("게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.", RESTART_NUMBER, FINISH_NUMBER));

    private final String message;

    MessageType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
