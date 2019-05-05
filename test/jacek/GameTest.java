package jacek;

import bowling_game.IGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private IGame sut;

    @BeforeEach
    void setUp() {
        sut = new Game();
    }

    @Test
    void rolledAll0_scoreIs0() {
        rollMany(20, 0);

        assertEquals(0, sut.score());
    }

    @Test
    void rolledAll1_scoreIs20() {
        rollMany(20, 1);

        assertEquals(20, sut.score());
    }

    @Test
    void rolledSpare_nextRollIsBonus() {
        rollSpare();
        sut.roll(1);
        rollMany(17, 0);

        assertEquals(12, sut.score());
    }

    @Test
    void rolledStrike_nextTwoRollAreBonus() {
        rollStrike();
        sut.roll(1);
        sut.roll(2);
        rollMany(16, 0);

        assertEquals(16, sut.score());
    }

    @Test
    void perfectGame_scoreIs300() {
        rollMany(12, 10);

        assertEquals(300, sut.score());
    }

    private void rollMany(int rolls, int pins) {
        for (int i = 0; i < rolls; i++) {
            sut.roll(pins);
        }
    }

    private void rollSpare() {
        sut.roll(5);
        sut.roll(5);
    }

    private void rollStrike() {
        sut.roll(10);
    }
}