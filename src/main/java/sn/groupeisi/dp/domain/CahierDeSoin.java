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
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name = "cahier_de_soin")
@Data @NoArgsConstructor @AllArgsConstructor @ToString  @Getter @Setter
public class CahierDeSoin implements Serializable {
	
	    private static final long serialVersionUID = 1L;

	    @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	    @SequenceGenerator(name = "sequenceGenerator")
	    @Column(name = "id")
	    private Long id;

	    @Column(name = "soin")
	    private String soin;

	    @Column(name = "date")
	    private LocalDate date;

	    @Column(name = "medicament")
	    private String medicament;

	    @ManyToOne
	    private Traitant traitant;
}
