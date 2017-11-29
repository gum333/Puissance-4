
public class methode_PLEIN {

public static boolean PLEIN(char[][] grille) {
	boolean plein=true;
	for(int i=0;i<grille.length;i++) {
		for(int j=0;j<grille[0].length;j++) {
			if(grille[i][j]=='_') {
				plein=false;
			}
		
		}
		}
	return plein;
}
}