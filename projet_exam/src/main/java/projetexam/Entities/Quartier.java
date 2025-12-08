package projetexam.Entities;


public class Quartier {
    private long id;
    private String nom;
    private Zone zone;

    public Quartier(long id, String nom, Zone zone) {
        this.id = id;
        this.nom = nom;
        this.zone = zone;
    }

    public long getId() { return id; }
    public String getNom() { return nom; }
    public Zone getZone() { return zone; }

    @Override
    public String toString() { return nom + " (" + zone.getNom() + ")"; }
}
