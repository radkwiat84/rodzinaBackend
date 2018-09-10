package radkwiat84.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "families")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Family {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToMany(mappedBy = "family", cascade = CascadeType.ALL)
	private List<Child> children;

	@OneToOne(mappedBy = "family", cascade = CascadeType.ALL)
//	@JsonManagedReference
	private Father father;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	 public List<Child> getChildren() {
	 return children;
	 }
	
	 public void setChildren(List<Child> children) {
	 this.children = children;
	 }

	public Father getFather() {
		return father;
	}

	public void setFather(Father father) {
		this.father = father;
	}

	public Family(List<Child> children, Father father) {
		this.children = children;
		this.father = father;
	}

	public Family() {
	}

	@Override
	public String toString() {
		return "Family [id=" + id + ", " + "children=" + children
				+ ", father=" + father + "]";
	}

}
