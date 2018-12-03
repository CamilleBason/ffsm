package FFSSM;

import java.util.ArrayList;
import java.util.Calendar;

public class Plongeur extends Personne{
    private int niveau;
    private final ArrayList<Licence> lesLicences;
	
    public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, Calendar naissance, int niv) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        niv=niveau;
        lesLicences =new ArrayList<>();
    }
    
    public void ajouterLicence(Licence l){
        lesLicences.add(l);  
    }
    
    public Licence dernièreLicence(){
        return lesLicences.get(lesLicences.size()-1);
    }
 
}
