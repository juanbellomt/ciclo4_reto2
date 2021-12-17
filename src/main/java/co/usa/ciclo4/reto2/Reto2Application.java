package co.usa.ciclo4.reto2;

import co.usa.ciclo4.reto2.repository.crud.UserCrudRepository;
import co.usa.ciclo4.reto2.repository.crud.CookwareCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class Reto2Application implements CommandLineRunner {

	@Autowired
	private CookwareCrudRepository cookwareCrudRepository;

	@Autowired
	private UserCrudRepository userCrudRepository;

	public static void main(String[] args) {
		SpringApplication.run(Reto2Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		cookwareCrudRepository.deleteAll();
		userCrudRepository.deleteAll();
	}


}