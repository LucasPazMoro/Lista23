package br.edu.unoesc.exemplo_H2_revisao;

import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.edu.unoesc.exemplo_H2_revisao.model.Livro;
import br.edu.unoesc.exemplo_H2_revisao.repository.LivroRepository;
@SpringBootApplication
public class ExemploH2RevisaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExemploH2RevisaoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(LivroRepository repositorio) {
		return args -> {
			Livro l = new Livro(null, "O senhor dos pastéis", 666, "Tolkien");
			l = repositorio.save(l); //está salvando
			System.out.println(l);
			
			
			
			//repositorio.delete(n); // está deletando
			
			repositorio.save(new Livro(null, "O hobbit", 42, "J.R.R.Tolkien"));	
			
			Optional<Livro> p = repositorio.findById(1);
			if (p.isEmpty()) {
				System.out.println("Registro não encontrado");
			} else {
				System.out.println(p.get());
			}
			
			//l = repositorio.findById(3).get(); // Buscando no repositorio, registro 3, .get para buscar só o livro,
			//l.setTitulo("Título nadaa ver"); // feito as alterações usando o set              //jogando no objeto l    
			//l.setPaginas(100);
			//l.setAutor("Fulano da silva");
			//repositorio.save(l); // salvando as alterações no repositório
			
			//System.out.println(p.get());		
			

			//System.out.println(repositorio.findAll()); //Impressão dos itens lado a lado
			
			for (Livro livro : repositorio.findAll()) { //Impressão itens por linha
				System.out.println(livro);				
			}
			
			//for (var livro : repositorio.findAll()) { //Impressão itens por linha 
				//System.out.println(livro);
			//}
			
			for (var livro : repositorio.findByTituloContainingIgnoreCase("j")) { //Impressão personalizada 
				System.out.println(livro);
			}
			
			for (var livro : repositorio.porQtdPaginas(300)) { //Impressão personalizada 
				System.out.println(livro);
				}
			for (var livro : repositorio.findByFiltro("éi")) { //Impressão personalizada 
				System.out.println(livro);
				}
			
			
		};
	}
}
