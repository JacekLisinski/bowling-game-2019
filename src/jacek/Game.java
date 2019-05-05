package jacek;

import bowling_game.IGame;

public class Game implements IGame {
    public static final int NUMBER_OF_FRAMES = 10;
    public static final int MAX_FRAME_SCORE = 10;
    private int currentRoll = 0;
    private int[] rolls = new int[21];

    @Override
    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    @Override
    public int score() {
        int score = 0;
        for (int frame = 0, firstInFrame = 0; frame < NUMBER_OF_FRAMES; frame++) {
            if (isStrike(firstInFrame)) {
                score += MAX_FRAME_SCORE + strikeBonus(firstInFrame);
                firstInFrame++;
            } else if (isSpare(firstInFrame)) {
                score += MAX_FRAME_SCORE + spareBonus(firstInFrame);
                firstInFrame += 2;
            } else {
                score += frameScore(firstInFrame);
                firstInFrame += 2;
            }
        }

        return score;
    }

    private int frameScore(int firstInFrame) {
        return rolls[firstInFrame] + rolls[firstInFrame + 1];
    }

    private boolean isStrike(int firstInFrame) {
        return rolls[firstInFrame] == 10;
    }

    private int strikeBonus(int firstInFrame) {
        return rolls[firstInFrame + 1] + rolls[firstInFrame + 2];
    }

    private boolean isSpare(int firstInFrame) {
        return rolls[firstInFrame] + rolls[firstInFrame + 1] == 10;
    }

    private int spareBonus(int firstInFrame) {
        return rolls[firstInFrame + 2];
    }
}
