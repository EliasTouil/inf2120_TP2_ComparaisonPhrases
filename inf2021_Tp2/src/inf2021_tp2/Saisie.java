package inf2021_tp2;

import exceptions.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Integer.parseInt;

/**
 * Permet de saisir au clavier une entree et deux phrase.  
 * @author Elias Touil
 */
public class Saisie {
    
    protected Phrase phrase1;
    protected Phrase phrase2; 
    protected int distance; 
    
    private static InputStreamReader isr = new InputStreamReader( System.in );
    private static BufferedReader br = new BufferedReader( isr );
    
    public Saisie(){
        
        phrase1 = new Phrase( saisirPhrase() );
        phrase2 = new Phrase( saisirPhrase() );
        distance = saisirDistance();
        
    }
    
    /**
     * Saisie une phrase au clavier. 
     * @return 
     */
    protected String saisirPhrase() {
        String phrase;
        
        try {
            
            phrase = br.readLine();
            
        } catch( IOException e ) {
            
            throw new SaisieException();
            
        }
        
        return phrase;
    }
    
    /**
     * Saisie et valide une distance. 
     * @return 
     */
    protected int saisirDistance() {
        String distanceTemp = saisirPhrase();
        distance = 0;
        
        try {
            
            distance = parseInt(distanceTemp);
        
        } catch (Exception e) {
            
            System.err.println("La distance n'est pas un nombre");
            
        }
        
        if ( distance < -1 || distance == 0 ) {
             
            throw new DistanceInvalideException();
            
        }
         
         return distance;
    }
    
}
