package sn.groupeisi.dp.domain;

import java.io.Serializable;
import java.time.Instant;
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
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "rdv")
@Data @NoArgsConstructor @AllArgsConstructor @ToString 
public class Rdv implements Serializable{
	    private static final long serialVersionUID = 1L;

	    @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	    @SequenceGenerator(name = "sequenceGenerator")
	    @Column(name = "id")
	    private Long id;

	    @Column(name = "date")
	    private LocalDate date;

	    @Column(name = "heure")
	    private Instant heure;
	    @ManyToOne
	    private Patient patient;

	    @ManyToOne
	    private Secretaire secretaire;
	    private String Description;
	    private String Type_maladie;
	    private LocalDate date_prise;

}
