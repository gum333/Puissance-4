package Syst;

import javafx.scene.paint.Color;

public class Joueur {
	private int joueur=1;
	private Color couleur;
	public int joueurmax;
	
	public Joueur() {
		setColor();
		joueurmax=2;
	}
	public Joueur(int Jmax) {
		setColor();
		joueurmax=Jmax;
	}
	public void nextj() {
		joueur++;
		if(joueur>joueurmax) {joueur=1;}
		setColor();
	}
	public int getJoueur() {
		return joueur;
	}
	public void setColor() {
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
	}
	public Color getColor() {
		return couleur;
	}
}
