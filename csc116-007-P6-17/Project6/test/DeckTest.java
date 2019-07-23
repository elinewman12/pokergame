import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * Tests Deck class
 * @author Suzanne Balik
 */
public class DeckTest extends TestCase {
    
    /** deck instance for testing */
    private Deck deck;

    /** deck string representation for testing */
    private String deckString;

    /**
     * Creates deck and string representation for testing
     */
    @Before
    public void setUp() {
        deck = new Deck(1); 
        deckString = "";
        int card = 0;
        for (int i = 2; i <= 14; i++) {
            deckString += "card " + card++ + ": c" + i + "\n";
        } 
        for (int i = 2; i <= 14; i++) {
            deckString += "card " + card++ + ": d" + i + "\n";
        } 
        for (int i = 2; i <= 14; i++) {
            deckString += "card " + card++ + ": h" + i + "\n";
        }
        for (int i = 2; i <= 14; i++) {
            deckString += "card " + card++ + ": s" + i + "\n";
        }
    }

    @Test
    public void testConstants() {
        // The following test tests that the constant is defined as specified
        assertEquals("CARDS_IN_DECK", 52, Deck.CARDS_IN_DECK);
    }

    @Test
    public void testToString() {
        assertEquals("toString  after constructed", deckString, deck.toString());
    }

    @Test
    public void testNextCard() {
        assertEquals("next card after constructed", new Card(2,'c'), deck.nextCard());
        assertEquals("second card", new Card(3, 'c'), deck.nextCard());
    }

    @Test
    public void testShuffle() {
        deck.shuffle();
        assertNotSame("deck should change when shuffled", deckString, deck.toString());
    }

    @Test
    public void testEquals() {
        Deck deckWithSameSeed = new Deck(1);
        Deck deckWithDifferentSeed = new Deck(5);
        assertTrue("deck equals with same instance", deck.equals(deck));
        assertTrue("deck equals with different instances", deck.equals(deckWithSameSeed));
        assertFalse("deck with different seed", deck.equals(deckWithDifferentSeed));
        assertFalse("deck compared to null object", deck.equals(null));
        assertFalse("deck compared to String", deck.equals("Deck"));
        deck.shuffle();
        assertFalse("deck compared to shuffled deck", deckWithSameSeed.equals(deck));
    }

}