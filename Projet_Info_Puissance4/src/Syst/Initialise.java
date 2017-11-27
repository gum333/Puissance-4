
public class Initialise {

	private final static int VIDE = 0 ;
	private final static int JAUNE = 1 ;
	private final static int ROUGE = 2 ;

	public static void Initialise(int[][] grille) {

		for(int i = 0 ; i < grille.length ; i++) {
			
			for(int j = 0 ; j < grille[0].length ; j++) {

				grille[i][j] = VIDE ;

			}

		}

	}

}