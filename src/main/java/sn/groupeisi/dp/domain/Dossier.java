package sn.groupeisi.dp.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name = "dossier")
@NoArgsConstructor @AllArgsConstructor @ToString  @Getter @Setter
public class Dossier implements Serializable{
	

	    private static final long serialVersionUID = 1L;

	    @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	    @SequenceGenerator(name = "sequenceGenerator")
	    @Column(name = "id")
	    private Long id;

	    @ManyToOne
	    private Prescripteur prescripteur;
	    private ArrayList<Consultation> consultationList;
		private HashMap<String,String> statistiques;
		@OneToOne
		private Patient patient;
		private ArrayList<Rdv> appointmentList;
}
