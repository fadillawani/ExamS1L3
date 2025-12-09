package projetexam.Services;
import projetexam.Entities.Burger;

import java.util.List;
import java.util.Optional;

public interface BurgerService {
    void createBurger(Burger burger);

    Optional<Burger> selectById(int id);

    List<Burger> selectAll();

    int numberOfRows();
}
