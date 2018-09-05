package radkwiat84.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "families")
public class Family {

	@Id
	@GeneratedValue
	@Column(name = "family_id")
	private int id;

	@OneToMany(mappedBy = "family", cascade = CascadeType.ALL)
	private List<Child> children;

	@OneToOne(mappedBy = "family", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
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
		return "Family [id=" + id + ", children=" + children + ", father=" + father + "]";
	}

}
