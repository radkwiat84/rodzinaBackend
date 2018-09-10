package radkwiat84.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "children")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Child {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String firstName;
	private String secondName;
	private String sex;
	private String birthDate;
	private String pesel;

	@ManyToOne
	private Family family;

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
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

	public Child(String firstName, String secondName, String sex, String birthDate, String pesel, Family family) {
		super();
		this.firstName = firstName;
		this.secondName = secondName;
		this.sex = sex;
		this.birthDate = birthDate;
		this.pesel = pesel;
		this.family = family;
	}

	public Child() {
	}

	@Override
	public String toString() {
		return "Child [id=" + id + ", firstName=" + firstName + ", secondName=" + secondName + ", sex=" + sex
				+ ", birthDate=" + birthDate + ", pesel=" + pesel + ", family=" + family + "]";
	}

}