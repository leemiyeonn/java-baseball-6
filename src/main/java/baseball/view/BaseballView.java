package baseball.view;

import static baseball.domain.GameConfig.MAX_SCORE;
import static baseball.domain.GameConfig.NO_SCORE;

import baseball.domain.Ball;
import baseball.domain.GameResult;
import baseball.domain.Strike;
import baseball.enums.MessageType;
import baseball.enums.ResultType;
import camp.nextstep.edu.missionutils.Console;

public class BaseballView {

    public void displayScore(GameResult result) {
        Strike strike = result.getStrike();
        Ball ball = result.getBall();

        if (isMaxStrike(strike)) {
            displayStrike(strike);
            return;
        }

        if (isMaxBall(ball)) {
            displayBall(ball);
            return;
        }

        if (isNoScore(ball, strike)) {
            displayResult(ResultType.NOTHING);
            return;
        }

        displayBallAndStrike(ball, strike);
    }

    private boolean isMaxStrike(Strike strike) {
        return strike.getCount() == MAX_SCORE;
    }

    private boolean isMaxBall(Ball ball) {
        return ball.getCount() == MAX_SCORE;
    }

    private boolean isNoScore(Ball ball, Strike strike) {
        return ball.getCount() == NO_SCORE && strike.getCount() == NO_SCORE;
    }

    private void displayBallAndStrike(Ball ball, Strike strike) {
        System.out.print(ball.getCount() + ResultType.BALL.getValue() + " ");
        System.out.println(strike.getCount() + ResultType.STRIKE.getValue());
    }

    private void displayBall(Ball ball) {
        System.out.println(ball.getCount() + ResultType.BALL.getValue());
    }

    private void displayStrike(Strike strike) {
        System.out.println(strike.getCount() + ResultType.STRIKE.getValue());
    }

    public void displayMessage(MessageType messageType) {
        System.out.println(messageType.getMessage());
    }

    public void displayResult(ResultType resultType){
        System.out.println(resultType.getValue());
    }

    public String readInput() {
        return Console.readLine();
    }
}
