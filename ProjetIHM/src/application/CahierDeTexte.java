package application;

import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.*;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.Region;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.Accordion;
import javafx.scene.control.CheckBox;

public class CahierTexte extends Application{
	@Override
	public void start(Stage primaryStage) {
		
		// Barre de menu
		BorderPane root = new BorderPane();
		HBox hbox = new HBox();
		root.setTop(hbox);
		
		ImageView imLogo = new ImageView (new Image (getClass().getResourceAsStream("/Photo/Logo.png")));
		imLogo.setFitHeight(90);
		imLogo.setFitWidth(200);
		
		Region spacer = new Region(); // Region est un conteneur- vide qui peut occuper l'espace horizontal/vertical 
		hbox.setHgrow(spacer, Priority.ALWAYS); // setHgrow spécifit comment l'espace sur la ligne va être occupé.
		
		Button accueil = new Button("Accueil");		
		hbox.setMargin(accueil, new Insets(20, 0, 0, 0));
		accueil.setPrefSize(130, 50);
		
		MenuButton ressource = new MenuButton("Ressources élèves");
		hbox.setMargin(ressource, new Insets(20, 0, 0, 0));
		ressource.setPrefSize(130, 50);

		MenuButton outil = new MenuButton("Outils");
		hbox.setMargin(outil, new Insets(20, 0, 0, 0));
		outil.setPrefSize(130, 50);

		Button profil = new Button("Profil");
		hbox.setMargin(profil, new Insets(20, 0, 0, 0));
		profil.setPrefSize(130, 50);

		ImageView imContact = new ImageView (new Image (getClass().getResourceAsStream("/Photo/contact.png")));
		imContact.setFitWidth(20);
		imContact.setFitHeight(20);
		Button contact = new Button("Contact", imContact);
		hbox.setMargin(contact, new Insets(20, 0, 0, 0));
		contact.setPrefSize(130, 50);

		hbox.getChildren().addAll(imLogo,spacer, accueil, outil, ressource, profil, contact);
		
		//Page de textes
		VBox grandVBox = new VBox();
		root.setCenter(grandVBox);
		
		Label titre = new Label("CAHIER DE TEXTES");
		titre.setTextFill(Color.web("#2233AA"));
		titre.setFont(Font.font("Calibri", FontWeight.BOLD, 45));
		HBox conteneurTitre = new HBox ();
		conteneurTitre.getChildren().add(titre);
		conteneurTitre.setAlignment(Pos.CENTER);
		conteneurTitre.setMargin(titre, new Insets(60, 0, 0, 0));

		Label sous_titre = new Label ("6_E - MATHEMATIQUES - M.CRESPIN");
		sous_titre.setFont(Font.font("Calibri", FontWeight.BOLD, 25));
		sous_titre.setTextFill(Color.web("#44725d"));
		HBox conteneurSousTitre = new HBox();
		conteneurSousTitre.getChildren().add(sous_titre);
		conteneurSousTitre.setAlignment(Pos.CENTER);
		conteneurSousTitre.setMargin(sous_titre, new Insets(0, 0, 100, 0));
		
		VBox dateContent = new VBox();
		Accordion accordion = new Accordion(); // ajout de boutons déroulantes
		grandVBox.setMargin(accordion, new Insets(0, 100, 0, 100));

		TitledPane dateLabel1 = new TitledPane(); // TitledPane est un panneau avec un titre qui peut être ouvert ou fermé. TitledPance est une extension de Labeled.		
		
		ImageView etoile = new ImageView(new Image(getClass().getResourceAsStream("/Photo/etoile.png")));
		etoile.setFitHeight(50);
		etoile.setFitWidth(50);
		Label titleSeance = new Label ("Séance du vendredi 18 octobre 2024", etoile);
		titleSeance.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		titleSeance.setTextFill(Color.web("#2233AA"));
		
		Label probleme140 = new Label("Problème n° 140.");
		Hyperlink correctionProbleme140 = new Hyperlink("[Correction]");
		HBox seanceLine1 = new HBox ();
		seanceLine1.getChildren().addAll(probleme140, correctionProbleme140);
		
		Label exercice9 = new Label("Exercice n°9.");
		Hyperlink correctionExercice9 = new Hyperlink("[Correction]");
		HBox seanceLine2 = new HBox ();
		seanceLine2.getChildren().addAll(exercice9, correctionExercice9);
		
		Hyperlink consigneBelleFigure = new Hyperlink("Consignes pour la construction de belles figure de géométrie.");
		Hyperlink debutConstruction = new Hyperlink("Début d'une construction.");		
	
		dateContent.setMargin(seanceLine1, new Insets(0, 0, 0, 50));
		dateContent.setMargin(seanceLine2, new Insets(0, 0, 0, 50));
		dateContent.setMargin(consigneBelleFigure, new Insets(0, 0, 0, 50));
		dateContent.setMargin(debutConstruction, new Insets(0, 0, 0, 50));
		dateContent.getChildren().addAll(titleSeance, seanceLine1, seanceLine2, consigneBelleFigure, debutConstruction);
		
		ImageView fleche = new ImageView (new Image(getClass().getResourceAsStream("/Photo/fleche.png")));
		Label titreDevoir = new Label ("Devoirs", fleche);
		titreDevoir.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		titreDevoir.setTextFill(Color.web("#2233AA"));
		fleche.setFitHeight(50);
		fleche.setFitWidth(50);
		
		CheckBox devoirLine= new CheckBox("Rendre une construction de géométrie de son choix (ne pas oublier d'indiquer de quoi il s'agit.");
		dateContent.setMargin(devoirLine, new Insets(0, 0, 0, 50));
		
		dateContent.getChildren().addAll(titreDevoir, devoirLine);
		dateLabel1.setText("Lundi 4 novembre 2024");
		dateLabel1.setContent(dateContent);
		
		dateContent.setMargin(seanceLine1, new Insets(0, 0, 0, 50));
		dateContent.setMargin(seanceLine2, new Insets(0, 0, 0, 50));
		dateContent.setMargin(consigneBelleFigure, new Insets(0, 0, 0, 50));
		dateContent.setMargin(debutConstruction, new Insets(0, 0, 0, 50));
		
		
		TitledPane dateLabel2 = new TitledPane();
		dateLabel2.setText("Jeudi 17 octobre 2024");
		
		VBox dateContent2 = new VBox();
		dateLabel2.setContent(dateContent2);
		Label titleSeance2 = new Label ("Séance du jeudi 17 octobre 2024", etoile);
		titleSeance2.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		titleSeance2.setTextFill(Color.web("#2233AA"));
		
		Label presentationExpo = new Label("Présentation des exposés par les élèves.");
		Hyperlink evaluationCourte = new Hyperlink("Evaluation courte.");
		
		Label exercice87 = new Label ("Exercice n°87");
		Hyperlink correctionExercice87 = new Hyperlink("[Correction]");
		HBox seanceLine3 = new HBox();
		seanceLine3.getChildren().addAll(exercice87, correctionExercice87);
		
		Hyperlink enonceProbleme140 = new Hyperlink("[énoncé]");
		Label phrase = new Label (" Cherché par certains élèves. ");
		HBox seanceLine4 = new HBox ();
		seanceLine4.getChildren().addAll(probleme140, phrase, enonceProbleme140);		
		
		dateContent2.getChildren().addAll(titleSeance2, presentationExpo, evaluationCourte, seanceLine3, seanceLine4);
		
		Label titreDevoir2 = new Label ("Devoirs", fleche);
		CheckBox devoirLine2 = new CheckBox("Problème n°140. Recherche à poursuivre.");
		dateContent2.setMargin(devoirLine2, new Insets(0, 0, 0, 50));	
		
		dateContent2.setMargin(presentationExpo, new Insets(0, 0, 0, 50));
		dateContent2.setMargin(evaluationCourte, new Insets(0, 0, 0, 50));
		dateContent2.setMargin(seanceLine3, new Insets(0, 0, 0, 50));
		dateContent2.setMargin(seanceLine4, new Insets(0, 0, 0, 50));
		
		dateContent2.getChildren().addAll(titreDevoir2, devoirLine2);

		
		accordion.getPanes().addAll(dateLabel1, dateLabel2);
		
		grandVBox.getChildren().addAll(conteneurTitre, conteneurSousTitre, accordion);
		
		Scene scene = new Scene(root, 400, 500);
		primaryStage.setTitle("Cahier de Texte");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch (args);
	}
}
