package radkwiat84.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "fathers")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Father {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String firstName;
	private String secondName;
	private String birthDate;
	private String pesel;

	@OneToOne
//	@JsonBackReference
	private Family family;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public Family getFamily() {
		return family;
	}

	public void setFamily(Family family) {
		this.family = family;
	}

	public Father(String firstName, String secondName, String birthDate, String pesel, Family family) {
		this.firstName = firstName;
		this.secondName = secondName;
		this.birthDate = birthDate;
		this.pesel = pesel;
		this.family = family;
	}
	
	

	public Father(String firstName, String secondName, String birthDate, String pesel) {
		this.firstName = firstName;
		this.secondName = secondName;
		this.birthDate = birthDate;
		this.pesel = pesel;
	}

	public Father() {
	}

	@Override
	public String toString() {
		return "Father [id=" + id + ", firstName=" + firstName + ", secondName=" + secondName + ", birthDate="
				+ birthDate + ", pesel=" + pesel + ", family=" + family + "]";
	}

}
