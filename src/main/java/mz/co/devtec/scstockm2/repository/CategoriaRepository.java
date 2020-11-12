package mz.co.devtec.scstockm2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import mz.co.devtec.scstockm2.domain.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	
	@Query("select c from Categoria c where c.designacao like :search% ")
	Page<Categoria> findAllByDesignacao(String search, Pageable pageable);
	


}
