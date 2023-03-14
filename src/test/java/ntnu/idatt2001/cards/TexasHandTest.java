package ntnu.idatt2001.cards;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TexasHandTest {

    private static TexasHand sum15_hasHearts2_noQueen_notFlush;
    private static TexasHand sum24_noHearts_hasQueen_isFlush;
    private static TexasHand sum22_hasHearts5_hasQueen_notFlush;

    @BeforeAll
    static void setup() {
        List<PlayingCard> cards1 = new ArrayList<>();
        cards1.add(new PlayingCard(PlayingCard.SPADES, 1));
        cards1.add(new PlayingCard(PlayingCard.HEARTS, 2));
        cards1.add(new PlayingCard(PlayingCard.CLUBS, 3));
        cards1.add(new PlayingCard(PlayingCard.DIAMONDS, 4));
        cards1.add(new PlayingCard(PlayingCard.SPADES, 5));
        sum15_hasHearts2_noQueen_notFlush = new TexasHand(cards1);

        List<PlayingCard> cards2 = new ArrayList<>();
        cards2.add(new PlayingCard(PlayingCard.SPADES, 1));
        cards2.add(new PlayingCard(PlayingCard.SPADES, 2));
        cards2.add(new PlayingCard(PlayingCard.SPADES, 12));
        cards2.add(new PlayingCard(PlayingCard.SPADES, 4));
        cards2.add(new PlayingCard(PlayingCard.SPADES, 5));
        sum24_noHearts_hasQueen_isFlush = new TexasHand(cards2);

        List<PlayingCard> cards3 = new ArrayList<>();
        cards3.add(new PlayingCard(PlayingCard.SPADES, 1));
        cards3.add(new PlayingCard(PlayingCard.HEARTS, 5));
        cards3.add(new PlayingCard(PlayingCard.CLUBS, 3));
        cards3.add(new PlayingCard(PlayingCard.DIAMONDS, 1));
        cards3.add(new PlayingCard(PlayingCard.SPADES, 12));
        sum22_hasHearts5_hasQueen_notFlush = new TexasHand(cards3);
    }

    @Test
    void getSum() {
        assertEquals(sum15_hasHearts2_noQueen_notFlush.getSum(), 15);
        assertEquals(sum24_noHearts_hasQueen_isFlush.getSum(), 24);
        assertEquals(sum22_hasHearts5_hasQueen_notFlush.getSum(), 22);
    }

    @Test
    void getAllHearts() {
        assert(sum15_hasHearts2_noQueen_notFlush.getAllHearts()[0].getFace() == 2);
        assert(sum24_noHearts_hasQueen_isFlush.getAllHearts().length == 0);
        assert(sum22_hasHearts5_hasQueen_notFlush.getAllHearts()[0].getFace() == 5);
    }

    @Test
    void containsQueenOfSpades() {
        assert(!sum15_hasHearts2_noQueen_notFlush.containsQueenOfSpades());
        assert(sum24_noHearts_hasQueen_isFlush.containsQueenOfSpades());
        assert(sum22_hasHearts5_hasQueen_notFlush.containsQueenOfSpades());
    }

    @Test
    void isFlush() {
        assert(!sum15_hasHearts2_noQueen_notFlush.isFlush());
        assert(sum24_noHearts_hasQueen_isFlush.isFlush());
        assert(!sum22_hasHearts5_hasQueen_notFlush.isFlush());
    }
}
