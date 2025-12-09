package projetexam.Services.Impl;
import projetexam.Entities.Burger;
import projetexam.Repository.BurgerRepository;
import projetexam.Services.BurgerService;

import java.util.List;
import java.util.Optional;

public class BurgerServiceImpl implements BurgerService {

    private BurgerRepository burgerRepository;
    

    public BurgerServiceImpl(BurgerRepository burgerRepository) {
        this.burgerRepository = burgerRepository;
    }

    @Override
    public void createBurger(Burger burger) {
        burgerRepository.insert(burger);
    }

    @Override
    public Optional<Burger> selectById(int id) {
        return burgerRepository.selectById(id);
    }

    @Override
    public List<Burger> selectAll() {
        return burgerRepository.selectAll();
    }

    @Override
    public int numberOfRows()
    {
        return burgerRepository.numberOfRows();
    }

}
