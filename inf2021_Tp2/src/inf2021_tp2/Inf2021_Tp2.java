package inf2021_tp2;
import java.util.List;

/**
 *Ce programme compare deux phrases en calculant la métrique de similarité. 
 * Cette classe structure l'ordre des méthodes dans le programme.
 * @author Elias Touil TOUE06049208 
 */
public class Inf2021_Tp2 {

    public static void main(String[] args) {
        
        Saisie saisie = new Saisie();
       
        Sac sac1 = new Sac( saisie.phrase1 , saisie.distance );
        Sac sac2 = new Sac( saisie.phrase2 , saisie.distance);
        
        List<Bigramme> intersection = sac1.intersection(sac2);
        
        System.out.println(sac1.similarite(sac2));

    }
    
}
