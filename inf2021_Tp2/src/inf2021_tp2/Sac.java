package inf2021_tp2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Elias Touil 
 */
public class Sac  {
    
    List<Bigramme> ensemble = new ArrayList<>();
    
    public Sac(Phrase entree , int distance ) {
        trouverBigrammes( entree , distance );
    }
    
    /**
     * Trouve les bigrammes d'une Phrase selon la distance.
     * @param entree la Phrase.
     * @param distance  la distance max entre les mots d'un bigramme.
     */
    private void trouverBigrammes(Phrase entree , int distance){
        
        int itBase;
        int itComplement;
        Bigramme bigrammeCourant;
        
        if (distance == -1 || distance > entree.arrayMots.size()) {
             distance = entree.arrayMots.size();
         }
        
        for (itBase = 0 ; itBase < entree.arrayMots.size() ; itBase++){
            
            for (itComplement = 1 ; itComplement <= distance ; itComplement++) {
                
                if ((itComplement+itBase) < entree.arrayMots.size()) {
                    
                    bigrammeCourant = new Bigramme(entree.arrayMots.get(itBase) , 
                                                                                            entree.arrayMots.get( itBase + itComplement ));
                    
                    ensemble.add(bigrammeCourant);
                    
                } 
            }
        
        }
        
    }
    
    
    public double similarite(Sac s2){
        
        double cardinaliteIntersection = intersection(s2).size();
        double cardinaliteSac1 = this.ensemble.size();
        double cardinaliteSac2 = s2.ensemble.size();
        
        double u = cardinaliteIntersection / cardinaliteSac1 ;
        double v = cardinaliteIntersection / cardinaliteSac2 ;
        double indiceSimilarite = 0;
        
         if ( cardinaliteIntersection == 0 ) {
            
            indiceSimilarite = 0 ;
          
        } else {
        
            indiceSimilarite =  ( 2 * u * v )  /  ( u + v ) ;
        
        }
        
        return indiceSimilarite ;
    }
    
    protected List<Bigramme> intersection(Sac s2) {
        List<Bigramme> intersection = new ArrayList<>();
        
        for (Bigramme b1 : this.ensemble) {
            
            if ( s2.contains(b1) ){
                
                intersection.add(b1);
                s2.ensemble.remove(b1);
                
            }
            
        }
        
        return intersection;
    }
    
    protected boolean contains(Bigramme bigRecherche){
        boolean v = false;
        
        for (Bigramme bigCourant : this.ensemble ) {
            
            v |= bigCourant.estEgal(bigRecherche);
            
        }
        
        return v;
    }
    
}
