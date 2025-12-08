package projetexam.Repository.Impl;
import projetexam.Entities.Burger;
import projetexam.Repository.BurgerRepository;
import projetexam.config.database.Database;
import projetexam.Entities.BurgerCategorie;


import java.sql.*;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class BurgerRepositoryImpl implements BurgerRepository {
    private Database database;

    public BurgerRepositoryImpl(Database database) {
        this.database = database;
    }

    @Override
    public int numberOfRows() {
        int count = 0;
        try {
            if (!database.isConnected()) {
                throw new SQLException("Erreur de connexion à la BD");
            }
            Connection conn = database.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) FROM quartiers");
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }


    @Override
    public int insert(Burger burger) {
        try {
            if (!database.isConnected()) {
                throw new SQLException("Erreur de connexion à la BD");
            }
            Connection conn = database.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO burgers (id, libelle, description, prix, image_url, is_archived, burger_categorie_id) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?)"
            );

            ps.setInt(1, (int) burger.getId());
            ps.setString(2, burger.getLibelle());
            ps.setString(3, burger.getDescription());
            ps.setDouble(4, burger.getPrix());
            ps.setString(5, burger.getImageUrl());
            ps.setBoolean(6, burger.isArchived());
            ps.setInt(7, burger.getCategorie().getId());
            return ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }


    @Override
    public Optional<Burger> selectById(int id) {
        Connection conn = database.getConnection();
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("select * from quartiers where id = ?");
            ps.setInt(1, id);
            return database.<Burger>fetch(ps, this::toEntity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<Burger> selectByLibelle(String libelle) {
        Connection conn = database.getConnection();
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("select * from quartiers where libelle like ?");
            ps.setString(1, libelle);
            return database.<Burger>fetch(ps, this::toEntity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Burger> selectAll() {
        try {
            Connection conn = database.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from quartiers");
            return database.<Burger>fetchAll(ps, this::toEntity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    private Burger toEntity(ResultSet rs) throws SQLException {
        Burger burger = new Burger();
        burger.setId(rs.getInt("id"));
        burger.setLibelle(rs.getString("libelle"));
        burger.setDescription(rs.getString("description"));
        burger.setPrix(rs.getDouble("prix"));
        burger.setImageUrl(rs.getString("image_url"));
        burger.setArchived(rs.getBoolean("is_archived"));
        burger.setCategorie(new BurgerCategorie(rs.getInt("burger_categorie_id"), null));
        return burger;
    }

}