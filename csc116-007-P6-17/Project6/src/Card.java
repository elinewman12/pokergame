import java.util.*;
/**
 * Object that represents a card in the deck
 * @author Eli Newman
 */
public class Card implements Comparable<Card> {
    /** Creates a constant for clubs */
    public static final char CLUBS = 'c';
    /** Creates a constant for diamonds */
    public static final char DIAMONDS = 'd';
    /** Creates a constant for spades */
    public static final char SPADES = 's';
    /** Creates a constant for hearts */
    public static final char HEARTS = 'h';
    /** Creates a constant for the lowest value of a card */
    public static final int LOWEST_VALUE = 2;
    /** Creates a constant for the highest value of a card */
    public static final int HIGHEST_VALUE = 14;
    /** Creates a field for the value of a card */
    private int value;
    /** Creates a field for the suit of a card */
    private char suit;
    /**
     * Constructs and intializes a Card object
     * @param value the value of the card
     * @param suit the suit of the card
     */
    public Card(int value, char suit) {
        if (value < LOWEST_VALUE || value > HIGHEST_VALUE) {
            throw new IllegalArgumentException("Invalid value");
        } else if (suit != CLUBS && suit != DIAMONDS && suit != SPADES &&
                   suit != HEARTS) {
            throw new IllegalArgumentException("Invalid suit");           
        }
        this.value = value;
        this.suit = suit;
    }
    /**
     * Returns the value of the card
     * @return value of card
     */
    public int getValue() {
        return value;
    }
    /**
     * Returns the suit of the card
     * @return suit of card
     */
    public char getSuit() {
        return suit;
    }
    /**
     * Determines if the given Card object has the same
     * state as this Card object
     * @param o Card object to compare to
     * @return true if objects equal each other, false if not
     */
    public boolean equals(Object o) {
        if (o instanceof Card) {
            Card equal = (Card) o;
            return this.value == equal.getValue()
                    && this.suit == equal.getSuit();
        } else {
            return false;
        }
    }
    /**
     * Returns the string representation of the card object
     * @return string with value and suit
     */
    public String toString() {
        return "" + suit + value;
    }
    
    /**
     * This method is used for sorting the cards in a player's hand in a game of
     * Poker. Cards are sorted first by value, then by suit.
     * 
     * @param other
     *            The Card object to which this Card is being compared.
     * @return negative value if this Card should be before the other Card,
     *         positive value if this Card should be after the other Card.
     */
    public int compareTo(Card other) {
        if (this.value != other.value) {
            return this.value - other.value;
        } else {
            return this.suit - other.suit;
        }
    }
}