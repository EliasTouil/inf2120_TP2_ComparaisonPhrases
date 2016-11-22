package inf2021_tp2;

import exceptions.*;
import java.util.ArrayList;

/**
 * Représente un ensemble de mots ordonnés. 
 * @author Elias Touil
 */
public class Phrase extends ArrayList {
    
    protected final String REGEX_LETTRES = "([a-zA-Z])";
        
    Phrase(String entree){
        
       super();
       peuplerPhrase(entree);
       validerPhrase();
       
    }
    
    
    /**
     * Ajoute tous les mots trouvés dans la phrase entrée en paramètre à la variable listeMots.
     * @param entree la phrase saisie au clavier.
     */
    public void peuplerPhrase(String entree){
        String motCourant = "" ;
        
        for ( int i = 0 ; i < entree.length() ; i++ ) {
        
            String lettre = entree.substring(i , i+1 ) ;
            
            if ( !lettre.matches(REGEX_LETTRES) ) {
                
                if (!motCourant.equals("")){
                    this.add(motCourant.toLowerCase());
                    motCourant = "" ;
                }
                
            } else if ( lettre.matches(REGEX_LETTRES) ) {
                
                motCourant += lettre;
                
                if (i == entree.length()-1) {
                    this.add(motCourant.toLowerCase());
                }
                
            } 
            
        }
    }
    
    /**
     * Valide la phrase. Une phrase valide doit contenir au moins 2 mots.
     * 
     */
    protected void validerPhrase(){
        if (this.size() < 2) {
            throw new PhraseInvalideException();
        }
    }
    
}
