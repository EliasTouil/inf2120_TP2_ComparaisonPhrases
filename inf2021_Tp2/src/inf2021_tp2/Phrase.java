package inf2021_tp2;

import exceptions.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Représente une phrase. Une phrase est un ensemble de mots. Un mot est une suite de lettres. 
 * @author Elias Touil
 */
public class Phrase extends ArrayList {
    
    protected final String REGEX_LETTRES = "([a-zA-Z])";
    
    protected List<String> arrayMots = new ArrayList<>();
    
    Phrase(String entree){
        
       trouverMots(entree);
       validerPhrase();
       
    }
    
    
    /**
     * Ajoute tous les mots trouvés dans la phrase entrée en paramètre à la variable listeMots.
     */
    public void trouverMots(String entree){
        String motCourant = "" ;
        
        for ( int i = 0 ; i < entree.length() ; i++ ) {
        
            String lettre = entree.substring(i , i+1 ) ;
            
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
    
    /**
     * Valide la phrase. Une phrase valide doit contenir au moins 2 mots.
     */
    protected void validerPhrase(){
        if (arrayMots.size() < 2) {
            throw new PhraseInvalideException();
        }
    }
    
}
