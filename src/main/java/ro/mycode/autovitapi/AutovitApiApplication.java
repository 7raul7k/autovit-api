package ro.mycode.autovitapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.mycode.autovitapi.model.Masina;
import ro.mycode.autovitapi.repository.MasinaRepo;

@SpringBootApplication
public class AutovitApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutovitApiApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(MasinaRepo masinaRepo){
		return args -> {


			Masina masina = new Masina("Ionut","Audi",2009,"benzina");
			Masina masina1 = new Masina("Andrei","Bmw",2007,"motorina");
			Masina masina2 = new Masina("Liviu","Honda",2013,"benzina");
			Masina masina3 = new Masina("Filip","Dacia",2006,"benzina");
			masinaRepo.save(masina);
			masinaRepo.save(masina1);
			masinaRepo.save(masina2);
			masinaRepo.save(masina3);








		};

	}
}
