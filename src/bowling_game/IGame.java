package bowling_game;

/**
 * Defines bowling game interface.
 */
public interface IGame {
    /**
     * Adds the knocked out pins in the subsequent rolls.
     *
     * @param pins knocked out in a roll
     */
    void roll(int pins);

    /**
     * Calculates a score of the game.
     *
     * @return score of the bowling game.
     */
    int score();
}