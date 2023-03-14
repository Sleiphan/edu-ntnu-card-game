package ntnu.idatt2001.cards;

import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.util.List;
import java.util.Objects;

public class MainFrontend {
    private static final String BG_PATH = "Pool_background.jpg";

    private Button drawNew = new Button("Draw new cards");

    private Label sumOfFaces;
    private Label cardsOfHearts;
    private Label flush;
    private Label hasQueenOfSpades;

    private final Image background = new Image(Objects.requireNonNull(MainFrontend.class.getClassLoader().getResourceAsStream(BG_PATH)));

    private Scene scene;
    private final Group group = new Group();

    private DeckOfCards deck = new DeckOfCards();
    private TexasHand hand = new TexasHand(deck.dealHand(TexasHand.HAND_SIZE));
    private final ImageView[] cardImages = new ImageView[TexasHand.HAND_SIZE];



    public MainFrontend() {
        initScene();
    }

    private void initScene() {
        ImageView bg_view = new ImageView(background);
        bg_view.setX(0);
        bg_view.setY(0);
        bg_view.setFitWidth(800);
        bg_view.setFitHeight(600);
        group.getChildren().add(bg_view);

        newLabel("Sum of faces",        50, 500, Color.WHITE);
        newLabel("Cards of hearts",     50, 525, Color.WHITE);
        newLabel("Is a flush",          50, 550, Color.WHITE);
        newLabel("Has queen of spades", 50, 575, Color.WHITE);

        sumOfFaces       = newLabel("", 175, 500, Color.WHITE);
        cardsOfHearts    = newLabel("", 175, 525, Color.WHITE);
        flush            = newLabel("", 175, 550, Color.WHITE);
        hasQueenOfSpades = newLabel("", 175, 575, Color.WHITE);

        int cardsWidth = CardImages.CARD_SIZE_X / 4 + 10;
        int middle = 800 / 2 - cardsWidth / 2;
        for (int i = 0; i < cardImages.length; i++) {
            cardImages[i] = new ImageView();
            cardImages[i].setX(middle + (i - 2) * cardsWidth);
            cardImages[i].setY(250);
            cardImages[i].setFitWidth(CardImages.CARD_SIZE_X / 4);
            cardImages[i].setFitHeight(CardImages.CARD_SIZE_Y / 4);
            group.getChildren().add(cardImages[i]);
        }

        drawNew.setOnAction(e -> drawNewCards());
        group.getChildren().add(drawNew);
        drawNew.setTranslateX(600);
        drawNew.setTranslateY(500);

        scene = new Scene(group);
    }

    public void drawNewCards() {
        deck.returnHand(hand.getCards());
        deck.shuffle();
        hand = new TexasHand(deck.dealHand(TexasHand.HAND_SIZE));
        for (int i = 0; i < cardImages.length; i++)
            cardImages[i].setImage(CardImages.getImage(hand.getCards()[i]));

        sumOfFaces.setText("" + hand.getSum());
        cardsOfHearts.setText(hand.getAllHeartsString());
        flush.setText(hand.isFlush() ? "Yes" : "No");
        hasQueenOfSpades.setText(hand.containsQueenOfSpades() ? "Yes" : "No");
    }

    public Scene getScene() {
        return scene;
    }

    private Label newLabel(String label, int x, int y, Color textColor) {
        Label l = new Label(label);
        l.setTranslateX(x);
        l.setTranslateY(y);
        l.setTextFill(textColor);
        group.getChildren().add(l);
        return l;
    }
}
