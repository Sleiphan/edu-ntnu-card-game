package ntnu.idatt2001.cards;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

public class MainFrontend {

    public static Scene getInitialScene() {
        Group root = new Group();
        return new Scene(root, 640, 480, Color.BLACK);
    }
}
