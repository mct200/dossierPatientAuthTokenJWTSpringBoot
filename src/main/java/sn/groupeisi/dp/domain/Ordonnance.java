package sn.groupeisi.dp.domain;

import java.io.Serializable;
import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "ordonnance")
@NoArgsConstructor @AllArgsConstructor @ToString  @Getter @Setter

public class Ordonnance implements Serializable{
	
	    private static final long serialVersionUID = 1L;

	    @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	    @SequenceGenerator(name = "sequenceGenerator")
	    @Column(name = "id")
	    private Long id;

	    @Column(name = "date")
	    private LocalDate date;

	    @Column(name = "liste_medoc")
	    private String listeMedoc;

	    @Column(name = "posologie")
	    private String posologie;

	    @ManyToOne
	    private Prescripteur prescripteur;
	    private Prescripteur NomPrescripteur;
		public int getIdOrdonnance() {
			// TODO Auto-generated method stub
			return 0;
		}
	   
}
