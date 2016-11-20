package inf2021_tp2;

import exceptions.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Integer.parseInt;

/**
 * Représente une entree contenant 2 phrases et une distance maximale. 
 * @author Elias Touil
 */
public class Saisie {
 
    public String phraseSaisie1;
    public String phraseSaisie2;
    public String distanceSaisie;
    public Phrase p1;
    public Phrase p2; 
    public int distance; 
    
    private static InputStreamReader isr = new InputStreamReader( System.in );
    private static BufferedReader br = new BufferedReader( isr );
    
    public Saisie(){
        
        phraseSaisie1 = saisirPhrase();
        phraseSaisie2 = saisirPhrase();
        distance = saisirDistance();
        
        p1 = new Phrase(phraseSaisie1);
        p2 = new Phrase(phraseSaisie2);
        
        
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
        String distanceSaisie = saisirPhrase();
        int distance = 0;
        
        try {
            
            distance = parseInt(distanceSaisie);
        
        } catch (Exception e) {
            
            System.err.println("La distance n'est pas un nombre");
            
        }
        
        if ( distance < -1 || distance == 0 ) {
             
            throw new DistanceInvalideException();
            
        }
         
         return distance;
    }
    
}
