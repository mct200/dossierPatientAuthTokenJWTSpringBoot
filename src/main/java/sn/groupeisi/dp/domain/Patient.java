package sn.groupeisi.dp.domain;
import java.io.Serializable;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity

@NoArgsConstructor @AllArgsConstructor @ToString  @Getter @Setter

public class Patient  implements Serializable {
		
	private static final long serialVersionUID = 1L;
		public Patient(Object object, int i) {
		// TODO Auto-generated constructor stub
	}
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Long id;
		private String firstname;
		private String lastname;
		private String email;
		private String address;
		private String age;
		private String sexe;
		private String provenance;
		@Column(name="num_patient")
		@JsonProperty("numPatient")
		private String numPatient;
		
		public String getNumPatient() {
			return numPatient;
		}
		public void setNumPatient(String numPatient) {
			this.numPatient = numPatient;
		}
		
		

}
