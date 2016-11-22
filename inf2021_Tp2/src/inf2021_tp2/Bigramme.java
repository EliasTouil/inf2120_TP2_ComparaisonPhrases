package inf2021_tp2;

/**
 *Représente une bigramme. Nous strucurons le bigramme ainsi : { base , complement }. 
 * @author Elias Touil
 */
class Bigramme {
    
    protected String base;
    protected String complement;
    
    Bigramme( String b , String c ) {
        
        base = b ;
        complement = c ;
        
    }
    
    public boolean estEgal(Bigramme bigramme2) {
        
        return base.equals(bigramme2.base) && complement.equals(bigramme2.complement);
        
    }
    
}
