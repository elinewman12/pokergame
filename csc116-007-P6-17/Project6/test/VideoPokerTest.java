import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * Tests VideoPoker class
 * @author Suzanne Balik
 */
public class VideoPokerTest extends TestCase {
    
    /** VideoPoker instance used for testing */
    private VideoPoker vp;

    /**
     * Create a new Video Poker game with seed of 1 for testing
     */
    @Before
    public void setUp() {
        vp = new VideoPoker(1);
    }

    @Test
    public void testConstants() {
        assertEquals("RANDOM_GAME", -1, VideoPoker.RANDOM_GAME);
        assertEquals("CARDS_IN_HAND", 5, VideoPoker.CARDS_IN_HAND);
        assertEquals("STARTING_POINTS", 100, VideoPoker.STARTING_POINTS);
        assertEquals("POINTS_FOR_NEW_GAME", 10, VideoPoker.POINTS_FOR_NEW_GAME);
        assertEquals("ROYAL_FLUSH", 100, VideoPoker.ROYAL_FLUSH);
        assertEquals("STRAIGHT_FLUSH ", 60, VideoPoker.STRAIGHT_FLUSH );
        assertEquals("FOUR_OF_A_KIND", 50, VideoPoker.FOUR_OF_A_KIND);
        assertEquals("FULL_HOUSE", 40, VideoPoker.FULL_HOUSE);
        assertEquals("FLUSH", 30, VideoPoker.FLUSH);
        assertEquals("STRAIGHT", 25, VideoPoker.STRAIGHT);
        assertEquals("THREE_OF_A_KIND", 15, VideoPoker.THREE_OF_A_KIND );
        assertEquals("TWO_PAIRS", 10, VideoPoker.TWO_PAIRS);
        assertEquals("ONE_PAIR", 7, VideoPoker.ONE_PAIR);
    }

    @Test
    public void testConstructor() {

        assertEquals("Initial points", 100, vp.getPoints());

    }

    @Test
    public void testPlaySingleGame() {
        vp.newGame();
        assertEquals("Initial game", 90, vp.getPoints());
    }

}