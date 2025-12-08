package projetexam.Repository;
import projetexam.Entities.BurgerCategorie;

import java.util.List;
import java.util.Optional;

public interface BurgerCategorieRepository {
    Optional<BurgerCategorie> selectById(int id);

    List<BurgerCategorie> selectAll();

    int insert(BurgerCategorie burgerCategorie);

    int numberOfRows();
}