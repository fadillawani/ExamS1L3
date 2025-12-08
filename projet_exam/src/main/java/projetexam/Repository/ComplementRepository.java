package projetexam.Repository;
import projetexam.Entities.Complement;

import java.util.List;
import java.util.Optional;

public interface ComplementRepository {
    Optional<Complement> selectById(int id);

    List<Complement> selectAll();

    int insert(Complement complement);

    int numberOfRows();
}