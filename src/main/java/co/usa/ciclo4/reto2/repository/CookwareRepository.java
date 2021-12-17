package co.usa.ciclo4.reto2.repository;

import co.usa.ciclo4.reto2.model.Cookware;
import co.usa.ciclo4.reto2.repository.crud.CookwareCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class CookwareRepository {

    @Autowired
    private CookwareCrudRepository repository;

    public List<Cookware> getAll() {
        return repository.findAll();
    }

    public Optional<Cookware> getCookware(String reference) {
        return repository.findById(reference);
    }

    public Cookware create(Cookware cookware) {
        return repository.save(cookware);
    }

    public void update(Cookware cookware) {
        repository.save(cookware);
    }

    public void delete(Cookware cookware) {
        repository.delete(cookware);
    }

}
