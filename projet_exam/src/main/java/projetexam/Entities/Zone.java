package projetexam.Entities;

public class Zone {
    private long id;
    private String nom;
    private double prixLivraison;

    public Zone(long id, String nom, double prixLivraison) {
        this.id = id;
        this.nom = nom;
        this.prixLivraison = prixLivraison;
    }

    public long getId() { return id; }
    public String getNom() { return nom; }
    public double getPrixLivraison() { return prixLivraison; }

    @Override
    public String toString() { return nom + " - livraison: " + prixLivraison; }
}
