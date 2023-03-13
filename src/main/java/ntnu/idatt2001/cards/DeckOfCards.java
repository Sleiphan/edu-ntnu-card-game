package ntnu.idatt2001.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DeckOfCards {

    private static final char[] suits = PlayingCard.suits;
    public static final int STACK_SIZE = 52;
    private static final int NUM_FACES = PlayingCard.NUM_FACES;
    private static final int NUM_SUITS = PlayingCard.NUM_SUITS;



    private final ArrayList<PlayingCard> cards = new ArrayList<>(STACK_SIZE);

    public DeckOfCards() {
        fillDeckSorted();
        shuffle();
    }

    private void fillDeckSorted() {
        if (getDeckSize() != 0)
            cards.clear();
        for (int suit_i = 0; suit_i < NUM_SUITS; suit_i++)
            for (int face = 0; face < NUM_FACES; face++)
                cards.add(new PlayingCard(suits[suit_i], face));
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public boolean empty() {
        return getDeckSize() == 0;
    }

    public PlayingCard takeTopCard() {
        if (empty())
            throw new IllegalStateException("Cannot take the top card of this deck because it is empty");
        return cards.remove(0);
    }

    public PlayingCard[] dealHand(int n) {
        if (cards.size() < n)
            throw new IllegalArgumentException("Cannot deal a hand of " + n + " cards, because the contains too few cards: " + getDeckSize());

        PlayingCard[] hand = new PlayingCard[n];
        for (int i = 0; i < n; i++)
            hand[i] = takeTopCard();

        return hand;
    }

    public int getDeckSize() {
        return cards.size();
    }

    public boolean contains(PlayingCard card) {
        for (PlayingCard c : cards)
            if (card.equals(c))
                return true;
        return false;
    }

    public void returnCard(PlayingCard card) {
        if (getDeckSize() >= STACK_SIZE)
            throw new IllegalArgumentException("Deck cannot contain more cards than " + STACK_SIZE + ".");
        if (contains(card))
            throw new IllegalArgumentException("Deck cannot contain multiple cards of same suit and type.");

        Random r = new Random(System.currentTimeMillis());
        cards.add(r.nextInt(getDeckSize()-1), card);
    }

    public void returnHand(PlayingCard[] cards) {
        for (PlayingCard c : cards)
            returnCard(c);
    }
}
