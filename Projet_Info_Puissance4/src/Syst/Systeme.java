package Syst;
import Graphique.Jeton;

public class Systeme {

public int[][] Grille = new int[7][6];

// La grille est en jeton donc je la passe en int	
public Systeme(Jeton[][] var) {
	actuJetToInt(var);
}
public Systeme() {
	Initialise();
}

public void actuJetToInt(Jeton[][] var) {
	for(int i=0;i<7;i++) {
		for(int j=0;j<6;j++) {
			Grille[i][j] = var[i][j].getJoueur();
		}
	}
}
//Donne la pos sur laquelle est tombé le jeton
public int joue(int ColJouée) {
	int res = -1;
		for(int i = 0 ; i<5 ; i++) {
			if((Grille[ColJouée][i] == 0) && !(Grille[ColJouée][i+1]==0)) {res = i;}}
		if(Grille[ColJouée][5]==0) {res=5;}
	return res;
	}
//Gros bordel non traité {
private boolean cherche4(int oCol, int oLigne, int dCol, int dLigne) {
	int couleur = 0;
    int compteur = 0;
    int curCol = oCol;
    int curLig = oLigne;
    while ((curCol >= 0) && (curCol < 7) && (curLig >= 0) && (curLig < 6)) {
    	if (Grille[curLig][curCol] != couleur) {
    	  couleur = Grille[curLig][curCol];
    	  compteur = 1;
      } else {compteur++;}
    	if ((couleur != 0) && (compteur == 4)) {return true;}
    	curCol += dCol;
    	curLig += dLigne;
      }
    return false;
}
public boolean cherche4() {
    //horizontales
	for (int ligne = 0 ; ligne < 6 ; ligne++) {
    	if (cherche4(0 , ligne , 1 , 0)) {return true;}}

    //Verticales
	for (int col = 0 ; col < 7 ; col++) {
    	if (cherche4(col, 0, 0, 1)) {return true;}}

    //Diagonales de direction : "en bas à gauche" / "en haut à droite"
	for (int lig = 0 ; lig < 3 ; lig++) {
		if (cherche4(0 , lig , 1 , 1)) {return true;}}
	
	for (int col = 1 ; col < 4 ; col++) {
   		if (cherche4(col , 0 , 1 , 1)) {return true;}}
	
	//Diagonales de direction : "en haut à gauche" / "en bas à droite"
	for (int lig = 3 ; lig < 5 ; lig++) {
		if (cherche4(0 , lig , -1 , 1)) {return true;}}
	for (int col = 0 ; col < 4 ; col++) {
   		if (cherche4(col , 5 , -1 , 1)) {return true;}}
    return false;
  }	
// } End
public void Initialise() {
	for(int i = 0 ; i < Grille.length ; i++) {
		for(int j = 0 ; j < Grille[0].length ; j++) {Grille[i][j] = 0 ;}}
	}
//Affiche dans la console
public void Affiche() {
	for(int[] ligne : Grille) {
		System.out.print(" |") ;
		for(int cellule : ligne) {
			if (cellule == 0) {System.out.print(" ");}
			else if (cellule == 1) {System.out.print("O");}
			else if (cellule == 2) {System.out.print("X");}
			System.out.print("|");
		}
		System.out.println();
	}
	System.out.print("=");
	for(int i = 1 ; i <= Grille[0].length ; i++) {System.out.print("=" + i);}
	System.out.println("==\n");
	}
}
