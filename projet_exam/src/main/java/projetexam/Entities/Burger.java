package projetexam.Entities;


public class Burger {
    private long id;
    private String libelle;
    private String description;
    private double prix;
    private String imageUrl;
    private boolean isArchived;
    private BurgerCategorie categorie;

    public Burger() {
    }

    public Burger(long id, String libelle, String description, double prix, BurgerCategorie categorie) {
        this.id = id;
        this.libelle = libelle;
        this.description = description;
        this.prix = prix;
        this.categorie = categorie;
        this.isArchived = false;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getLibelle() { return libelle; }
    public void setLibelle(String libelle) { this.libelle = libelle; }
    public double getPrix() { return prix; }
    public void setPrix(double prix) { this.prix = prix; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public void setArchived(boolean archived) { isArchived = archived; }
    public boolean isArchived() { return isArchived; }
    public BurgerCategorie getCategorie() { return categorie; }
    public void setCategorie(BurgerCategorie categorie) { this.categorie = categorie; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    @Override
    public String toString() { return libelle + " - " + prix + " FCFA"; }
}
