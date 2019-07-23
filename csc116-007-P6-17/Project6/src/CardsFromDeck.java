/**
 * Outputs first 10 cards from Deck after it's been
 * shuffled using Random number generator created
 * using seed supplied as command line argument
 *
 * @author Suzanne Balik
 */
public class CardsFromDeck {

    /** Number of cards to output */
    public static final int MAX_CARDS = 10;
    
    
    /**
     * Outputs first 10 cards from Deck after 
     * creating Deck using seed and shuffling it
     * @param args args[0] seed used to create Deck
     */
    public static void main(String[] args) {
    
        if (args.length != 1) {
            System.out.println("Usage: java -cp bin CardsFromDeck seed");
            System.exit(1);
        }
        int seed = 0;
        try {
            seed = Integer.parseInt(args[0]);
        }
        catch (NumberFormatException e) {
            System.out.println("seed must be an integer");
        }
        
        Deck deck = new Deck(seed);
        deck.shuffle();
        System.out.print("[");
        for (int i = 1; i <= MAX_CARDS; i++) {
            System.out.print(deck.nextCard().toString());
            if (i < MAX_CARDS) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
/* SAMPLE OUTPUT -- YOURS MAY DIFFER!
csc$ java -cp bin CardsFromDeck 1
[s7, h2, d5, h8, h4, h5, d13, h9, d14, s3]
*/