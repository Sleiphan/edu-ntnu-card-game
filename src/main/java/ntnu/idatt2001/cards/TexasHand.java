package ntnu.idatt2001.cards;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TexasHand {
    public static final int HAND_SIZE = 5;
    private final List<PlayingCard> cards = new ArrayList<PlayingCard>();

    /**
     * @param cards An array of 5 cards.
     * @throws IllegalArgumentException if the parameter is either null or does not contain 5 cards.
     */
    public TexasHand(List<PlayingCard> cards) {
        if (cards == null)
            throw new IllegalArgumentException("Parameter cards cannot be null");
        if (cards.size() != HAND_SIZE)
            throw new IllegalArgumentException("A TexasHand can only consist of exactly 5 cards.");

        this.cards.addAll(cards);
    }

    public TexasHand(PlayingCard[] cards) {
        this(List.of(cards));
    }

    public int getSum() {
        AtomicInteger sum = new AtomicInteger();
        cards.stream().forEach(c -> { sum.addAndGet(c.getFace()); });
        return sum.get();
    }

    public PlayingCard[] getAllHearts() {
        return cards.stream().filter(c -> c.getSuit() == PlayingCard.HEARTS).toArray(PlayingCard[]::new);
    }

    public String getAllHeartsString() {
        PlayingCard[] cs = getAllHearts();
        StringBuilder sb = new StringBuilder();

        for (PlayingCard c : cs)
            sb.append(c.getAsString()).append(" ");

        if (sb.length() > 0)
            sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public boolean containsQueenOfSpades() {
        return cards.stream().anyMatch(c -> c.getSuit() == PlayingCard.SPADES && c.getFace() == 12);
    }

    public boolean isFlush() {
        char firstSuit = cards.get(0).getSuit();
        return cards.stream().allMatch(c -> c.getSuit() == firstSuit);
    }

    public PlayingCard[] getCards() {
        return cards.toArray(new PlayingCard[0]);
    }

    public PlayingCard getCard(int i) {
        return cards.get(i);
    }
}
