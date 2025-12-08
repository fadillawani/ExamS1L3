package projetexam.Repository.Impl;
import projetexam.Entities.Complement;
import projetexam.Entities.Enum.TypeComplement;
import projetexam.Repository.ComplementRepository;
import projetexam.config.database.Database;

import java.sql.*;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ComplementRepositoryImpl implements ComplementRepository {
    private Database database;

    public ComplementRepositoryImpl(Database database) {
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
            PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) FROM complements");
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
    public int insert(Complement c) {
        try {
            if (!database.isConnected()) {
                throw new SQLException("Erreur de connexion à la BD");
            }
            Connection conn = database.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO complements (id, libelle, prix, image_url, is_archived, type_complement) " +
                            "VALUES (?, ?, ?, ?, ?, ?::type_complement)"
            );

            ps.setLong(1, c.getId());
            ps.setString(2, c.getLibelle());
            ps.setDouble(3, c.getPrix());
            ps.setString(4, c.getImageUrl());
            ps.setBoolean(5, c.getIsArchived());
            ps.setString(6, c.getTypeComplement().name());

            return ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public Optional<Complement> selectById(int id) {
        Connection conn = database.getConnection();
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("select * from complements where id = ?");
            ps.setInt(1, id);
            return database.<Complement>fetch(ps, this::toEntity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<Complement> selectByLibelle(String libelle) {
        Connection conn = database.getConnection();
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("select * from complements where libelle like ?");
            ps.setString(1, libelle);
            return database.<Complement>fetch(ps, this::toEntity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Complement> selectAll() {
        try {
            Connection conn = database.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from complements");
            return database.<Complement>fetchAll(ps, this::toEntity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    private Complement toEntity(ResultSet rs) throws SQLException {
        Complement c = new Complement();
        c.setId(rs.getInt("id"));
        c.setLibelle(rs.getString("libelle"));
        c.setPrix(rs.getDouble("prix"));
        c.setImageUrl(rs.getString("image_url"));
        c.setIsArchived(rs.getBoolean("is_archived"));
        c.setTypeComplement(TypeComplement.valueOf(rs.getString("type_complement")));
        return c;
    }

}