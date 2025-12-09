package projetexam.config.factory.service;

import projetexam.Repository.*;
import projetexam.Services.Impl.*;
import projetexam.config.factory.repository.EntityName;
import projetexam.config.factory.repository.RepositoryFactory;

public final class ServiceFactory {

    public static Object getInstance(EntityName entityName) {
        switch (entityName) {
            case Burger:
                return new BurgerServiceImpl((BurgerRepository) RepositoryFactory.getInstance(EntityName.Burger));
            case BurgerCategorie:
                return new BurgerCategorieServiceImpl((BurgerCategorieRepository) RepositoryFactory.getInstance(EntityName.BurgerCategorie));
            case Complement:
                return new ComplementServiceImpl((ComplementRepository) RepositoryFactory.getInstance(EntityName.Complement));
            case Menu:
                return new MenuServiceImpl((MenuRepository) RepositoryFactory.getInstance(EntityName.Menu));
            case MenuBurger:
                return new MenuBurgerServiceImpl((MenuBurgerRepository) RepositoryFactory.getInstance(EntityName.MenuBurger));
            case MenuComplement:
                return new MenuComplementServiceImpl((MenuComplementRepository) RepositoryFactory.getInstance(EntityName.MenuComplement));
            default:
                return null;
        }
    }

}
