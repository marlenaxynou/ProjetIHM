package application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


public class Connexion extends Application {
    
    public void start(Stage primaryStage) {
    	VBox root = new VBox(10);
    	root.setPadding(new Insets(20));
    	// inserer une image (celle sur canva ) 
    	Image imageConn = new Image(getClass().getResourceAsStream("/images/logoConnexion.png"));
    	ImageView image_connexion = new ImageView(imageConn);
    	image_connexion.setFitWidth(80);
    	image_connexion.setPreserveRatio(true);
    	
        Label titre = new Label("Se connecter");
        titre.setTextAlignment(TextAlignment.CENTER);
        Label sous_titre = new Label ("Connectez-vous pour accéder à vos cours, ressources.");
        sous_titre.setTextAlignment(TextAlignment.CENTER);
        Label email = new Label ("Email");
        TextField zonetext = new TextField();
        zonetext.setPromptText("exemple@exemple.com");
        
        Label mot_de_passe =   new Label ("Mot de passe");
        PasswordField mdp = new PasswordField();
        
        Button se_connecter = new Button("Se connecter");
        
        se_connecter.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        		String mailText = zonetext.getText();
        		String mdpText = mdp.getText();
        		// verifier que c non null
        		if(mailText.isEmpty() || mdpText.isEmpty()) {
        			Alert alerter = new Alert(Alert.AlertType.WARNING);
        			alerter.setTitle("Erreur");
        			alerter.showAndWait();
        		}
        		else {
        			Alert alerter = new Alert(Alert.AlertType.INFORMATION);
        			alerter.setTitle("Connexion à votre espace réussie");
        			alerter.showAndWait();
        		}
        	}
        });
        
        root.getChildren().addAll(image_connexion,titre,sous_titre,email,zonetext,mot_de_passe ,mdp,se_connecter);
        Scene scene = new Scene(root,400,500);
        primaryStage.setTitle("Connexion");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);  
    }
}
