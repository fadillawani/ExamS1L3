package projetexam.config.factory.database;

import projetexam.config.database.Database;
import projetexam.config.database.DatabaseImpl;

public final class DatabaseFactory {
    private static final SGDBName sgbdName = SGDBName.POSTGRESQL;

    private DatabaseFactory() {
    }

    public static Database getInstance() {
        return DatabaseImpl.getInstance(EntityManager.persistanceUnit(sgbdName));
    }
}
