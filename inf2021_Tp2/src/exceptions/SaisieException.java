package exceptions;

/**
 *
 * @author Elias Touil
 */
public class SaisieException extends RuntimeException {
    
    public SaisieException() {
    
         super();
         System.err.println("Erreur à la saisie");
         System.exit(0);
    
    }
    
}

