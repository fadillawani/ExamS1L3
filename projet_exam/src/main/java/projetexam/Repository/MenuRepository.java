package projetexam.Repository;
import projetexam.Entities.Menu;

import java.util.List;
import java.util.Optional;

public interface MenuRepository {
    Optional<Menu> selectById(int id);

    List<Menu> selectAll();

    int insert(Menu menu);

    int numberOfRows();
}