package br.edu.unoesc.exemplo_H2_revisao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.exemplo_H2_revisao.model.Livro;
import br.edu.unoesc.exemplo_H2_revisao.repository.LivroRepository;

@RestController
@RequestMapping("/api/livros")
public class LivroController {
	@Autowired // não precisa mais instanciar o objeto, injeção dedendência
	private LivroRepository repositorio; //Acessar diretamente o repositorio
	
	@GetMapping("/find")
	List<Livro> listarComFiltro(@RequestParam("filtro")String filtro){
		return repositorio.findByTituloContainingIgnoreCase(filtro);
	}
	
	//URL digitar: localhost:8080/api/livros/find?filtro=Digitar o filtro
 	
	@GetMapping // get geral. Não foi colocado ("/"), assim ja vai direcionar para ("/api/livros")
	public Iterable<Livro> listarTudo() { //Iterable e listarTudo é goiabinha
		return repositorio.findAll();
	}
	

}
