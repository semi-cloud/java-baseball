package baseball.domain;


import static baseball.domain.Command.isExit;
import static baseball.domain.Command.isRestart;
import static baseball.domain.GameResult.GameStatus.END;
import static baseball.domain.GameResult.GameStatus.RESTART;


public final class GameResult {

    private int strike;

    private int ball;

    public enum GameStatus {
        PROGRESS,
        RESTART,
        END
    }

    private GameStatus gameStatus;

    public GameResult() {
        this.gameStatus = GameStatus.PROGRESS;
    }

    public GameStatus getStatus() {
        return gameStatus;
    }

    public int getStrike() { return strike; }

    public void setGameResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public void setStatusByCommand(String command){
        if (isExit(command)) {
            this.gameStatus = END;
        }

        if (isRestart(command)) {
            this.gameStatus = RESTART;
        }
    }

    public void restart() {
        this.gameStatus = GameStatus.PROGRESS;
    }

    public void clearResult() {
        strike = 0;
        ball = 0;
    }

    @Override
    public String toString() {
        if (ball == 0 && strike == 0) {
            return "낫싱";
        }

        if (strike == 0) {
            return ball + "볼";
        }

        if (ball == 0) {
            return strike + "스트라이크";
        }

        return ball + "볼" + " " + strike + "스트라이크";
    }
}
