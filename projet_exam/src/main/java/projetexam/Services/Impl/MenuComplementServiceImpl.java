package projetexam.Services.Impl;
import projetexam.Entities.MenuComplement;
import projetexam.Repository.MenuComplementRepository;
import projetexam.Services.MenuComplementService;

import java.util.List;
import java.util.Optional;

public class MenuComplementServiceImpl implements MenuComplementService {

    private MenuComplementRepository menuComplementRepository;

    public MenuComplementServiceImpl(MenuComplementRepository menuComplementRepository) {
        this.menuComplementRepository = menuComplementRepository;
    }

    @Override
    public void createMenuComplement(MenuComplement menuComplement) {
        menuComplementRepository.insert(menuComplement);
    }

    @Override
    public Optional<MenuComplement> selectById(int id) {
        return menuComplementRepository.selectById(id);
    }

    @Override
    public List<MenuComplement> selectAll() {
        return menuComplementRepository.selectAll();
    }

    @Override
    public int numberOfRows()
    {
        return menuComplementRepository.numberOfRows();
    }

}
