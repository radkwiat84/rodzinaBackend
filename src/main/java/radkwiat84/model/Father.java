package radkwiat84.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "fathers")
public class Father {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "father_id")
	private int id;

	private String firstName;
	private String secondName;
	private Date birthDate;
	private String pesel;

	@OneToOne
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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
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

	public Father(String firstName, String secondName, Date birthDate, String pesel, Family family) {
		this.firstName = firstName;
		this.secondName = secondName;
		this.birthDate = birthDate;
		this.pesel = pesel;
		this.family = family;
	}

	public Father() {
	}

	@Override
	public String toString() {
		return "Father [id=" + id + ", firstName=" + firstName + ", secondName=" + secondName + ", birthDate="
				+ birthDate + ", pesel=" + pesel + ", family=" + family + "]";
	}

}
