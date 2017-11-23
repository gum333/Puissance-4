
public class Affiche {
	
	public static void Affiche(int[][] grille) {

		for(int[] ligne : grille) {
jhgngkjhngh
			System.out.print(" |") ;

			for(int cellule : ligne) {

				if (cellule == VIDE) {

					System.out.print(" ");

				} else if (cellule == ROUGE) {

					System.out.print("O");

				} else if (cellule == JAUNE) {

					System.out.print("X");

				}

				System.out.print("|");

			}

			System.out.println();

		}

		System.out.print("=");

		for(int i = 1 ; i <= grille[0].length ; i++) {

			System.out.print("=" + i);

		}

		System.out.println("==\n");

	}

}
