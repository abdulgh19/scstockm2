package mz.co.devtec.scstockm2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import mz.co.devtec.scstockm2.domain.Tipo;

@Repository
public interface TipoRepository extends JpaRepository<Tipo, Long> {
	
	@Query("select t from Tipo t where t.designacao like :search% ")
	Page<Tipo> findAllByDesignacao(String search, Pageable pageable);
	


}
