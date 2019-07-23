import java.util.*;
/**
 * Creates the poker game and uses objects to display cards
 * @author Eli Newman
 */
public class VideoPoker {
    /** Creates a constant for creating a random game */
    public static final int RANDOM_GAME = -1;
    /** Creates a constant for how many cards in a hand */
    public static final int CARDS_IN_HAND = 5;
    /** Creates a constant for how many points to start with */
    public static final int STARTING_POINTS = 100;
    /** Creates a constant for how many points it costs per game */
    public static final int POINTS_FOR_NEW_GAME = 10;
    /** Creates a constant for royal flush points */
    public static final int ROYAL_FLUSH = 100;
    /** Creates a constant for straight flush points */
    public static final int STRAIGHT_FLUSH = 60;
    /** Creates a constant for four of a kind points */
    public static final int FOUR_OF_A_KIND = 50;
    /** Creates a constant for full house points */
    public static final int FULL_HOUSE = 40;
    /** Creates a constant for flush points */
    public static final int FLUSH = 30;
    /** Creates a constant for straight points */
    public static final int STRAIGHT = 25;
    /** Creates a constant for three of a kind points */
    public static final int THREE_OF_A_KIND = 15;
    /** Creates a constant for two pairs points */
    public static final int TWO_PAIRS = 10;
    /** Creates a constant for one pair points */
    public static final int ONE_PAIR = 7;
    /** Creates a field for the deck object */
    private Deck deck;
    /** Creates a field for the player's hand */
    private Hand hand;
    /** Creates a field for the amount of points the player has */
    private int points;
    /**
     * Runs the video poker game using the deck seed given
     * @param seed for the deck
     */
    public VideoPoker(int seed) {
        deck = new Deck(seed);
        points = STARTING_POINTS;
    }
    /**
     * gets the amount of points
     * @return points
     */
    public int getPoints() {
        return points;
    }
    /**
     * gets the file for the cards
     * @param index of cards
     * @return the file name
     */
    public String getCardFileName(int index) {
        Card card = hand.getCard(index);
        return "cards/" + card.toString() + ".gif";
    }
    /**
     * gets the card from a specific index
     * @param index for the specific card
     * @return the card object
     */
    public Card getCard(int index) {
        Card cardNeeded = hand.getCard(index);
        return cardNeeded;
    }
    /**
     * Starts the game
     */
    public void newGame() {
        points -= POINTS_FOR_NEW_GAME;
        deck.shuffle();
        Card[] newArray = new Card[CARDS_IN_HAND];
        for (int i = 0; i < CARDS_IN_HAND; i++) {
            newArray[i] = deck.nextCard();
        }
        hand = new Hand(newArray);
    }
    /**
     * Replaces a card in the deck
     * @param index for specific card
     */
    public void replaceCard(int index) {
        Card card = deck.nextCard();
        hand.replace(index, card);
    }
    /**
     * Returns the score of the current hand
     * @return score in hand
     */
    public String scoreHand() {
        if (hand.isRoyalFlush() == true) {
            points += ROYAL_FLUSH;
            return "Royal Flush";
        } else if (hand.isStraightFlush() == true) {
            points += STRAIGHT_FLUSH;
            return "Straight Flush";
        } else if (hand.hasFourOfAKind() == true) {
            points += FOUR_OF_A_KIND;
            return "Four of a Kind";
        } else if (hand.isFullHouse() == true) {
            points += FULL_HOUSE;
            return "Full House";
        } else if (hand.isFlush() == true) {
            points += FLUSH;
            return "Flush";
        } else if (hand.isStraight() == true) {
            points += STRAIGHT;
            return "Straight";
        } else if (hand.hasThreeOfAKind() == true) {
            points += THREE_OF_A_KIND;
            return "Three of a Kind";
        } else if (hand.hasTwoPairs() == true) {
            points += TWO_PAIRS;
            return "Two Pairs";
        } else if (hand.hasOnePair() == true) {
            points += ONE_PAIR;
            return "One Pair";
        } else {
            return "No Pair";
        }
    }
}