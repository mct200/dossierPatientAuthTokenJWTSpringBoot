package sn.groupeisi.dp.domain;

import java.io.Serializable;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity


 @NoArgsConstructor @AllArgsConstructor @ToString @Getter @Setter
public class Traitant extends User implements Serializable {
	    private static final long serialVersionUID = 1L;
	    @Id
		@GeneratedValue(strategy=GenerationType.AUTO)
	    @SequenceGenerator(name = "sequenceGenerator")
	    @Column(name = "id")
	    private Long id;

	   
}
