/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import FFSSM.Club;
import FFSSM.Embauche;
import FFSSM.Licence;
import FFSSM.Moniteur;
import FFSSM.Plongee;
import FFSSM.Plongeur;
import FFSSM.Site;
import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author cbason
 */
public class TestPlongee {
    
    Moniteur m1;
    Club c1;
    Licence l1;
    Plongeur p1;
    Embauche embauche;
    
    
    @Before
    public void setUp() {
        Calendar dnd= Calendar.getInstance();
         dnd.set(1998, 11 , 7);
         Calendar delivrance= Calendar.getInstance();
         delivrance.set(2018, 11 , 20);
         Calendar delivrance2= Calendar.getInstance();
         delivrance2.set(2018, 11 , 7);
        
        Moniteur m1=new Moniteur("879j", "Dupond", "Auriane", "chemin perdu", "0659895623", dnd, 0002);
        Club c1= new Club(m1, "LaMer", "0689563214");
        Club c2= new Club(m1, "Locean", "0589563214");
        Plongeur p1= new Plongeur("8956", "Rouverand", "Coralie", "chemin de la mer", "0689561234", dnd, 0); 
        Licence l1= new Licence(p1, "5687", delivrance, 0, c1);
        Embauche embauche = new Embauche(delivrance,m1,c1);
        Embauche e2 = new Embauche(delivrance2,m1,c2);
    } 
    
    
    @Test
    public void TestLicenceConforme(){
        Calendar delivrance= Calendar.getInstance();
         delivrance.set(2018, 11 , 20);
        Licence l1= new Licence(p1, "5687", delivrance, 0, c1);
        Calendar d= Calendar.getInstance();
        d.set(2018, 11 , 21);
        assertTrue(l1.estValide(d));
        Calendar d2= Calendar.getInstance();
        d2.set(2019, 11 , 21);
        assertFalse(l1.estValide(d2));
    }
    
    @Test
    public void TestEmbauche(){
        Calendar delivrance= Calendar.getInstance();
         delivrance.set(2018, 11 , 20);
        Embauche embauche = new Embauche(delivrance,m1,c1);
        Calendar d= Calendar.getInstance();
        d.set(2019, 11 , 9);
        embauche.terminer(d);
        assertTrue(embauche.estTerminee());
    }
     @Test
    public void TestPlongeur(){
        Calendar delivrance= Calendar.getInstance();
        delivrance.set(2018, 11 , 20);
        Licence l1= new Licence(p1, "5687", delivrance, 0, c1);
        Calendar dnd= Calendar.getInstance();
        dnd.set(1998, 11 , 7);
        Plongeur p1= new Plongeur("8956", "Rouverand", "Coralie", "chemin de la mer", "0689561234", dnd, 0); 
        p1.ajouterLicence(l1);
        assertEquals(l1, p1.dernièreLicence());
        
    }
    
    @Test
    public void PlongeeConforme(){
        Site rocher=new Site("rocher", "rochers et poissons");
        Calendar dnd= Calendar.getInstance();
        dnd.set(1998, 11 , 7);
        Calendar d= Calendar.getInstance();
        d.set(2018, 11 , 21);
        Moniteur m1=new Moniteur("879j", "Dupond", "Auriane", "chemin perdu", "0659895623", dnd, 0002);
        Calendar delivrance= Calendar.getInstance();
        delivrance.set(2018, 11 , 20);
        Plongee pl= new Plongee(rocher, m1, delivrance, 75, 2);
        Plongeur p1= new Plongeur("8956", "Rouverand", "Coralie", "chemin de la mer", "0689561234", dnd, 0); 
        pl.ajouteParticipant(p1);
        Club c1= new Club(m1, "LaMer", "0689563214");
        Licence l1= new Licence(p1, "5687", delivrance, 0, c1);
        p1.ajouterLicence(l1);
        assertTrue(pl.estConforme());
        
    }
    
       
    }
    
    
    
     
    
    

