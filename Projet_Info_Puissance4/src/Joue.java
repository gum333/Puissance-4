
public class Joue {
	
	public void joue(char[][] Grille , int ColJouée , char Joueur) {
		
		for(int i = 0 ; i < 6 ; i++) {
			
			if(Grille[i][ColJouée] == '_') {
				
				Grille[i][ColJouée] = Joueur;

			}
			
		}
		
	}
	
}