package co.usa.ciclo4.reto2.repository.crud;

import co.usa.ciclo4.reto2.model.Cookware;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CookwareCrudRepository extends MongoRepository<Cookware, String> {
}
