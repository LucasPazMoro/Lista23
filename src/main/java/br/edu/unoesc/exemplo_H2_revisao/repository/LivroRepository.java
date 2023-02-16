package br.edu.unoesc.exemplo_H2_revisao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.edu.unoesc.exemplo_H2_revisao.model.Livro;

public interface LivroRepository extends CrudRepository<Livro, Integer> {
	public List<Livro> findByTituloContainingIgnoreCase(String titulo);
	
	@Query("select l from Livro l where l.paginas >= :paginas")
	public List<Livro> porQtdPaginas(@Param("paginas") Integer paginas);
	
	//Busca personalizada caseInsensitive
	@Query("select l from Livro l where upper(l.titulo) like upper(concat('%', :filtro, '%')) order by titulo")
	public List<Livro> findByFiltro(@Param("filtro") String filtro);
}
