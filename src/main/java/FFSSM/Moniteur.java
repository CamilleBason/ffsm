/**
 * @(#) Moniteur.java
 */
package FFSSM;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Moniteur extends Personne {

    public int numeroDiplome;
    public ArrayList<Embauche>  lesEmbauches; 

    public Moniteur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, Calendar naissance, int numeroDiplome) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.numeroDiplome = numeroDiplome;
        lesEmbauches=new ArrayList<>();
    }

    public Club employeur() {
        return lesEmbauches.get(lesEmbauches.size()).getEmployeur();
            
        }
         
    
    
    public void nouvelleEmbauche(Club employeur, Calendar debutNouvelle) {   
         lesEmbauches.add(new Embauche(debutNouvelle,this, employeur));
    }

    public List<Embauche> emplois() {
         return lesEmbauches;
    }

}
