package vue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Interface {
	
	// Methode permettant d'effectuer la lecture au clavier de chaine de caracteres
	public static String lecture ()
	{
		String str = "";
		
		try {
			BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		    str = bufferRead.readLine(); 
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		return str;
	}
	
	// Methode permettant de valider si une chaine de caractere est de valeur entiere et si ce nombre se trouve entre deux bornes
	public static boolean validerEntier(String valeur, int plageDebut, int plageFin)
	{
		int choixUtilisateur;
		
		try { 
			// Validation si la chaine de caractere est de valeur entiere
			choixUtilisateur = Integer.parseInt(valeur); 
	    } 
		catch(NumberFormatException e) { 
	        return false; 
	    }
		
		// Si la chaine de caractere est de valeur entiere, validation si ce nombre se trouve entre deux bornes
		if((choixUtilisateur >= plageDebut) && (choixUtilisateur <= plageFin))
			return true;

		return false;
	}
	
}
