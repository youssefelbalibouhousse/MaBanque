package org.sid;

import java.util.Date;

import org.sid.dao.ClientRpository;
import org.sid.dao.CompteRepository;
import org.sid.dao.OperationRepository;
import org.sid.entities.Client;
import org.sid.entities.Compte;
import org.sid.entities.CompteCourant;
import org.sid.entities.CompteEpargne;
import org.sid.entities.Retrait;
import org.sid.entities.Versement;
import org.sid.metier.IBanqueMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MaBanqueApplication implements CommandLineRunner{
	 @Autowired
	 private ClientRpository clientRpository;
	 @Autowired
	 private CompteRepository compteRepository;
	 @Autowired
	 private OperationRepository operationRepository;
	 @Autowired
	 private IBanqueMetier banqueMetier;
	public static void main(String[] args) {
		SpringApplication.run(MaBanqueApplication.class, args);
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		Client c1 = clientRpository.save(new Client("Youssef","uneadressemail@gmail.com"));
		Client c2 = clientRpository.save(new Client("Elyasse","uneautreadressemail@gmail.com"));
		
		Compte cp1 = compteRepository.save(new CompteCourant("c1",new Date(), 9000, c1, 6000));
		Compte cp2 = compteRepository.save(new CompteEpargne("c2",new Date(), 99000, c2, 5.5));
		
		operationRepository.save(new Versement(new Date(),1111, cp1));
		operationRepository.save(new Versement(new Date(),1111, cp1));
		operationRepository.save(new Retrait(new Date(),5555, cp1));
		
		operationRepository.save(new Versement(new Date(),1111, cp2));
		operationRepository.save(new Versement(new Date(),1111, cp2));
		operationRepository.save(new Retrait(new Date(),5555, cp2));
		
		banqueMetier.verser("c1", 1234567890);
		
		
	}
	

}
