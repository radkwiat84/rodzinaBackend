package radkwiat84.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "children")
public class Child {

	@Id
	@GeneratedValue
	private int id;

	private String firstName;
	private String secondName;
	private String sex;
	private String pesel;

	@ManyToOne
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

	public Child(String firstName, String secondName, String sex, String pesel, Family family) {
		this.firstName = firstName;
		this.secondName = secondName;
		this.sex = sex;
		this.pesel = pesel;
		this.family = family;
	}

	public Child() {
	}

	@Override
	public String toString() {
		return "Child [id=" + id + ", firstName=" + firstName + ", secondName=" + secondName + ", sex=" + sex
				+ ", pesel=" + pesel + ", family=" + family + "]";
	}

}