package inf2021_tp2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Elias Touil
 */
public class Phrase {
    
    protected final String REGEX_LETTRES = "([a-zA-Z])";
    
    protected List<String> arrayMots = new ArrayList<>();
    
    Phrase(String entree){
        
       trouverMots(entree);
       
    }
    
    
    /**
     * Ajoute tous les mots trouvés dans la phrase entrée en paramètre à la variable listeMots.
     */
    public void trouverMots(String entree){
        String motCourant = "" ;
        
        for ( int i = 0 ; i < entree.length() ; i++ ) {
        
            String lettre = entree.substring(i , i+1 ) ;
            System.out.println(lettre);
            
            if ( !lettre.matches(REGEX_LETTRES) ) {
                
                if (!motCourant.equals("")){
                    arrayMots.add(motCourant.toLowerCase());
                    motCourant = "" ;
                }
                
            } else if ( lettre.matches(REGEX_LETTRES) ) {
                
                motCourant += lettre;
                
                if (i == entree.length()-1) {
                    arrayMots.add(motCourant.toLowerCase());
                }
                
            } 
            
        }
    }
    
}
