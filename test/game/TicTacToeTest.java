package game;
import org.junit.After;
import org.junit.Before;
import org.testng.annotations.Test;
import game.TicTacToe.Peg;

import java.sql.SQLOutput;

import static org.junit.Assert.*;
import static org.testng.AssertJUnit.assertTrue;

public class TicTacToeTest {
    TicTacToe ticTacToe = new TicTacToe();

    @Before
    public void setUp() {
        ticTacToe = new TicTacToe();
    }

    @Test
    public void Canary() {
        assertTrue(true);
    }

    @Test
    public void GameWonByNoneAtStart() {
        assertEquals(Peg.NONE, ticTacToe.winner());
    }

    @Test
    public void placeFirstPeg() {
        assertEquals(Peg.FIRST, ticTacToe.placePeg(0, 1));
    }

    @Test
    public void placeSecondPeg() {
        ticTacToe.placePeg(0, 2);
        assertEquals(Peg.SECOND, ticTacToe.placePeg(0, 1));
    }

    @Test
    public void PlacePegAtOccupiedPosition() {
        ticTacToe.placePeg(2, 1);
        assertEquals(Peg.FIRST, ticTacToe.placePeg(2, 1));
    }

    @Test
    public void placePegOutOfRowRange() {
        try {
            ticTacToe.placePeg(0, 7);
            fail("Expected exception for stepping out of bound");
        } catch(IndexOutOfBoundsException ex) {
            // :)
        }
    }

    @Test
    public void winnerReportsRowMatch() {
        ticTacToe = new TicTacToe() {
            @Override
            public Peg checkRowMatch() {
                return Peg.SECOND;
            }
        };
        assertEquals(Peg.SECOND, ticTacToe.winner());
    }

    @Test
    public void winnerReportsColumnMatch() {
        ticTacToe = new TicTacToe() {
            @Override
            public Peg checkRowMatch() {
                return Peg.NONE;
            }

            @Override
            public Peg checkColumnMatch() {
                return Peg.FIRST;
            }
        };
        assertEquals(Peg.FIRST, ticTacToe.winner());
    }

}
