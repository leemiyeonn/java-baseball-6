package baseball.controller;

import static baseball.utils.NumberUtils.getDigits;
import static baseball.utils.Validator.validateEndInput;
import static baseball.utils.Validator.validateNumberInput;

import baseball.domain.GameConfig;
import baseball.domain.GameResult;
import baseball.enums.MessageType;
import baseball.model.BaseballModel;
import baseball.view.BaseballView;
import java.util.List;

public class BaseballController {
    private BaseballModel baseballModel;
    private BaseballView baseballView;

    public BaseballController(BaseballModel baseballModel, BaseballView baseballView) {
        this.baseballModel = baseballModel;
        this.baseballView = baseballView;
    }

    public void startGame() {
        GameResult gameResult = baseballModel.gameResult;
        do {
            baseballView.displayMessage(MessageType.START);
            play(gameResult);
            askForRestart(gameResult);
        } while (!gameResult.isGameEnded());
    }

    private void play(GameResult gameResult) {
        List<Integer> computerNumber = baseballModel.generateRandomUniqueNumbers();
        /** For debugging purpose */
        System.out.println("컴퓨터: " + computerNumber);

        do {
            gameResult.resetCounts();
            List<Integer> playerNumber = getPlayerNumberInput();
            gameResult = baseballModel.calculateGameResult(computerNumber, playerNumber);
            baseballView.displayScore(gameResult);
        } while (!gameResult.isGameEnded());
    }

    private void askForRestart(GameResult gameResult) {
        baseballView.displayMessage(MessageType.ASK_FOR_RESTART);
        String endInput = getEndGameInput();
        String restartNumber = Integer.toString(GameConfig.RESTART_NUMBER);
        String finishNumber = Integer.toString(GameConfig.FINISH_NUMBER);

        if (endInput.equals(restartNumber)) {
            gameResult.restartGame();
        }

        if (endInput.equals(finishNumber)) {
            baseballView.displayMessage(MessageType.END);
        }
    }

    private List<Integer> getPlayerNumberInput() {
        baseballView.displayMessage(MessageType.ASK_FOR_NUMBER);
        String input = baseballView.readInput();
        validateNumberInput(input);

        return getDigits(Integer.parseInt(input));
    }

    private String getEndGameInput() {
        String endInput = baseballView.readInput();
        validateEndInput(endInput);

        return endInput;
    }
}

