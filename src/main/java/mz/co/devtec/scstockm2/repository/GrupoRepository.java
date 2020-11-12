package mz.co.devtec.scstockm2.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import mz.co.devtec.scstockm2.domain.Grupo;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Long> {
	
	@Query("select g from Grupo g where g.designacao like :search% ")
	Page<Grupo> findAllByDesignacao(String search, Pageable pageable);
	
	@Query("select g from Grupo g where g.categoria.id = :idCategoria")
	List<Grupo> findGrupoByIdDeCategoria(Long idCategoria);




}
