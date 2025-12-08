package projetexam.Repository;
import projetexam.Entities.MenuBurger;

import java.util.List;
import java.util.Optional;

public interface MenuBurgerRepository {
    Optional<MenuBurger> selectById(int id);

    List<MenuBurger> selectAll();

    int insert(MenuBurger menuBurger);

    int numberOfRows();
}