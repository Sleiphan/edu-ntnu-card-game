package ntnu.idatt2001.cards;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class CardImages {

    private static final String imagePath = "Playing_cards.png";
    private static final int IMAGE_OFFSET_X = 2;
    private static final int IMAGE_OFFSET_Y = 2;
    public static final int CARD_SIZE_X = 316;
    public static final int CARD_SIZE_Y = 440;
    private static final int CARD_INTERVAL_X = 352;
    private static final int CARD_INTERVAL_Y = 512;
    private static final int NUM_FACES = 13;
    private static final int NUM_SUITS = 4;

    private static final BufferedImage bigImage;
    private static final Image[] cards = new Image[NUM_SUITS * NUM_FACES + 1];
    static {
        try {
            bigImage = ImageIO.read(Objects.requireNonNull(CardImages.class.getClassLoader().getResourceAsStream(imagePath)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        for (int suit = 0; suit < NUM_SUITS; suit++) {
            for (int face = 0; face < NUM_FACES; face++) {
                cards[suit * NUM_FACES + face] = SwingFXUtils.toFXImage(bigImage.getSubimage(
                        IMAGE_OFFSET_X + CARD_INTERVAL_X * face,
                        IMAGE_OFFSET_Y + CARD_INTERVAL_Y * suit,
                        CARD_SIZE_X,
                        CARD_SIZE_Y), null);
            }
        }

        cards[cards.length - 1] = SwingFXUtils.toFXImage(bigImage.getSubimage(
                IMAGE_OFFSET_X + CARD_INTERVAL_X * NUM_FACES,
                IMAGE_OFFSET_Y + CARD_INTERVAL_Y * 0,
                CARD_SIZE_X,
                CARD_SIZE_Y), null);
    }

    public static Image getImage(PlayingCard card) {
        return getImage(card.getSuitIndex(), card.getFace());
    }

    public static Image getImage(int suit, int face) {
        face -= 1;
        if (suit >= NUM_SUITS || suit < 0)
            throw new IllegalArgumentException("suit must be a number between 0 and " + NUM_SUITS + ". Value submitted: " + suit);
        if (face >= NUM_FACES || face < 0)
            throw new IllegalArgumentException("face must be a number between 1 and " + NUM_FACES + ". Value submitted: " + face);
        suit = 3 - suit;
        return cards[suit * NUM_FACES + face];
    }

    public static final Image DIAMOND_1 = cards[0];
    public static final Image DIAMOND_2 = cards[1];
    public static final Image DIAMOND_3 = cards[2];
    public static final Image DIAMOND_4 = cards[3];
    public static final Image DIAMOND_5 = cards[4];
    public static final Image DIAMOND_6 = cards[5];
    public static final Image DIAMOND_7 = cards[6];
    public static final Image DIAMOND_8 = cards[7];
    public static final Image DIAMOND_9 = cards[8];
    public static final Image DIAMOND_10 = cards[9];
    public static final Image DIAMOND_11 = cards[10];
    public static final Image DIAMOND_12 = cards[11];
    public static final Image DIAMOND_13 = cards[12];
    public static final Image DIAMOND_ACE =   DIAMOND_1;
    public static final Image DIAMOND_JACK =  DIAMOND_11;
    public static final Image DIAMOND_QUEEN = DIAMOND_12;
    public static final Image DIAMOND_KING =  DIAMOND_13;

    public static final Image CLUBS_1 = cards[1 * NUM_FACES + 0];
    public static final Image CLUBS_2 = cards[1 * NUM_FACES + 1];
    public static final Image CLUBS_3 = cards[1 * NUM_FACES + 2];
    public static final Image CLUBS_4 = cards[1 * NUM_FACES + 3];
    public static final Image CLUBS_5 = cards[1 * NUM_FACES + 4];
    public static final Image CLUBS_6 = cards[1 * NUM_FACES + 5];
    public static final Image CLUBS_7 = cards[1 * NUM_FACES + 6];
    public static final Image CLUBS_8 = cards[1 * NUM_FACES + 7];
    public static final Image CLUBS_9 = cards[1 * NUM_FACES + 8];
    public static final Image CLUBS_10 = cards[1 * NUM_FACES + 9];
    public static final Image CLUBS_11 = cards[1 * NUM_FACES + 10];
    public static final Image CLUBS_12 = cards[1 * NUM_FACES + 11];
    public static final Image CLUBS_13 = cards[1 * NUM_FACES + 12];
    public static final Image CLUBS_ACE =   CLUBS_1;
    public static final Image CLUBS_JACK =  CLUBS_11;
    public static final Image CLUBS_QUEEN = CLUBS_12;
    public static final Image CLUBS_KING =  CLUBS_13;

    public static final Image HEARTS_1 = cards[2 * NUM_FACES + 0];
    public static final Image HEARTS_2 = cards[2 * NUM_FACES + 1];
    public static final Image HEARTS_3 = cards[2 * NUM_FACES + 2];
    public static final Image HEARTS_4 = cards[2 * NUM_FACES + 3];
    public static final Image HEARTS_5 = cards[2 * NUM_FACES + 4];
    public static final Image HEARTS_6 = cards[2 * NUM_FACES + 5];
    public static final Image HEARTS_7 = cards[2 * NUM_FACES + 6];
    public static final Image HEARTS_8 = cards[2 * NUM_FACES + 7];
    public static final Image HEARTS_9 = cards[2 * NUM_FACES + 8];
    public static final Image HEARTS_10 = cards[2 * NUM_FACES + 9];
    public static final Image HEARTS_11 = cards[2 * NUM_FACES + 10];
    public static final Image HEARTS_12 = cards[2 * NUM_FACES + 11];
    public static final Image HEARTS_13 = cards[2 * NUM_FACES + 12];
    public static final Image HEARTS_ACE =   HEARTS_1;
    public static final Image HEARTS_JACK =  HEARTS_11;
    public static final Image HEARTS_QUEEN = HEARTS_12;
    public static final Image HEARTS_KING =  HEARTS_13;

    public static final Image SPADES_1 = cards[3 * NUM_FACES + 0];
    public static final Image SPADES_2 = cards[3 * NUM_FACES + 1];
    public static final Image SPADES_3 = cards[3 * NUM_FACES + 2];
    public static final Image SPADES_4 = cards[3 * NUM_FACES + 3];
    public static final Image SPADES_5 = cards[3 * NUM_FACES + 4];
    public static final Image SPADES_6 = cards[3 * NUM_FACES + 5];
    public static final Image SPADES_7 = cards[3 * NUM_FACES + 6];
    public static final Image SPADES_8 = cards[3 * NUM_FACES + 7];
    public static final Image SPADES_9 = cards[3 * NUM_FACES + 8];
    public static final Image SPADES_10 = cards[3 * NUM_FACES + 9];
    public static final Image SPADES_11 = cards[3 * NUM_FACES + 10];
    public static final Image SPADES_12 = cards[3 * NUM_FACES + 11];
    public static final Image SPADES_13 = cards[3 * NUM_FACES + 12];
    public static final Image SPADES_ACE =   SPADES_1;
    public static final Image SPADES_JACK =  SPADES_11;
    public static final Image SPADES_QUEEN = SPADES_12;
    public static final Image SPADES_KING =  SPADES_13;

    public static final Image BACKSIDE =  cards[cards.length - 1];
}
