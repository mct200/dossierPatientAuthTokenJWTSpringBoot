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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "consultation")
@Data @NoArgsConstructor @AllArgsConstructor @ToString  @Getter @Setter
public class Consultation implements Serializable {


	    private static final long serialVersionUID = 1L;

	    @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	    @SequenceGenerator(name = "sequenceGenerator")
	    @Column(name = "id")
	    private Long id;

	    @Column(name = "bilan")
	    private String bilan;

	    @ManyToOne
	    private Patient patient;

	    @ManyToOne
	    private Prescripteur prescripteur;

		public Ordonnance getOrdonnance() {
			// TODO Auto-generated method stub
			return null;
		}

}
