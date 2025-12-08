package projetexam.Entities;


public class Burger {
    private long id;
    private String libelle;
    private String description;
    private double prix;
    private String imageUrl;
    private boolean isArchived;
    private BurgerCategorie categorie;

    public Burger(long id, String libelle, String description, double prix, BurgerCategorie categorie) {
        this.id = id;
        this.libelle = libelle;
        this.description = description;
        this.prix = prix;
        this.categorie = categorie;
        this.isArchived = false;
    }

    public long getId() { return id; }
    public String getLibelle() { return libelle; }
    public double getPrix() { return prix; }
    public String getImageUrl() { return imageUrl; }
    public boolean isArchived() { return isArchived; }
    public BurgerCategorie getCategorie() { return categorie; }
    public String getDescription() { return description; }

    @Override
    public String toString() { return libelle + " - " + prix + " FCFA"; }
}
