package projetexam.Entities;
import projetexam.Entities.Enum.StatutLivraison;

public class LivraisonAffectation {
    private long id;
    private Commande commande;
    private User livreur;
    private Zone zone;
    private StatutLivraison statut;

    public LivraisonAffectation(long id, Commande commande, User livreur, Zone zone) {
        this.id = id;
        this.commande = commande;
        this.livreur = livreur;
        this.zone = zone;
        this.statut = StatutLivraison.EN_ATTENTE;
    }

    public long getId() { return id; }
    public Commande getCommande() { return commande; }
    public User getLivreur() { return livreur; }
    public void setLivreur(User livreur) { this.livreur = livreur; }
    public Zone getZone() { return zone; }
    public void setZone(Zone zone) { this.zone = zone; }
    public StatutLivraison getStatut() { return statut; }
    public void setStatut(StatutLivraison statut) { this.statut = statut; }

    @Override
    public String toString() {
        return "Livraison #" + id + " - " + statut + " par " + (livreur != null ? livreur.getNom() : "non assigné");
    }
}
