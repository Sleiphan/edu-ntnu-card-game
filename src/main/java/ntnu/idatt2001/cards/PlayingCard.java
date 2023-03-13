package ntnu.idatt2001.cards;

/**
 * Represents a playing card. A playing card has a number (face) between
 * 1 and 13, where 1 is called an Ace, 11 = Knight, 12 = Queen and 13 = King.
 * The card can also be one of 4 suits: Spade, Heart, Diamonds and Clubs.
 *
 * @author ntnu
 * @version 2020-01-10
 */
public class PlayingCard {
    public static final char[] suits = { 'S', 'H', 'C', 'D' };
    public static final int NUM_FACES = 13;
    public static final int NUM_SUITS = suits.length;



    private final char suit; // 'S'=spade, 'H'=heart, 'D'=diamonds, 'C'=clubs
    private final int face; // a number between 1 and 13

    private final int hashCode;

    /**
     * Creates an instance of a PlayingCard with a given suit and face.
     *
     * @param suit The suit of the card, as a single character. 'S' for Spades,
     *             'H' for Heart, 'D' for Diamonds and 'C' for clubs
     * @param face The face value of the card, an integer between 0 and 12
     */
    public PlayingCard(char suit, int face) {
        switch (suit) {
            case 'S':
            case 'H':
            case 'D':
            case 'C':
                this.suit = suit;
                break;
            default: throw new IllegalArgumentException("Suit must be one of the following: S, H, D, C");
        }

        if (face < 0 || face > 12)
            throw new IllegalArgumentException("Face must be a value between 0 and 12");
        this.face = face;

        hashCode = suit * NUM_FACES + face;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PlayingCard))
            return false;

        return hashCode() == o.hashCode();
    }

    @Override
    public int hashCode() {
        return hashCode;
    }

    /**
     * Returns the suit and face of the card as a string.
     * A 4 of hearts is returned as the string "H4".
     *
     * @return the suit and face of the card as a string
     */
    public String getAsString() {
        return String.format("%s%s", suit, face);
    }

    /**
     * Returns the suit of the card, 'S' for Spades, 'H' for Heart, 'D' for Diamonds and 'C' for Clubs
     *
     * @return the suit of the card
     */
    public char getSuit() {
        return suit;
    }

    /**
     * Returns the face of the card (value between 1 and 13).
     *
     * @return the face of the card
     */
    public int getFace() {
        return face;
    }
}