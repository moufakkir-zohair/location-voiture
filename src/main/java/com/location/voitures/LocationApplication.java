package com.location.voitures;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.location.voitures.Dao.ICommentaireDao;
import com.location.voitures.Dao.ICompteDao;


@SpringBootApplication
public class LocationApplication implements CommandLineRunner {

	
	@Autowired
	private ICompteDao compteDaoImp;
	
	@Autowired
	private ICommentaireDao commentaireDaoImp;
	
	public static void main(String[] args) {
		SpringApplication.run(LocationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}

}
