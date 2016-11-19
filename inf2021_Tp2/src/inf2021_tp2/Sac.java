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
    
    /**
     * Retourne vrai si ce sac est identique au sac comparé.
     * @param s2 le sac auquel on compare
     * @return 
     */
    public boolean estIdentique(Sac s2){
        
        boolean v = true ;
        
        for (int i=0 ; i<this.ensemble.size() ; i++){
            v &= this.ensemble.get(i).estEgal(s2.ensemble.get(i));
        }
        
         return v;
    }
    
    public double similarite(Sac s2){
        
        double tailleIntersection = intersection(s2).size();
        double tailleSac1 = this.ensemble.size();
        double tailleSac2 = s2.ensemble.size();
        
        double u = tailleIntersection / tailleSac1 ;
        double v = tailleIntersection / tailleSac2 ;
        double indiceSimilarite = ( 2 * u * v )  /  ( u + v );
        
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
    
    protected boolean supprimerPremiereOccurenceDe(Bigramme bigASupprimer) {
        boolean supprime = false ;
        
        
        
        return supprime;
    }
    
    protected boolean contains(Bigramme bigRecherche){
        boolean v = false;
        
        for (Bigramme bigCourant : this.ensemble ) {
            v |= bigCourant.estEgal(bigRecherche);
        }
        
        return v;
    }
    
    public String toString(){
        String ensembleAsString = "" ;
        
        for (Bigramme big : ensemble){
            ensembleAsString +=   "|   " + big.base + "  ...  " + big.complement + "   |" ;
        }
        
        return ensembleAsString;
    }
}
