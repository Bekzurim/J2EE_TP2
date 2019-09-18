/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketmachine;

/**
 *
 * @author aprevost
 */

public class Ticketmachine {
    
    int argentMachine;
    int prixTicket;
    int totalArgent;

    // Initialiser la machine
    public Ticketmachine(int ticketCost){
          argentMachine=0;
          prixTicket =ticketCost;
          totalArgent=0;
    }
    
    // Connaitre le prix du ticket
    public int getPrice(){
        if (prixTicket>=0)
        {
        return prixTicket;
        }
        return 0;
    }
    
    // Afficher le montant total collecté
    public int getTotal() {
        return totalArgent;
    }
    
    // Connaitre la balance en cours
    public int getBalance() {
        return argentMachine;
    }
    
    // Insérer de l'argent dans la machine
    public void insertMoney(int amount) {
        if(amount>=0)
        {
            argentMachine+=amount;
        }
    }
    
    // Rendre la monnaie
    public int refund() {
        int rendu=argentMachine;
        argentMachine=0;
        return rendu;
    }
    
    // Imprimer un ticket
    public boolean printTicket() {
        if(argentMachine>=prixTicket)
        {
            totalArgent+=prixTicket;
            argentMachine-=prixTicket;
            return true;
        }
        return false;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
