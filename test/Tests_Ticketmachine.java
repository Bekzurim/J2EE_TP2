/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ticketmachine.Ticketmachine;

/**
 *
 * @author aprevost
 */
public class Tests_Ticketmachine {
    private static final int prix = 50;
    private static final int prix2 = -50;

	private Ticketmachine machine;
        private Ticketmachine machine2;

	@Before
	public void setUp() {
		machine = new Ticketmachine(prix);
                machine2 = new Ticketmachine(prix2);
	}

	@Test
	// S1 : le prix affiché correspond à l’initialisation
	public void MachineBienInitialisee() {
		assertEquals("Initialisation incorrecte", prix, machine.getPrice());
	}

	@Test
	// S2 : la balance change quand on insère de l’argent
	public void ArgentDansBalance() {
		machine.insertMoney(10);
		machine.insertMoney(20);
		assertEquals("Mise à jour incorrecte", 10 + 20, machine.getBalance());             
	}
        
        @Test
	// S3 : on n’imprime pas le ticket si le montant inséré est insuffisant
        public void MontantInsuffisant() {
            machine.insertMoney(5);
            assertEquals("Pas assez d'argent",false,machine.printTicket());
        }
        
        //S4 : on imprime le ticket si le montant inséré est suffisant
        public void MontantSuffisant() {
            machine.insertMoney(55);
            assertEquals("Assez d'argent",true,machine.printTicket());
        }
        
        //S5 : Quand on imprime un ticket la balance est décrémentée du prix du ticket
        public void Drecrementation() {
            machine.insertMoney(55);
            assertEquals("La balance ne retourne pas à zéro",55-prix,machine.getBalance());
        }
        
        //S6 : le montant collecté est mis à jour quand on imprime un ticket (pas avant)
        public void MajTicket() {
            machine.insertMoney(55);
            assertEquals("Pas de maj pour le ticket",50,machine.getTotal());
        }
        
        //S7 : refund() rend correctement la monnaie
        public void Refund1(){
            machine.insertMoney(55);
            assertEquals("Ne rend pas correctement la monnaie",55,machine.refund());
        }
        
        //S8 : refund() remet la balance à zéro
        public void Refund2(){
            machine.insertMoney(55);
            assertEquals("La Balance n'est pas à zéro",0,machine.getBalance());
        }
        
        //S9 : on ne peut pas insérer un montant négatif
        public void Negatif(){
            machine.insertMoney(-300);
            assertEquals("Pas de monnaie en négatif",0,machine.getBalance());
        }
        
        //S10 : on ne peut pas créer de machine qui délivre des tickets dont le prix est négatif
        public void MachineNegatif(){
            machine2.insertMoney(-300);
            assertEquals("Pas de prix négatif",null,machine2.getPrice());
        }
}
