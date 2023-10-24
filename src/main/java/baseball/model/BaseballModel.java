package baseball.model;

import static baseball.utils.Validator.NUMBER_LENGTH;

import baseball.entity.GameResult;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BaseballModel {
    public static final int MAX_STRIKES = 3;
    public final GameResult gameResult;

    public BaseballModel(GameResult gameResult) {
        this.gameResult = gameResult;
    }

    public List<Integer> generateRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();

        while (randomNumbers.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!(randomNumbers.contains(randomNumber))) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }

    public GameResult evaluatePlayerInput(List<Integer> computerNumber, List<Integer> playerNumber) {
        for (int i = 0; i < computerNumber.size(); i++) {
            if (Objects.equals(computerNumber.get(i), playerNumber.get(i))) {
                gameResult.getStrike().increaseCount();
            } else if (computerNumber.contains(playerNumber.get(i))) {
                gameResult.getBall().increaseCount();
            }
        }
        checkGameEnded(gameResult);
        return gameResult;
    }

    private void checkGameEnded(GameResult gameResult) {
        if (gameResult.getStrike().getCount() == MAX_STRIKES) {
            gameResult.endGame();
        }
    }
}