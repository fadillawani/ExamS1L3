package projetexam.Entities;



public class CommandeItem {
    private long id;
    private Burger burger;
    private Menu menu;
    private Complement complement;
    private int quantite;
    private double prixTotal;

    public CommandeItem(long id, Burger burger, Menu menu, Complement complement, int quantite) {
        this.id = id;
        this.burger = burger;
        this.menu = menu;
        this.complement = complement;
        this.quantite = quantite;
        if (burger != null) prixTotal = burger.getPrix() * quantite;
        else if (menu != null) prixTotal = menu.getPrix() * quantite;
        else if (complement != null) prixTotal = complement.getPrix() * quantite;
    }
    
    public CommandeItem() {
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public Burger getBurger() { return burger; }
    public void setBurger(Burger burger) { this.burger = burger; }
    public Menu getMenu() { return menu; }
    public void setMenu(Menu menu) { this.menu = menu; }
    public Complement getComplement() { return complement; }
    public void setComplement(Complement complement) { this.complement = complement; }
    public double getPrixTotal() { return prixTotal; }
    public int getQuantite() { return quantite; }

    @Override
    public String toString() {
        if (burger != null) return burger.getLibelle() + " x" + quantite;
        if (menu != null) return menu.getLibelle() + " x" + quantite;
        return complement.getLibelle() + " x" + quantite;
    }
}
