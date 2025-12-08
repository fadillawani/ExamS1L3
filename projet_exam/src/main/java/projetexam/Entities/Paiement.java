package projetexam.Entities;
import projetexam.Entities.Enum.MoyenPaiement;

import java.time.LocalDateTime;

public class Paiement {
    private long id;
    private double montant;
    private String refTransaction;
    private LocalDateTime date;
    private MoyenPaiement moyenPaiement;
    private Commande commande;

    public Paiement(long id, double montant, MoyenPaiement moyenPaiement, Commande commande) {
        this.id = id;
        this.montant = montant;
        this.moyenPaiement = moyenPaiement;
        this.commande = commande;
        this.date = LocalDateTime.now();
    }
    public long getId() { return id; }
    public double getMontant() { return montant; }
    public String getRefTransaction() { return refTransaction; }
    public void setRefTransaction(String refTransaction) { this.refTransaction = refTransaction; }
    public LocalDateTime getDate() { return date; }
    public MoyenPaiement getMoyenPaiement() { return moyenPaiement; }
    public void setMoyenPaiement(MoyenPaiement moyenPaiement) { this.moyenPaiement = moyenPaiement; }
    public Commande getCommande() { return commande; }

    @Override
    public String toString() {
        return "Paiement #" + id + " - " + montant + " FCFA via " + moyenPaiement;
    }
}
