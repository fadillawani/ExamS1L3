package projetexam.Entities;
import projetexam.Entities.Enum.StatutCommande;
import projetexam.Entities.Enum.TypeRetrait;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Commande {
    private long id;
    private User client;
    private String adresse;
    private Quartier quartier;
    private double montantHorsLivraison;
    private double montantTotal;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean isPaid;
    private StatutCommande statut;
    private TypeRetrait typeRetrait;
    private List<CommandeItem> items = new ArrayList<>();

    public Commande(long id, User client, String adresse, Quartier quartier, TypeRetrait typeRetrait) {
        this.id = id;
        this.client = client;
        this.adresse = adresse;
        this.quartier = quartier;
        this.typeRetrait = typeRetrait;
        this.montantHorsLivraison = 0;
        this.montantTotal = 0;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.isPaid = false;
        this.statut = StatutCommande.EN_ATTENTE;
    }
    public long getId() { return id; }
    public User getClient() { return client; }
    public String getAdresse() { return adresse; }
    public Quartier getQuartier() { return quartier; }
    public double getMontantHorsLivraison() { return montantHorsLivraison;
    }
    public double getMontantTotal() { return montantTotal; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    public boolean isPaid() { return isPaid; }
    public StatutCommande getStatut() { return statut; }
    public void setStatut(StatutCommande statut) { this.statut = statut; }
    public TypeRetrait getTypeRetrait() { return typeRetrait; }
    public void setTypeRetrait(TypeRetrait typeRetrait) { this.typeRetrait = typeRetrait; }

    public void addItem(CommandeItem item) {
        items.add(item);
        montantHorsLivraison += item.getPrixTotal();
        montantTotal = montantHorsLivraison + (quartier != null ? quartier.getZone().getPrixLivraison() : 0);
    }

    public List<CommandeItem> getItems() { return items; }

    @Override
    public String toString() {
        return "Commande #" + id + " - " + client.getNom() + " - Total: " + montantTotal;
    }
}
