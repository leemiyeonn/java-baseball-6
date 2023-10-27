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

        if (isNoScore(ball, strike)) {
            displayResult(ResultType.NOTHING);
            return;
        }

        if (isMaxStrike(strike)) {
            displayStrike(strike);
            return;
        }

        if (isMaxBall(ball)) {
            displayBall(ball);
            return;
        }

        if (isNoStrike(strike)) {
            displayBall(ball);
            return;
        }

        if (isNoBall(ball)) {
            displayStrike(strike);
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

    private boolean isNoStrike(Strike strike) {
        return strike.getCount() == 0;
    }

    private boolean isNoScore(Ball ball, Strike strike) {
        return ball.getCount() == NO_SCORE && strike.getCount() == NO_SCORE;
    }

    private boolean isNoBall(Ball ball) {
        return ball.getCount() == 0;
    }

    private void displayBall(Ball ball) {
        System.out.println(String.format(ResultType.BALL.getValue(), ball.getCount()));
    }

    private void displayStrike(Strike strike) {
        System.out.println(String.format(ResultType.STRIKE.getValue(), strike.getCount()));
    }

    private void displayBallAndStrike(Ball ball, Strike strike) {
        System.out.print(String.format(ResultType.BALL.getValue(), ball.getCount()));
        System.out.print(" ");
        System.out.print(String.format(ResultType.STRIKE.getValue(), strike.getCount()));
        System.out.println();
    }

    public void displayMessage(MessageType messageType) {
        System.out.println(messageType.getMessage());
    }

    public void displayResult(ResultType resultType) {
        System.out.println(resultType.getValue());
    }

    public String readInput() {
        return Console.readLine();
    }
}
