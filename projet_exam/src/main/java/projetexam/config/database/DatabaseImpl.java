package projetexam.config.database;

import java.sql.*;
import java.util.*;

public class DatabaseImpl implements Database {

    private static DatabaseImpl instance;

    private String driver;
    private String url;
    private String user;
    private String password;

    private DatabaseImpl(String driver, String url, String user, String pwd) {
        this.driver = driver;
        this.url = url;
        this.user = user;
        this.password = pwd;
    }

    private DatabaseImpl(Map<String, String> config) {
        this(
            config.get("driver"),
            config.get("url"),
            config.get("user"),
            config.get("password")
        );
    }

    public static DatabaseImpl getInstance(Map<String, String> config) {
        if (instance == null)
            instance = new DatabaseImpl(config);
        return instance;
    }

    public static DatabaseImpl getInstance(
            String driver, String url, String user, String pwd) {

        if (instance == null)
            instance = new DatabaseImpl(driver, url, user, pwd);
        return instance;
    }

    @Override
    public Connection getConnection() {
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(
                "Erreur de connexion à la base", e
            );
        }
    }

    @Override
    public boolean isConnected() {
        try (Connection cnx = getConnection()) {
            return cnx != null && !cnx.isClosed();
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public void closeConnection() {
        // Plus utile dans cette version
    }

    @Override
    public <T> Optional<T> fetch(
            PreparedStatement ps,
            Convert<T> convert
    ) throws SQLException {

        try (
            ResultSet rs = ps.executeQuery()
        ) {
            if (rs.next()) {
                return Optional.of(
                    convert.toEntity(rs)
                );
            }
            return Optional.empty();
        }
    }

    @Override
    public <T> List<T> fetchAll(
            PreparedStatement ps,
            Convert<T> convert
    ) throws SQLException {

        List<T> datas = new ArrayList<>();
        try (
            ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                datas.add(convert.toEntity(rs));
            }
        }
        return datas;
    }
}
