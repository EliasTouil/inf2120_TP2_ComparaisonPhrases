package exceptions;

/**
 *Exception lancée lorsque la valeur de la distance entrée n'est pas valide. 
 * @author Elias Touil
 */
public class DistanceInvalideException extends RuntimeException {
    
    public DistanceInvalideException(){
        
        super();
        System.err.println("pour la distance les valeurs acceptées sont [-1] U [1-INF[");
        System.exit(0);
        
    }
    
}
