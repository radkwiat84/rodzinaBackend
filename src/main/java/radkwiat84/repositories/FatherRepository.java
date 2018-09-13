package radkwiat84.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import radkwiat84.model.Father;

public interface FatherRepository extends JpaRepository<Father, Integer> {

	public Father findByFamilyId(Integer id);

	
}

