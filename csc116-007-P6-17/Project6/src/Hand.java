import java.util.*;
/** 
 * Represents hand of cards
 * @author Dan Longo
 * @author Suzanne Balik
 * @author Eli Newman
 */
public class Hand {
    /** Creates a constant for number of cards in a hand */
    public static final int CARDS_IN_HAND = 5;
    /** Contains cards in hand */
    private Card[] hand;
    /**
     * Constructs the player's hand and tests for exceptions
     * @param hand for the given card array
     */
    public Hand(Card[] hand) {
        this.hand = hand;
        if (hand == null) {
            throw new NullPointerException("Null array");
        } else if (hand.length != CARDS_IN_HAND) {
            throw new IllegalArgumentException("Invalid array length");
        }
        for (int i = 0; i < hand.length; i++) {
            if (hand[i] == null) {
                throw new NullPointerException("Null element");
            }
        }
    }
    /**
     * Gets a card from the hand
     * @param index for the number where the card is in array
     * @return card asked for
     */
    public Card getCard(int index) {
        if (index < 0 || index >= CARDS_IN_HAND) {
            throw new IllegalArgumentException("Invalid index");
        }
        return hand[index];
    }
    /**
     * Replaces the given card with a new card
     * @param index for card to replace
     * @param card for Card object to replace with
     */
    public void replace(int index, Card card) {
        if (index < 0 || index >= CARDS_IN_HAND) {
            throw new IllegalArgumentException("Invalid index");
        } else if (card == null) {
            throw new NullPointerException("Null card");
        }
        hand[index] = card;
    }
    /**
     * Creates a string represtantation of the hand
     * @return string of hand
     */
    public String toString() {
        String hands = "[";
        for (int i = 0; i < hand.length; i++) {
            hands += hand[i].toString() + ", ";
        }
        /** Removes the last comma and space */
        hands = hands.substring(0, (hands.length() - 2));
        hands += "]";
        return hands;
    }
    /**
     * Checks if one hand is equal to another one
     * @param o for the testing hand
     * @return result if they are equal
     */
    public boolean equals(Object o) {
        if (o instanceof Hand) {
            Hand equal = (Hand) o;
            equal = new Hand(equal.getSortedHand());
            this.hand = getSortedHand();
            return Arrays.equals(this.hand, equal.hand);
        } else {
            return false;
        }
    }
    /**
     * Checks if the hand has a flush
     * @return boolean if true
     */
    public boolean isFlush() {
        return (hand[0].getSuit() == hand[1].getSuit() &&
            hand[1].getSuit() == hand[2].getSuit() &&
            hand[2].getSuit() == hand[3].getSuit() &&
            hand[3].getSuit() == hand[CARDS_IN_HAND - 1].getSuit());
    }
    /**
     * Checks if the hand has a straight
     * @return boolean if true
     */
    public boolean isStraight() {
        Card[] hands = getSortedHand();
        return (hands[0].getValue() + 1 == hands[1].getValue() &&
            hands[1].getValue() + 1 == hands[2].getValue() &&
            hands[2].getValue() + 1 == hands[3].getValue() &&
            hands[3].getValue() + 1 == hands[CARDS_IN_HAND - 1].getValue());
    }
    /**
     * Checks if the hand has a straight flush
     * @return boolean if true
     */
    public boolean isStraightFlush() {
        boolean flush = isFlush();
        boolean straight = isStraight();
        return (flush == true && straight == true);
    }
    /**
     * Checks if the hand has a royal flush
     * @return boolean if true
     */
    public boolean isRoyalFlush() {
        Card[] hands = getSortedHand();
        boolean flush = isFlush();
        return (flush == true && hands[0].getValue() == 
            (Card.HIGHEST_VALUE - (CARDS_IN_HAND - 1)) &&
            hands[1].getValue() == (Card.HIGHEST_VALUE - 3) && 
            hand[2].getValue() == (Card.HIGHEST_VALUE - 2) &&
            hand[3].getValue() == (Card.HIGHEST_VALUE - 1) && 
            hand[CARDS_IN_HAND - 1].getValue() == Card.HIGHEST_VALUE);
    }
    /**
     * Checks if the hand has a four of a kind
     * @return boolean if true
     */
    public boolean hasFourOfAKind() {
        boolean fourOfAKind = false;
        int[] count = getCounts();
        for (int i = 0; i < count.length; i++) {
            if (count[i] == (CARDS_IN_HAND - 1)) {
                fourOfAKind = true;
            }
        }
        return fourOfAKind;
    }
    /**
     * Checks if the hand has a three of a kind
     * @return boolean if true
     */
    public boolean hasThreeOfAKind() {
        boolean threeOfAKind = false;
        int[] count = getCounts();
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 3) {
                threeOfAKind = true;
            }
        }
        return threeOfAKind;
    }
    /**
     * Checks if the hand has two pairs
     * @return boolean if true
     */
    public boolean hasTwoPairs() {
        boolean twoPairs = false;
        int pairCount = 0;
        int[] count = getCounts();
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 2) {
                pairCount++;
            }
        }
        if (pairCount == 2) {
            twoPairs = true;
        }
        return twoPairs;
    }
    /**
     * Checks if the hand has a pair
     * @return boolean if true
     */
    public boolean hasOnePair() {
        boolean onePair = false;
        int pairCount = 0;
        /** Looks at each card and sees if any subsequent cards are the same value */
        for (int i = 0; i < hand.length; i++) {
            int card = hand[i].getValue();
            for (int j = i + 1; j < hand.length; j++) {
                if (hand[j].getValue() == card) {
                    pairCount++;
                }
            }
        }
        if (pairCount == 1) {
            onePair = true;
        }
        return onePair;
    }
    /**
     * Checks if the hand has a full house
     * @return boolean if true
     */
    public boolean isFullHouse() {
        boolean threeOfAKind = false;
        boolean onePair = false;
        int[] count = getCounts();
        /** Checks if there is a three of a kind and if so checks for pair */
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 3) {
                threeOfAKind = true;
                for (int j = 0; j < count.length; j++) {
                    if (count[j] == 2) {
                        onePair = true;
                    }
                }
            }
        }
        return (threeOfAKind == true && onePair == true);
    }
    /**
     * Counts the number of cards with each value in the hand
     * @return tally array containing number of cards of each value from 2 to 14.
     */
    public int[] getCounts() {
        int[] counts = new int[Card.HIGHEST_VALUE + 1];
        for (int i = 0; i < hand.length; i++) {
            counts[hand[i].getValue()]++;
        }
        return counts;
    }

    /**
     * Creates a copy of the hand sorted first by value, then by suit
     * @return copy of the hand sorted first by value, then by suit
     */
    public Card[] getSortedHand() {
        Card[] sortedHand = Arrays.copyOf(hand, hand.length);
        Arrays.sort(sortedHand);
        return sortedHand;
    }
}