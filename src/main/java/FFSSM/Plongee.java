/**
 * @(#) Plongee.java
 */
package FFSSM;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class Plongee {

    public Site lieu;

    public Moniteur chefDePalanquee;

    public Calendar date;

    public int profondeur;

    public int duree;
    
    private ArrayList<Plongeur> lesPlongeurs;

    public Plongee(Site lieu, Moniteur chefDePalanquee, Calendar date, int profondeur, int duree) {
        this.lieu = lieu;
        this.chefDePalanquee = chefDePalanquee;
        this.date = date;
        this.profondeur = profondeur;
        this.duree = duree;
        lesPlongeurs= new ArrayList<>();
    }

    public void ajouteParticipant(Plongeur participant) {
        lesPlongeurs.add(participant);
         	    
    }

    public Calendar getDate() {
        return date;
    }
    
   

    public boolean estConforme() {
        boolean b=true;
         for (Plongeur p: lesPlongeurs){
             if (p.dernièreLicence().estValide(this.date)==false){
                 b=false;
             }}
             
         return b;
    }

}
