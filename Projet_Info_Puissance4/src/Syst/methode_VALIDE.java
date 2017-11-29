
public class methode_VALIDE {
	
public static boolean VALIDE(char[][] grille, int c){
	boolean verif = false;
	for(int i=0; i<grille[c].length; i++) {
			if(grille[c][i]=='_') {
				verif=true;
			}
		}
	return verif;
	}
}
