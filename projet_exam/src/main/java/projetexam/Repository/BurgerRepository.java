package projetexam.Repository;
import java.util.List;
import java.util.Optional;

import projetexam.Entities.Burger;

public interface BurgerRepository {
    Optional<Burger> selectById(int id);

    List<Burger> selectAll();

    int insert(Burger burger);

    int numberOfRows();
}
