package sn.groupeisi.dp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name = "antecedent")
public class Antecedent implements Serializable {

	    private static final long serialVersionUID = 1L;

	    @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	    @SequenceGenerator(name = "sequenceGenerator")
	    @Column(name = "id")
	    private Long id;

	    @Column(name = "maladie")
	    private String maladie;

	    @Column(name = "allergie")
	    private String allergie;

	    @Column(name = "traitement")
	    private String traitement;

	    @ManyToOne
	    private Patient patient;
}
