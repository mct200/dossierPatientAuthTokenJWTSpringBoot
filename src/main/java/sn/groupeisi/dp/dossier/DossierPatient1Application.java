package sn.groupeisi.dp.dossier;

import java.util.Arrays;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import sn.groupeisi.dp.dossier.dao.AntecedentRepository;
import sn.groupeisi.dp.dossier.dao.CahierDesoinRepositiry;
import sn.groupeisi.dp.dossier.dao.ConsultationRepository;
import sn.groupeisi.dp.dossier.dao.DossierRepository;
import sn.groupeisi.dp.dossier.dao.OrdonnanceRepository;
import sn.groupeisi.dp.dossier.dao.PatientRepository;
import sn.groupeisi.dp.dossier.dao.PrescripteurRepository;
import sn.groupeisi.dp.dossier.dao.RdvRepository;
import sn.groupeisi.dp.dossier.dao.SecretaireRepository;
import sn.groupeisi.dp.dossier.dao.TraitantRepository;





@SpringBootApplication
@EntityScan("sn.groupeisi.dp.domain")
@ComponentScan(basePackages="sn.groupeisi.dp")
@EnableAutoConfiguration
public class DossierPatient1Application implements CommandLineRunner {
	PatientRepository patientRepository;
	AntecedentRepository anteceedentRepository;
	CahierDesoinRepositiry cahierDesoinRepository;
	ConsultationRepository consultationRepository;
	DossierRepository dossierRepository;
	OrdonnanceRepository ordannanceRepository;
	PrescripteurRepository prescripteurRepository;
	RdvRepository rdvRepository;
	SecretaireRepository secrtaireRepository;
	TraitantRepository traitantRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DossierPatient1Application.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		
	}
	
	

	 @Bean
	    public CorsFilter corsFilter() {
	        CorsConfiguration corsConfiguration = new CorsConfiguration();
	       
	        corsConfiguration.setAllowCredentials(true);
	        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
	        corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin ", "Content-Type",
	                "Accept", "Authorization", "Origin, Accept", "X-Requested-With",
	                "Access-Control-Request-Method", "Access-Control-Request-Headers"));
	        
	        corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
	                "Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
	        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
	        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
	        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
	        return new CorsFilter(urlBasedCorsConfigurationSource);
	    }
	
     
}

