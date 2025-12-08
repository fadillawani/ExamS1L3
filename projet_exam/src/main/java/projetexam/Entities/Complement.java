package projetexam.Entities;
import projetexam.Entities.Enum.TypeComplement;


public class Complement {
    private long id;
    private String libelle;
    private double prix;
    private String imageUrl;
    private boolean isArchived;
    private TypeComplement typeComplement;

    public Complement(long id, String libelle, double prix, TypeComplement typeComplement) {
        this.id = id;
        this.libelle = libelle;
        this.prix = prix;
        this.typeComplement = typeComplement;
        this.isArchived = false;
    }
    
    public Complement() {
    }

    public long getId() { return id; }
    public void setId(int id ) { this.id = id; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public boolean getIsArchived() { return isArchived; }
    
    public void setIsArchived(boolean isArchived) { this.isArchived = isArchived; }
    public TypeComplement getTypeComplement() { return typeComplement; }
    public void setTypeComplement(TypeComplement typeComplement) { this.typeComplement = typeComplement; }
    public String getLibelle() { return libelle; }
    public void setLibelle(String libelle) { this.libelle = libelle; }
    public double getPrix() { return prix; }
    public void setPrix(double prix) { this.prix = prix; }

    @Override
    public String toString() { return libelle + " - " + prix + " FCFA"; }
}
