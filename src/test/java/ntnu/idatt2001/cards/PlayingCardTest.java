package ntnu.idatt2001.cards;

import ntnu.idatt2001.cards.PlayingCard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PlayingCardTest {

    @Test
    public void testConstructor() {
        int suit = 1;
        int face = 5;

        PlayingCard card = new PlayingCard(PlayingCard.suits[suit], face);
        assert(card.getFace() == face);
        assert(card.getSuit() == PlayingCard.suits[suit]);
    }

    @Test
    public void testEquals() {
        PlayingCard[] cards = new PlayingCard[52];
        for (int suit = 0; suit < PlayingCard.NUM_SUITS; suit++)
            for (int face = 0; face < PlayingCard.NUM_FACES; face++)
                cards[suit * PlayingCard.NUM_FACES + face] = new PlayingCard(PlayingCard.suits[suit], face);

        for (PlayingCard card : cards) assert (card.equals(card));

        for (int i = 0; i < cards.length - 1; i++)
            for (int j = i + 1; j < cards.length; j++)
                assertNotEquals(cards[i], cards[j]);
    }
}
