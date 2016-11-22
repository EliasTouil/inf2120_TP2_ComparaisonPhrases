package exceptions;

/**
 *Exception lancée lorsqu'il y a 0 ou 1 mot dans une phrase. 
 * @author Elias Touil
 */
public class PhraseInvalideException extends RuntimeException {
    
    public PhraseInvalideException(){
    
        super();
        System.err.println( "Un bigramme n'a pu être créé car il n'y a pas assez de mots dans une phrase" );
        System.exit(0);
        
    }
    
}
