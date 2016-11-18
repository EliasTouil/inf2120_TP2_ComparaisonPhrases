package inf2021_tp2;

import java.util.List;

/**
 *
 * @author Elias touil
 */
public class Inf2021_Tp2 {

    public static void main(String[] args) {
        Phrase maPhrase = new Phrase("Salut   je suis bill et j'aime les plantes mauves.");
        Phrase maPhrase2 = new Phrase("Salut je mange    des plantes mauves.");
        System.out.println(maPhrase.arrayMots);
        System.out.println(maPhrase2.arrayMots); 
        System.out.println();
        
        Sac monSac = new Sac( maPhrase,-1 );
        Sac monSac2 = new Sac( maPhrase2,-1);
        
        System.out.println(monSac.toString());
        System.out.println(monSac2.toString());
        System.out.println();
        
        
        List<Bigramme> intersection = monSac.intersection(monSac2);
        for (Bigramme bi : intersection){
            System.out.println(bi.base + " ... " + bi.complement);
        }
        
        System.out.println(monSac.similarite(monSac2));
    }
    
}
