package projetexam.Services;
import projetexam.Entities.Menu;

import java.util.List;
import java.util.Optional;

public interface MenuService {
    void createMenu(Menu menu);

    Optional<Menu> selectById(int id);

    List<Menu> selectAll();

    int numberOfRows();
}
