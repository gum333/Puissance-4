package Graphique;


import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Jeton extends Circle{
	private int joueur;
	private Color couleur;
//Constructeur de jeton
	public Jeton(int player) {
		super();
		this.setRadius(50.0d);
		joueur = player; //Permet à setColor de donner la bonne couleur
		setColor();
		this.setOnMouseEntered(new EventHandler<MouseEvent>(){
			public void handle(MouseEvent me) { //Crée une méthode qui va gérer l'entrer sourie
				if(joueur == 0) {
					Entrer(true);
				}
			}
		});
		this.setOnMouseExited(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) { //Crée une méthode qui va gérer la sortie sourie
				Entrer(false);
			}
		});
	}
//setJoueur oblige setColor à se relancer
	public void setJoueur(int player) {
		joueur = player;
		setColor();
	}
	public int getJoueur() {
		return joueur;
	}
//Associe une couleur en fonction du joueur
	protected void setColor() {
		switch(joueur) {
		case 0 : couleur = Color.LIGHTGRAY;
		break;
		case 1 : couleur = Color.YELLOW;
		break;
		case 2 : couleur = Color.RED;
		break;
		case 3 : couleur = Color.AQUA;
		break;
		case 4 : couleur = Color.CHOCOLATE;
		break;
		case 5 : couleur = Color.PURPLE;
		}
		this.setFill(couleur);
	}
//Gere l'entrer ou la sortie d'un element jeton
	private void Entrer(boolean var) {
		if(var) {
			this.setFill(Color.DARKGRAY);
		}else {
			this.setFill(couleur);
		}
	}
}
