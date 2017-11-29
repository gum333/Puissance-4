package Graphique;

import Syst.Joueur;
import Syst.Systeme;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox; 

public class Fenetre extends Application implements EventHandler<MouseEvent>{
//Variables générales {
private BorderPane panel = new BorderPane();
// } End
//Méthode de lancement {
	public void start(Stage primaryStage) throws Exception {
	setcanvjeu();
	//setup();
	Scene scene = new Scene(panel);
	primaryStage.setTitle("Le titre de la fenêtre"); primaryStage.setScene(scene); 
	primaryStage.show();
	}
// } End
// Méthodes associées au jeu {
private GridPane pane = new GridPane(); // Element qui structura la grille
private Jeton[][] Grille = new Jeton[7][6];  // le premier pour les colones 
private Systeme sys;
private Joueur joueur = new Joueur(2);
private Circle c = new Circle();
private Button abandon,retour,NewPlay,Menu,Quit;
	private void setcanvjeu() {
		panel.getChildren().clear();
		this.setGrille();
		panel.setRight(setscRight());
		panel.setTop(setscTop());
		panel.setLeft(setscLeft());
		panel.setBottom(setscBot());
		panel.setStyle("-fx-background-color: BLUE;");
		panel.setCenter(pane);
	}
	private void setGrille() {	
		for(int i=0;i<7;i++) {
			for(int j=0;j<6;j++) {
				Grille[i][j] = new Jeton(0);
				Grille[i][j].setOnMousePressed(this);
			}
		}
		sys = new Systeme(Grille);
		pane.setStyle("-fx-background-color: BLUE;");
		pane.setHgap(5);
		pane.setAlignment(Pos.CENTER);
		this.printGrille();
	}
	private void touch(int i,int j,MouseEvent event) {
		if (Grille[i][j]==event.getSource()) {
			if(!(sys.joue(i)==-1)) {
			Grille[i][sys.joue(i)].setJoueur(joueur.getJoueur());
			sys.actuJetToInt(Grille);
			joueur.nextj();
			this.actutopsc();
			}}
	}
	private void printGrille() {
		for(int i=0;i<7;i++) {
			for(int j=0;j<6;j++) {
				pane.add(Grille[i][j],i,j);
			}
		}
	}
	private VBox setscRight() {
	VBox vbox = new VBox();
	vbox.setSpacing(0.00d);
	Insets ins = new Insets(10,40,15,15);
		abandon = new Button("Abandon");
		retour = new Button("Retour");
		abandon.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");retour.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
		abandon.setOnMousePressed(this);retour.setOnMousePressed(this);
		vbox.setMargin(abandon,ins);vbox.setMargin(retour,ins);
		vbox.getChildren().addAll(abandon,retour);
	return vbox;
	}
	private Group setscTop() {
		Text playe = new Text("Tour du Joueur");
		// playe.setFont(Font.font("Edwardian Script ITC",25.00d));
		playe.setStyle("-fx-font: normal bold 30px 'Edwardian Script ITC'");
		playe.setFill(Color.WHITE);
		c.setRadius(10.00d);
		c.setCenterX(160.00d);
		c.setCenterY(-5.00d);
		Group gr = new Group();
		gr.getChildren().addAll(playe,c);
		this.actutopsc();
		return gr;
	}
	private void actutopsc() {
		c.setFill(joueur.getColor());
	}
	private VBox setscLeft() {
		VBox vb = new VBox();
		Insets ins =new Insets(20,10,0,15);
		vb.setSpacing(10);
		Text score = new Text("Score");
		score.setFill(Color.ORANGE);score.setStyle("-fx-font: normal bold 20px 'serif' ");
		vb.setMargin(score,new Insets(40,10,0,15));
		vb.getChildren().add(score);
		switch(joueur.joueurmax) {
		case 5: Text t5 = new Text("Joueur 5");
				t5.setFill(Color.ORANGE);
				vb.setMargin(t5, ins);
				vb.getChildren().add(t5);
		case 4: Text t4 = new Text("Joueur 4");
				t4.setFill(Color.ORANGE);
				vb.setMargin(t4,ins);
				vb.getChildren().add(t4);
		case 3: Text t3 = new Text("Joueur 3");
				t3.setFill(Color.ORANGE);
				vb.setMargin(t3,ins);
				vb.getChildren().add(t3);
		case 2: Text t2 = new Text("Joueur 2");
				t2.setFill(Color.ORANGE);
				vb.setMargin(t2,ins);
				vb.getChildren().add(t2);
		case 1: Text t1 = new Text("Joueur 1");
				t1.setFill(Color.ORANGE);
				vb.setMargin(t1,ins);
				vb.getChildren().add(t1);
		}
		return vb;
	}
	private HBox setscBot() {
		HBox hb = new HBox();
		Text t = new Text("Edited by : Bertin, Briois, Bouhin, Desmet, Doussinet");
		t.setFill(Color.ORANGE);
		t.setFont(Font.font("Script ITC",16.00d));
		hb.setMargin(t, new Insets(2.5d,0,2.5d,0));
		hb.getChildren().add(t);
		return hb;
	}
	private VBox setscRightaband() {
		VBox vb = new VBox();
		Insets ins = new Insets(10,10,0,15);
		NewPlay = new Button("Nouvelle Partie");
		Menu = new Button("Menu Principal");
		Quit = new Button("Quitter");
		NewPlay.setOnMousePressed(this);Menu.setOnMousePressed(this);Quit.setOnMousePressed(this);
		vb.setMargin(NewPlay, ins);vb.setMargin(Menu, ins);vb.setMargin(Quit, ins);
		vb.getChildren().addAll(NewPlay,Menu,Quit);
		return vb;
	}
	private void gereurboutonjeu(MouseEvent event) {
		if(event.getSource()==abandon) {
			panel.getChildren().removeAll(panel.getRight());
			panel.setRight(setscRightaband());
		}
	}
	// } End
//Méthodes associées à l'IHM de démarrage {
private int ordi=0;
private Button New,Modes,Sound,Quitt;
	private void setContrOrdi(int level) {
	ordi=level;
	joueur.joueurmax=2;
}
	private void setup() {
		this.setleftsc();
	}
	private void setleftsc() {
		panel.getChildren().clear();
		VBox vb = new VBox();
		New = new Button("Nouvelle Partie");Modes=new Button("Modes de jeu");Sound=new Button("Son");Quitt=new Button("Quitter");
		Insets ins =new Insets(20,20,20,20);
		vb.setPadding(ins);vb.getChildren().addAll(New,Modes,Sound,Quitt);
		panel.setLeft(vb);
	}
// } End
// Méthode de détection des objets {
	public void handle(MouseEvent event) {
		if(event.getSource().getClass()==Jeton.class) {
		for(int i=0;i<Grille.length;i++) {
			for(int j=0;j<Grille[0].length;j++) {
				touch(i,j,event);
			}}}else if(event.getSource().getClass()==Button.class) {
				Gereurbouton(event);
			}
	}
	private void Gereurbouton(MouseEvent event) {
		if(event.getSource()==abandon||event.getSource()==retour||event.getSource()==NewPlay||event.getSource()==Menu||event.getSource()==Quit) {
			gereurboutonjeu(event);
		}else {}
	}
	// } End
//Main
	public static void main(String[] args) {
		launch(args);	
		}
}