package ntnu.idatt2001.cards;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    private Stage stage;

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        stage.setScene(new MainFrontend().getScene());
        stage.show();
    }



    public static void main(String... args) {
        launch();
    }
}
