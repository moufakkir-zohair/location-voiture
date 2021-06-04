package com.location.voitures;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.location.voitures.Dao.ICommentaireDao;
import com.location.voitures.Dao.ICompteDao;
import com.location.voitures.Dao.IEquipementDao;
import com.location.voitures.Dao.ILocationDao;
import com.location.voitures.Dao.IVoitureDao;
import com.location.voitures.Entity.Commentaire;
import com.location.voitures.Entity.Compte;
import com.location.voitures.Entity.CompteClient;
import com.location.voitures.Entity.Equipement;
import com.location.voitures.Entity.Location;
import com.location.voitures.Entity.Voiture;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import java.util.Arrays;

@SpringBootApplication
@EnableSwagger2
public class LocationApplication implements CommandLineRunner {

	
	@Autowired
	private ICompteDao compteDaoImp;
	
	
	@Autowired
	private ICommentaireDao commentaireDaoImp;
	
	
	@Autowired
	private IVoitureDao voitureDaoImp;
	
	
	@Autowired
	private ILocationDao locationDaoImp;
	
	
	@Autowired
	private IEquipementDao equipementDaoImp;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(LocationApplication.class, args);
	}
	
	
	@Bean
	public Docket SwaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.location.voitures.Controllers"))
				.build()
				.apiInfo(apiDetails());
	}
	
	
	private ApiInfo apiDetails() {
	    return new ApiInfoBuilder()
	            .title( "application de gestion de location de voiture" )
	            .description( "Toutes les demandes auxquelles le serveur répondra." )
	            .version( "1.0.0" )
	            .build();
	}
	
	
	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}
	

	@Override
	public void run(String... args) throws Exception {
		
		Voiture V = voitureDaoImp.AjouterVoiture(new Voiture("FIRARI", null, null, null, 0, null, 0, null, null, null, null, null));
		Voiture V1 = voitureDaoImp.AjouterVoiture(new Voiture("RANG REVER", null, null, null, 0, null, 0, null, null, null, null, null));
		Voiture V2 = voitureDaoImp.AjouterVoiture(new Voiture("DACIA", null, null, null, 0, null, 0, null, null, null, null, null));

	
		Compte C1 = compteDaoImp.AjouterCompte(new CompteClient(null, "MOUFAKKIR", null, null, null, null, null));
		Compte C2 = compteDaoImp.AjouterCompte(new CompteClient(null, "OUMOUDID", null, null, null, null, null));
		
	
		Date dt = new Date();
		Calendar c = Calendar.getInstance(); 
		c.setTime(dt); 
		c.add(Calendar.DATE, 2);
		dt = c.getTime();
		
		
		locationDaoImp.AjouterLocation(new Location(new Date(), dt, false, false, V, (CompteClient) C1));
		locationDaoImp.AjouterLocation(new Location(new Date(), dt, false, false, V1, (CompteClient) C2));

		
		
		
		
		Equipement Eq1 = equipementDaoImp.AjouterEquipement(new Equipement("XXXXX"));
		Equipement Eq2 = equipementDaoImp.AjouterEquipement(new Equipement("yyyyy"));
		Equipement Eq3 = equipementDaoImp.AjouterEquipement(new Equipement("ZZZZZ"));
		
		voitureDaoImp.AffecterEquipement(Eq1.getId_equipement(), V.getId_voiture());
		voitureDaoImp.AffecterEquipement(Eq2.getId_equipement(), V.getId_voiture());
		voitureDaoImp.AffecterEquipement(Eq3.getId_equipement(), V.getId_voiture());
//		voitureDaoImp.AffecterEquipement(Eq3.getId_equipement(), V1.getId_voiture());
			
		
		for(Equipement equi : voitureDaoImp.ListeEquipementVoiture(V.getId_voiture()) ) {
			System.out.println(equi.getNom());
		}
		
		
//		V.setNom("RENEAU");
//		voitureDaoImp.ModifierVoiture(V);
//	    voitureDaoImp.SupprimerVoiture(V.getId_voiture());
		
		Commentaire C = commentaireDaoImp.AjouterCommentaire(new Commentaire("xxxxxxxxx", new Date(), V, (CompteClient) C1));
		C.setCommentaire("yyyyyyyyyyyyyy");
		commentaireDaoImp.ModifierCommentaire(C);
		
		for(Commentaire commentaire : voitureDaoImp.ListCommentaireVoiture(V.getId_voiture())) {
			System.out.println(commentaire.getCommentaire());
		}
		
		
		Commentaire c1 = commentaireDaoImp.AjouterCommentaire(new Commentaire("xxxxxxxxx", new Date(), V, (CompteClient) C1));
		Commentaire c2 = commentaireDaoImp.AjouterCommentaire(new Commentaire("xxxxxxxxx", new Date(), V2, (CompteClient) C1));

//		voitureDaoImp.SupprimerVoiture(V.getId_voiture());
		
		for (Location location : voitureDaoImp.ListLocationVoiture(V.getId_voiture())) {
			System.out.println("Location"+location.getDate_fin());
		}
		
		Date dt2 = new Date();
		Calendar c21 = Calendar.getInstance(); 
		c21.setTime(dt2); 
		c21.add(Calendar.DATE, 1);
		dt2 = c21.getTime();
		

	}
}
