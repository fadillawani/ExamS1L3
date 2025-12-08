package projetexam.Entities;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private long id;
    private String libelle;
    private String imageUrl;
    private boolean isArchived;
    private double prix;
    private List<Burger> burgers = new ArrayList<>();
    private List<Complement> complements = new ArrayList<>();

    public Menu(long id, String libelle, double prix) {
        this.id = id;
        this.libelle = libelle;
        this.prix = prix;
        this.isArchived = false;
    }

    public long getId() { return id; }
    public String getLibelle() { return libelle; }
    public double getPrix() { return prix; }
    public List<Burger> getBurgers() { return burgers; }
    public String getImageUrl() { return imageUrl; }
    public boolean isArchived() { return isArchived; }
    public List<Complement> getComplements() { return complements; }

    public void addBurger(Burger b) { burgers.add(b); }
    public void addComplement(Complement c) { complements.add(c); }

    @Override
    public String toString() { return libelle + " - " + prix + " FCFA"; }
}

