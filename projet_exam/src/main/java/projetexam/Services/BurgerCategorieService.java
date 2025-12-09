package projetexam.Services;
import projetexam.Entities.BurgerCategorie;


import java.util.List;
import java.util.Optional;

public interface BurgerCategorieService {
    void createBurgerCategorie(BurgerCategorie burgerCategorie);

    Optional<BurgerCategorie> selectById(int id);

    List<BurgerCategorie> selectAll();

    int numberOfRows();
}
