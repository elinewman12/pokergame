import java.util.*;
import java.util.Random;
/**
 * Object that represents the whole deck of cards
 * @author Eli Newman
 */
public class Deck {
    /** Creates a constant for amount of cards in deck */
    public static final int CARDS_IN_DECK = 52;
    /** Creates a constant for amount of cards in a suit minus one */
    public static final int CARDS_IN_SUIT = 12;
    /** Creates a field for the deck array */
    private Card[] cardArray;
    /** Creates a field for the index of the card in deck */
    private int nextIndex;
    /** Creates a field for the randomized seed for deck */
    private int randomSeed;
    /**
     * Constructs the deck of cards and uses seed
     * @param seed for the randomized deck seed
     */
    public Deck(int seed) {
        /** Intializes the array of cards and seed */
        cardArray = new Card[CARDS_IN_DECK];
        randomSeed = seed;
        this.randomSeed = randomSeed;
        int count = Card.LOWEST_VALUE;
        char suit = Card.CLUBS;
        /** fills the deck with cards in order least to greatest by suit */
        for (int i = 0; i < CARDS_IN_DECK; i++) {
            cardArray[i] = new Card(count, suit);
            if (count == Card.HIGHEST_VALUE) {
                count = Card.LOWEST_VALUE - 1;
            }
            /** Changes the suit */
            if (i == CARDS_IN_SUIT) {
                suit = Card.DIAMONDS;
            } else if (i == (CARDS_IN_SUIT * 2) + 1) {
                suit = Card.HEARTS;
            } else if (i == (CARDS_IN_SUIT * 3) + 2) {
                suit = Card.SPADES;
            }
            count++;
        }
        this.cardArray = cardArray;
        this.nextIndex = nextIndex;
    }
    /**
     * Shuffles the deck for randomization
     */
    public void shuffle() {
        Random rand = null;
        if (randomSeed != -1) {
            rand = new Random(randomSeed);
        } else {
            rand = new Random();
        }
        /** Creates a random number for index to switch and switches cards */
        for (int i = CARDS_IN_DECK - 1; i > 0; i--) {
            int n = rand.nextInt(CARDS_IN_DECK);
            Card changeCard = cardArray[i];
            cardArray[i] = cardArray[n];
            cardArray[n] = changeCard;
        }
        nextIndex = 0;
    }
    /**
     * Determines what the next is going to be in deck
     * @return the next card object
     */
    public Card nextCard() {
        nextIndex += 1;
        return cardArray[nextIndex - 1];
    }
    /**
     * Determines if the given deck object has the same
     * state as this deck object
     * @param o deck object to compare to
     * @return true if objects equal each other, false if not
     */
    public boolean equals(Object o) {
        if (o instanceof Deck) {
            Deck equal = (Deck) o;
            return Arrays.equals(this.cardArray, equal.cardArray)
                    && this.nextIndex == equal.nextIndex
                    && this.randomSeed == equal.randomSeed;
        } else {
            return false;
        }
    }
    /**
     * Returns the string representation of the deck object
     * @return string with array and randomized cards
     */
    public String toString() {
        String deck = "";
        for (int i = 0; i < cardArray.length; i++) {
            deck += "card " + i + ": " + cardArray[i].toString() + "\n";
        }
        return deck;
    }
}