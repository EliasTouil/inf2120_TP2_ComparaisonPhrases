package inf2021_tp2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *Représente une liste de bigrammes.
 * @author Elias Touil 
 */
public class Sac <T extends Bigramme>  extends ArrayList{
    
    public Sac(Phrase entree , int distance ) {
        
        super();
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
        
        if (distance == -1 || distance > entree.size()) {
             distance = entree.size();
         }
        
        for (itBase = 0 ; itBase < entree.size() ; itBase++){
            
            for (itComplement = 1 ; itComplement <= distance ; itComplement++) {
                
                if ((itComplement+itBase) < entree.size()) {
                    
                    bigrammeCourant = new Bigramme((String) entree.get(itBase), 
                                                                                                (String) entree.get( itBase + itComplement ));
                    
                    this.add(bigrammeCourant);
                    
                } 
            }
        
        }
        
    }
    
    
    
    /**
     * Calcule l'indice de similarité entre deux sacs.
     * @param s2 le sac comparé
     * @return 
     */
    public double similarite(Sac s2){
        
        double cardinaliteIntersection = intersection(s2).size();
        double cardinaliteSac1 = this.size();
        double cardinaliteSac2 = s2.size();
        
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
    
    
    
    
    /**
     * Retourne l'intersection du sac avec un autre sac. 
     * @param s2 le sac avec lequel intersecter.
     * @return 
     */
    protected List<T> intersection(Sac s2) {
        List<T> intersection = new ArrayList<>();
        Iterator it = this.iterator();
        
        while (it.hasNext()){
        
            T bigCourant = (T) it.next();
            
             if ( s2.contains(bigCourant) ){
                
                intersection.add(bigCourant);
                s2.remove(bigCourant);
                
            }
        }
        
        return intersection;
    }
    
    
    
    
    /**
     * Vérifie que le bigramme passé en paramètre soit présent dans le sac. 
     * @param bigRecherche 
     * @return 
     */
    protected boolean contains(T bigRecherche){
        boolean v = false;
        Iterator it = this.iterator();
        
        while (it.hasNext()){
        
            Bigramme bigCourant = (T) it.next();
             v |= bigCourant.estEgal(bigRecherche);
             
        }
        
        return v;
    }
    
}
