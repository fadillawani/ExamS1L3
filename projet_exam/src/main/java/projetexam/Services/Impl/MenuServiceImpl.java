package projetexam.Services.Impl;
import projetexam.Entities.Menu;
import projetexam.Repository.MenuRepository;
import projetexam.Services.MenuService;

import java.util.List;
import java.util.Optional;

public class MenuServiceImpl implements MenuService {

    private MenuRepository menuRepository;

    public MenuServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public void createMenu(Menu menu) {
        menuRepository.insert(menu);
    }

    @Override
    public Optional<Menu> selectById(int id) {
        return menuRepository.selectById(id);
    }

    @Override
    public List<Menu> selectAll() {
        return menuRepository.selectAll();
    }

    @Override
    public int numberOfRows()
    {
        return menuRepository.numberOfRows();
    }

}