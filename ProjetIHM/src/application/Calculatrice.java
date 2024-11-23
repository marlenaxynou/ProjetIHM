package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Calculatrice extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Calculatrice");

        HBox topBar = new HBox(10);
        topBar.setPadding(new Insets(10));
        topBar.setAlignment(Pos.CENTER_LEFT);

        ImageView imLogo = new ImageView(new Image(getClass().getResourceAsStream("/Photo/Logo.png")));
        imLogo.setFitHeight(90);
        imLogo.setFitWidth(200);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Button accueil = new Button("Accueil");
        accueil.setPrefSize(130, 50);

        MenuButton ressource = new MenuButton("Ressources élèves");
        ressource.setPrefSize(130, 50);

        MenuButton outil = new MenuButton("Outils");
        outil.setPrefSize(130, 50);

        Button profil = new Button("Profil");
        profil.setPrefSize(130, 50);

        ImageView imContact = new ImageView(new Image(getClass().getResourceAsStream("/Photo/contact.png")));
        imContact.setFitWidth(20);
        imContact.setFitHeight(20);
        Button contact = new Button("Contact", imContact);
        contact.setPrefSize(130, 50);

        topBar.getChildren().addAll(imLogo, spacer, accueil, outil, ressource, profil, contact);

        Label displayLabel = new Label("0");
        displayLabel.setFont(new Font("Arial", 30));
        displayLabel.setMinWidth(220);
        displayLabel.setAlignment(Pos.CENTER_RIGHT);
        displayLabel.setPadding(new Insets(10));
        displayLabel.setStyle("-fx-border-color: blue; -fx-border-width: 2px;");

        VBox calculatorLayout = new VBox(10);
        calculatorLayout.setAlignment(Pos.CENTER); 
        calculatorLayout.setPadding(new Insets(10, 10, 10, 10));
        calculatorLayout.getChildren().add(displayLabel);

        String[][] buttonText = {
            {"C", "DEL", "%", "/"},
            {"7", "8", "9", "*"},
            {"4", "5", "6", "-"},
            {"1", "2", "3", "+"},
            {"0", "", ".", "="}
        };

        for (String[] row : buttonText) {
            HBox buttonRow = new HBox(10);
            buttonRow.setAlignment(Pos.CENTER);

            for (String text : row) {
                if (text.isEmpty()) continue;

                Button button = new Button(text);
                button.setFont(new Font("Arial", 20));
                button.setMinSize(50, 50);
                button.setStyle("-fx-border-color: blue; -fx-border-width: 2px;");

                if ("C".equals(text)) {
                    button.setStyle("-fx-background-color: yellow; -fx-border-color: blue; -fx-border-width: 2px;");
                } else if ("DEL".equals(text)) {
                    button.setStyle("-fx-background-color: lightcoral; -fx-border-color: blue; -fx-border-width: 2px;");
                }

                buttonRow.getChildren().add(button);
            }

            calculatorLayout.getChildren().add(buttonRow);
        }

        BorderPane rootLayout = new BorderPane();
        rootLayout.setTop(topBar); 
        rootLayout.setCenter(calculatorLayout); 

        Scene scene = new Scene(rootLayout, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
