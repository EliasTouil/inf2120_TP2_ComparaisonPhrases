package inf2021_tp2;

/**
 *
 * @author Elias touil
 */
public class Inf2021_Tp2 {

    public static void main(String[] args) {
        Phrase maPhrase = new Phrase("Salut je suis bill et j'aime les plante mauves.");
        System.out.println(maPhrase.arrayMots);
        
        Sac monSac = new Sac(maPhrase,1);
        System.out.println(monSac.toString());
    }
    
}
