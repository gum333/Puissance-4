
public class Joue {
	
	public void joue(char[][] Grille , int ColJou�e , char Joueur) {
		
		for(int i = 0 ; i < 6 ; i++) {
			
			if(Grille[i][ColJou�e] == '_') {
				
				Grille[i][ColJou�e] = Joueur;

			}
			
		}
		
	}
	
}