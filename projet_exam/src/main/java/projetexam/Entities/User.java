package projetexam.Entities;
import projetexam.Entities.Enum.RoleUser;

import java.time.LocalDateTime;

public class User {
    private long id;
    private String nom;
    private String prenom;
    private String tel;
    private String email;
    private String password;
    private LocalDateTime createdAt;
    private RoleUser role;
    private boolean isArchived;

    public User(long id, String nom, String prenom, String tel, String email, String password, RoleUser role) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.email = email;
        this.password = password;
        this.role = role;
        this.createdAt = LocalDateTime.now();
        this.isArchived = false;
    }

    public long getId() { return id; }
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public String getTel() { return tel; }
    public void setTel(String tel) { this.tel = tel; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public RoleUser getRole() { return role; }
    public boolean isArchived() { return isArchived; }
    public void setArchived(boolean archived) { isArchived = archived; }

    @Override
    public String toString() {
        return id + " - " + nom + " " + prenom + " (" + role + ")";
    }
}
