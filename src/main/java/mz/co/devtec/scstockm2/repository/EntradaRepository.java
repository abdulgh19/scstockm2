package mz.co.devtec.scstockm2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import mz.co.devtec.scstockm2.domain.Entrada;

@Repository
public interface EntradaRepository extends JpaRepository<Entrada, Long> {
	
	@Query("select e from Entrada e where e.designacao like :search% ")
	Page<Entrada> findAllByDesignacao(String search, Pageable pageable);
	


}
