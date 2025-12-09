package projetexam.config.factory.repository;


import projetexam.Repository.Impl.*;
import projetexam.config.factory.database.DatabaseFactory;

public final class RepositoryFactory {
    private static final PersitanceName persitanceName = PersitanceName.Database;

    public static Object getInstance(EntityName entityName) {
        switch (persitanceName) {
            case List:
                return null;
            case Database:
                return getRepositoryDatabase(entityName);
            default:
                return null;
        }
    }

    public static Object getRepositoryDatabase(EntityName entityName) {
        switch (entityName) {
            case Burger:
                return new BurgerRepositoryImpl(DatabaseFactory.getInstance());
            case BurgerCategorie:
                return new BurgerCategorieRepositoryImpl(DatabaseFactory.getInstance());
            case Complement:
                return new ComplementRepositoryImpl(DatabaseFactory.getInstance());
            case Menu:
                return new MenuRepositoryImpl(DatabaseFactory.getInstance());
            case MenuBurger:
                return new MenuBurgerRepositoryImpl(DatabaseFactory.getInstance());
            case MenuComplement:
                return new MenuComplementRepositoryImpl(DatabaseFactory.getInstance());
            default:
                return null;
        }
    }
}
