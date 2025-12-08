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

    public long getId() { return id; }
    public String getImageUrl() { return imageUrl; }
    public boolean isArchived() { return isArchived; }
    public TypeComplement getTypeComplement() { return typeComplement; }
    public String getLibelle() { return libelle; }
    public double getPrix() { return prix; }

    @Override
    public String toString() { return libelle + " - " + prix + " FCFA"; }
}
