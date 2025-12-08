package projetexam.Repository;
import projetexam.Entities.MenuComplement;

import java.util.List;
import java.util.Optional;

public interface MenuComplementRepository {
    Optional<MenuComplement> selectById(int id);

    List<MenuComplement> selectAll();

    int insert(MenuComplement menuComplement);

    int numberOfRows();
}