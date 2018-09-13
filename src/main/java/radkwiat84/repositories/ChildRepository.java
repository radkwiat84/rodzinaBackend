package radkwiat84.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import radkwiat84.model.Child;

public interface ChildRepository extends JpaRepository<Child, Integer> {

	public List<Child> findByFamilyIdIsNull();
	
	public List<Child> findAllByFamilyId(Integer id);	
}
