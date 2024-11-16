package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class Calculatrice extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Calculatrice");
		
		Label displayLabel = new Label("0");
		displayLabel.setFont(new Font("Arial", 30));
        displayLabel.setMinWidth(220);
        displayLabel.setAlignment(Pos.CENTER_RIGHT);
        displayLabel.setPadding(new Insets(10));
        displayLabel.setStyle("-fx-border-color: blue; -fx-border-width: 2px;");

        VBox mainLayout = new VBox(10);
        mainLayout.setAlignment(Pos.TOP_CENTER);
        mainLayout.setPadding(new Insets(10, 10, 10, 10));

        mainLayout.getChildren().add(displayLabel);
		
		String[][] buttonText = {
			{"C", "DEL", "%", "/"},
			{"7", "8", "9", "*"},
			{"4", "5","6", "-"},
			{"1","2", "3","+"},
			{"0","",".","="}};
	
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
            
            mainLayout.getChildren().add(buttonRow);
        }

        StackPane root = new StackPane();
        root.getChildren().add(mainLayout);

        Scene scene = new Scene(root, 300, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

