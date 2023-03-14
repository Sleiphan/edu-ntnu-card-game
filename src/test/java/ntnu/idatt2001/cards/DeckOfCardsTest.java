package ntnu.idatt2001.cards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DeckOfCardsTest {

    @Test
    public void getDeckSize() {
        DeckOfCards deck = new DeckOfCards();
        assertEquals(deck.getDeckSize(), 52);
    }

    @Test
    public void takeTopCard() {
        DeckOfCards deck = new DeckOfCards();
        deck.takeTopCard();
        assert(deck.getDeckSize() == 51);

        while (deck.getDeckSize() > 0)
            deck.takeTopCard();

        assertThrows(IllegalStateException.class, deck::takeTopCard);
    }

    @Test
    public void contains() {
        DeckOfCards deck = new DeckOfCards();
        PlayingCard card = new PlayingCard(PlayingCard.suits[3], 12);
        assert(deck.contains(card));

        card = deck.takeTopCard();
        assertFalse(deck.contains(card));
    }

    @Test
    public void dealHand() {
        int cardAmount = 5;

        DeckOfCards deck = new DeckOfCards();
        assert(deck.getDeckSize() == DeckOfCards.MAX_DECK_SIZE);

        PlayingCard[] cards = deck.dealHand(cardAmount);
        assert(cards.length == cardAmount);
        assert(deck.getDeckSize() == DeckOfCards.MAX_DECK_SIZE - cardAmount);
        for (PlayingCard c : cards)
            assert(!deck.contains(c));
    }

    @Test
    public void returnCard() {
        DeckOfCards deck = new DeckOfCards();
        PlayingCard card = deck.takeTopCard();
        assertFalse(deck.contains(card));
        deck.returnCard(card);
        assert(deck.contains(card));
    }
}
