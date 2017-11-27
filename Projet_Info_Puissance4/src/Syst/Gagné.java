
public class Gagné {
	
	int[][] grille;
	
	private boolean cherche4(int oCol, int oLigne, int dCol, int dLigne) {
	    
		int couleur = 0;
	    int compteur = 0;
	    int curCol = oCol;
	    int curLig = oLigne;

	    while ((curCol >= 0) && (curCol < 7) && (curLig >= 0) && (curLig < 6)) {
	      
	    	if (grille[curLig][curCol] != couleur) {
	        
	    	  couleur = grille[curLig][curCol];
	    	  compteur = 1;
	      
	    	} else {
	        
	    		compteur++;
	    		
	    	}

	    	if ((couleur != 0) && (compteur == 4)) {
	      
	    		return true;
	    	  
	    	}

	    	curCol += dCol;
	    	curLig += dLigne;
	      
	    }
	    
	    return false;
	    
	}
	
	public boolean cherche4() {
	    
	    //horizontales
		
		for (int ligne = 0 ; ligne < 6 ; ligne++) {
	      
	    	if (cherche4(0 , ligne , 1 , 0)) {
	        
	    		return true;
	    		
	    	}
	    }

	    //Verticales
		
		for (int col = 0 ; col < 7 ; col++) {
	      
	    	if (cherche4(col, 0, 0, 1)) {
	        
	    		return true;
	    	}
	    }

	    //Diagonales de direction : "en bas à gauche" / "en haut à droite"
		
    	for (int lig = 0 ; lig < 3 ; lig++) {
      
    		if (cherche4(0 , lig , 1 , 1)) {
        
    			return true;
    		}
    	}
    	
    	for (int col = 1 ; col < 4 ; col++) {
    		
	   		if (cherche4(col , 0 , 1 , 1)) {
	   		
	   			return true;
	   		}
	    }
    	
    	//Diagonales de direction : "en haut à gauche" / "en bas à droite"
		
    	for (int lig = 3 ; lig < 5 ; lig++) {
      
    		if (cherche4(0 , lig , -1 , 1)) {
        
    			return true;
    		}
    	}
    	
    	for (int col = 0 ; col < 4 ; col++) {
    		
	   		if (cherche4(col , 5 , -1 , 1)) {
	   		
	   			return true;
	   		}
	    }

	    return false;
	    
	  }	
}