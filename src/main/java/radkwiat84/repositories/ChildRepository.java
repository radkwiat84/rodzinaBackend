package radkwiat84.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import radkwiat84.model.Child;

public interface ChildRepository extends JpaRepository<Child, Integer>, JpaSpecificationExecutor<Child> {

	public List<Child> findByFamilyIdIsNull();

	public List<Child> findAllByFamilyId(Integer id);

	public List<Child> findByFamilyIdIsNotNull();

	@Query("SELECT c FROM Child c WHERE firstName = :firstName OR secondName = :secondName OR pesel = :pesel OR birthDate = :birthDate OR sex = :sex")
	public List<Child> findAllByQuery(@Param("firstName") String firstName, @Param("secondName") String secondName,
			@Param("pesel") String pesel, @Param("birthDate") String birthDate, @Param("sex") String sex);

}
