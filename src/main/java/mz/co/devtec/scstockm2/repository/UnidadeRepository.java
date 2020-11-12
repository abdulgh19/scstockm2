package mz.co.devtec.scstockm2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import mz.co.devtec.scstockm2.domain.Unidade;

@Repository
public interface UnidadeRepository extends JpaRepository<Unidade, Long> {
	
	@Query("select u from Unidade u where u.designacao like :search% ")
	Page<Unidade> findAllByDesignacao(String search, Pageable pageable);
	


}
