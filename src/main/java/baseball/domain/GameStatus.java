package baseball.domain;


import java.util.Arrays;

public enum GameStatus {

    PROGRESS("0"),
    RESTART("1"),
    EXIT("2");

    private final String number;

    GameStatus(final String number) {
        this.number = number;
    }

    public static boolean hasValue(String num) {
        return Arrays.stream(GameStatus.values())
                .anyMatch(x -> x.commandNum().equals(num));
    }

    public static boolean isRestart(String input) {
        return input.equals(RESTART.number);
    }

    public String commandNum() {
        return number;
    }
}
