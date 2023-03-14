module ntnu.idatt2001.cards {
    requires javafx.controls;
    requires java.desktop;
    requires javafx.swing;

    opens ntnu.idatt2001.cards to javafx.controls;
    exports ntnu.idatt2001.cards;
}