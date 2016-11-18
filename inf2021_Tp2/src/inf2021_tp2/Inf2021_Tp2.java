package inf2021_tp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 *
 * @author Elias touil
 */
public class Inf2021_Tp2 {

    public static void main(String[] args) {
        
        InputStreamReader isr = new InputStreamReader( System.in );
        BufferedReader br = new BufferedReader( isr );
        String phrase1 = null ;
        String phrase2 = null ;
        int distance = 0 ;
        
        
        try {
            phrase1 = br.readLine();
        } catch( IOException e ) {
            
        }
        
        
        try {
            phrase2 = br.readLine();
        } catch( IOException e ) {
            
        }
        
        try {
            String temp = br.readLine();
            distance = Integer.parseInt( temp );
        } catch( IOException e ) {
            
        }
        
        
        
        
        
        
        
        
        
        
        
        Phrase p1 = new Phrase(phrase1);
        Phrase p2 = new Phrase(phrase2);
        System.out.println(p1.arrayMots);
        System.out.println(p2.arrayMots); 
        System.out.println();
        
        Sac monSac = new Sac( p1,-1 );
        Sac monSac2 = new Sac( p2,-1);
        
        
        List<Bigramme> intersection = monSac.intersection(monSac2);
        for (Bigramme bi : intersection){
            System.out.println(bi.base + " ... " + bi.complement);
        }
        
        System.out.println(monSac.similarite(monSac2));
    }
    
}
